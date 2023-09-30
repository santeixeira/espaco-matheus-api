package com.espaco.api.validators;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record GalleryDTO(
        @NotNull @NotEmpty String description
) {
}
