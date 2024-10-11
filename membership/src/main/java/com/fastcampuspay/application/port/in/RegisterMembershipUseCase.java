package com.fastcampuspay.application.port.in;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.domain.Membership;

@UseCase
public interface RegisterMembershipUseCase {
    Membership registerMembership(RegisterMembershipCommand command);
}
