package com.technical.assessment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
public class CountryInfoDTO {

    @NotBlank(message = "ISO code is required")
    @Size(min = 2, max = 3, message = "ISO code must be between 2 and 3 characters")
    private String isoCode;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Capital city is required")
    private String capitalCity;

    @NotBlank(message = "Phone code is required")
    private String phoneCode;

    @NotBlank(message = "Continent code is required")
    private String continentCode;

    @NotBlank(message = "Currency ISO code is required")
    private String currencyIsoCode;

    @NotBlank(message = "Country flag URL is required")
    private String countryFlag;

    private List<LanguageDTO> languages;
}
