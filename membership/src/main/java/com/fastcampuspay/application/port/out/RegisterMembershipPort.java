package com.fastcampuspay.application.port.out;

import com.fastcampuspay.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.domain.Membership;

public interface RegisterMembershipPort {
    MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
    );
}
