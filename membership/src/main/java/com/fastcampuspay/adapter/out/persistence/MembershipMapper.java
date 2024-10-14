package com.fastcampuspay.adapter.out.persistence;

import com.fastcampuspay.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {
    public Membership toModel(MembershipJpaEntity entity) {
        return Membership.generateMember(
                new Membership.MembershipId(entity.getMembershipId()+""),
                new Membership.MembershipName(entity.getName()),
                new Membership.MembershipEmail(entity.getEmail()),
                new Membership.MembershipAddress(entity.getAddress()),
                new Membership.MembershipIsValid(entity.isValid()),
                new Membership.MembershipAggregateIdentifier(entity.getAggregateIdentifier())
        );
    }

    public MembershipJpaEntity toEntity(Membership model) {
        return new MembershipJpaEntity(
                model.getName(),
                model.getEmail(),
                model.getAddress(),
                model.isValid(),
                model.getAggregateIdentifier()
        );
    }
}
