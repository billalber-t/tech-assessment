package com.technical.assessment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class FullCountryInfoDTO {

    @NotNull(message = "ISO Code cannot be null")
    private String isoCode;

    @NotNull(message = "Name cannot be null")
    private String name;
    private String capitalCity;
    private String phoneCode;
    private String continentCode;
    private String currencyIsoCode;
    private String countryFlag;
    private List<LanguageDTO> languages;
}
