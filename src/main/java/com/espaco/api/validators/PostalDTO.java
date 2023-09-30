package com.espaco.api.validators;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record PostalDTO (
        @NotNull @NotEmpty
        String name,
        @NotNull @NotEmpty
        String phone,
        @NotNull @NotEmpty @Email
        String email,
        @NotNull @NotEmpty @Length(max = 800)
        String message
) {
}
