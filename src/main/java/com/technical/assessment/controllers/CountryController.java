package com.technical.assessment.controllers;

import com.technical.assessment.client.CountryInfoClient;
import com.technical.assessment.dto.CountryDTO;
import com.technical.assessment.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryInfoClient countryInfoClient;

    @PostMapping("/country")
    public CountryDTO processCountry(@RequestBody CountryDTO countryDTO) {
        String sentenceCaseName = StringUtil.toSentenceCase(countryDTO.getName());
        countryDTO.setName(sentenceCaseName);

        // Call the SOAP service to get the ISO code
        String isoCode = countryInfoClient.getCountryISOCode(sentenceCaseName);
        countryDTO.setIsoCode(isoCode);

        return countryDTO;
    }


}
