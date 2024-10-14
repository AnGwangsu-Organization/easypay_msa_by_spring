package com.fastcampuspay.application.service.command;

import com.fastcampuspay.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {
    private final MembershipMapper membershipMapper;
    private final RegisterMembershipPort registerMembershipPort;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipAggregateIdentifier(command.getAggregateIdentifier())
        );
        return membershipMapper.toModel(jpaEntity);
    }
}
