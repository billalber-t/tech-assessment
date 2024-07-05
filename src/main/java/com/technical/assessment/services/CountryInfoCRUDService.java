package com.technical.assessment.services;

import com.technical.assessment.dto.CountryInfoDTO;

import java.util.List;

public interface CountryInfoCRUDService {
    List<CountryInfoDTO> getAllCountries();
    CountryInfoDTO getCountryById(Long id);
//    CountryInfoDTO createCountry(CountryInfoDTO fullCountryInfoDTO);
    CountryInfoDTO updateCountry(Long id, CountryInfoDTO fullCountryInfoDTO);
    void deleteCountry(Long id);
}
