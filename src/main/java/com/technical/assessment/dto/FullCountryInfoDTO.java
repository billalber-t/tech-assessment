package com.technical.assessment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullCountryInfoDTO {
    private String isoCode;
    private String name;
    private String capitalCity;
    private String phoneCode;
    private String continentCode;
    private String currencyIsoCode;
    private String countryFlag;
}
