package com.fastcampuspay.adapter.in.web;

import com.fastcampuspay.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path = "/membership/register")
    void registerMembership(@RequestBody RegisterMembershipRequest dto) {
        // * request
        // * request -> command(request로 부터 받은 데이터를 command로 가공)
        // * usecase (command를 가져옴)
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .isValid(true)
                .aggregateIdentifier(dto.getAggregateIdentifier())
                .build();
        registerMembershipUseCase.registerMembership(command);
    }
}
