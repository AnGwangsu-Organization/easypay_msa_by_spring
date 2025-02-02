package com.fastcampuspay.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {
    @Getter private final String membershipId;

    @Getter private final String name;

    @Getter private final String email;

    @Getter private final String address;

    @Getter private final boolean isValid;

    @Getter private final String aggregateIdentifier;

    // * Membership 오염이 되면 안되는 클래스
    // * 고객 정보, 핵심 도메인 -> 안전하게 관리 필요(private하게 접근)

    public static Membership generateMember(
            MembershipId membershipId,
            MembershipName membershipName,
            MembershipEmail membershipEmail,
            MembershipAddress membershipAddress,
            MembershipIsValid membershipIsValid,
            MembershipAggregateIdentifier membershipAggregateIdentifier
    ) {
      return new Membership(
              membershipId.membershipId,
              membershipName.membershipName,
              membershipEmail.membershipEmail,
              membershipAddress.membershipAddress,
              membershipIsValid.membershipIsValid,
              membershipAggregateIdentifier.aggregateIdentifier
      );
    }


    // * 싱글톤 패턴
    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId;
    }
    @Value
    public static class MembershipName {
        public MembershipName(String value) {
            this.membershipName = value;
        }
        String membershipName;
    }
    @Value
    public static class MembershipEmail {
        public MembershipEmail(String value) {
            this.membershipEmail = value;
        }
        String membershipEmail;
    }
    @Value
    public static class MembershipAddress {
        public MembershipAddress(String value) {
            this.membershipAddress = value;
        }
        String membershipAddress;
    }
    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.membershipIsValid = value;
        }
        boolean membershipIsValid;
    }
    @Value
    public static class MembershipAggregateIdentifier {
        public MembershipAggregateIdentifier(String value) {
            this.aggregateIdentifier = value;
        }
        String aggregateIdentifier;
    }
}
