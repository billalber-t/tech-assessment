package com.technical.assessment.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryInfoResponse {

    private String isoCode;
    private String name;
    private String capitalCity;
    private String phoneCode;
    private String continentCode;
    private String currencyIsoCode;
    private String countryFlag;
}
