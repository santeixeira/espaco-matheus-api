package com.espaco.api.validators;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewsDTO(
        @NotNull @NotEmpty String title,
        @NotNull @NotEmpty String image,
        @NotNull @NotEmpty String description
) {
}
