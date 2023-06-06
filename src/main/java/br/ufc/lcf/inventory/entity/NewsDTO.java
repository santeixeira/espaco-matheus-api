package br.ufc.lcf.inventory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record NewsDTO(
        @NotNull @NotEmpty String title,
        @NotNull @NotEmpty String image,
        @NotNull @NotEmpty String description
) {
}
