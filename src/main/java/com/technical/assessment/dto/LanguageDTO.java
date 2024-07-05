package com.technical.assessment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageDTO {

    @NotBlank(message = "Language ISO code is required")
    private String isoCode;

    @NotBlank(message = "Language name is required")
    private String name;
}
