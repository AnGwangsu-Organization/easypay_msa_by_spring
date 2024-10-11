package com.fastcampuspay.application.service.command;

import com.fastcampuspay.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.domain.Membership;

public class RegisterMembershipService implements RegisterMembershipUseCase {
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // todo : command -> DB
        // todo : DB -> 결과값 return
        // todo : port, adapter를 통해서 DB에 도달해야함
        return null;
    }
}
