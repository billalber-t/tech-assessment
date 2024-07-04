package com.technical.assessment.controllers;

import com.technical.assessment.response.CountryInfoResponse;
import com.technical.assessment.services.CountryInfoService;
import com.technical.assessment.dto.CountryDTO;
import com.technical.assessment.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryInfoService countryInfoService;

    @PostMapping("/isoCode")
    public CountryInfoResponse getCountryIsoCode(@RequestBody CountryDTO countryDTO) {
        // Convert country name to sentence case
        String countryName = StringUtil.toSentenceCase(countryDTO.getName());
        // Get ISO code
        String isoCode = countryInfoService.getCountryIsoCode(countryName);
        // Return response
        CountryInfoResponse response = new CountryInfoResponse();
        response.setIsoCode(isoCode);
        return response;
    }

}
