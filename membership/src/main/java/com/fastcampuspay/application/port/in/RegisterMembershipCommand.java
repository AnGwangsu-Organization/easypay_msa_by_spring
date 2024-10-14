package com.fastcampuspay.application.port.in;

import com.fastcampuspay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    // * 필드의 조건을 선언적으로
    @NotNull
    @NotBlank
    private final String name;

    @NotNull
    @NotBlank
    private final String email;

    @NotNull
    private final String address;

    // * 항상 true 라 가정
    @AssertTrue
    private final boolean isValid;

    private final String aggregateIdentifier;




    public RegisterMembershipCommand(String name, String email, String address, boolean isValid, String aggregateIdentifier) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.aggregateIdentifier = aggregateIdentifier;

        // * value에 대한 exception
        this.validateSelf();
    }
}
