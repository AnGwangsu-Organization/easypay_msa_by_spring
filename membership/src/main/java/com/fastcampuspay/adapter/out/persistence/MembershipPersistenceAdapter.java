package com.fastcampuspay.adapter.out.persistence;

import com.fastcampuspay.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {
    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public void createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipAggregateIdentifier membershipIsCorp) {
        membershipRepository.save(
                new MembershipJpaEntity(membershipName.getMembershipName(), membershipEmail.getMembershipEmail(), membershipAddress.getMembershipAddress(), membershipIsValid.isMembershipIsValid(), membershipIsCorp.getAggregateIdentifier())
        );
    }
}
