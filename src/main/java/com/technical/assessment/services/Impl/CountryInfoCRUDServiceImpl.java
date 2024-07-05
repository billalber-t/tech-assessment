package com.technical.assessment.services.Impl;

import com.technical.assessment.dto.CountryInfoDTO;
import com.technical.assessment.dto.LanguageDTO;
import com.technical.assessment.exception.ResourceNotFoundException;
import com.technical.assessment.models.CountryInfo;
import com.technical.assessment.models.Language;
import com.technical.assessment.repositories.CountryInfoRepository;
import com.technical.assessment.services.CountryInfoCRUDService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CountryInfoCRUDServiceImpl implements CountryInfoCRUDService {

    @Autowired
    private CountryInfoRepository countryInfoRepository;

    @Override
    public List<CountryInfoDTO> getAllCountries() {
        List<CountryInfo> countries = countryInfoRepository.findAll();
        return countries.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CountryInfoDTO getCountryById(Long id) {
        CountryInfo country = countryInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        return convertToDto(country);
    }

    @Override
    public CountryInfoDTO updateCountry(Long id, @Valid CountryInfoDTO countryInfoDTO) {
        CountryInfo existingCountry = countryInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        existingCountry.setIsoCode(countryInfoDTO.getIsoCode());
        existingCountry.setName(countryInfoDTO.getName());
        existingCountry.setCapitalCity(countryInfoDTO.getCapitalCity());
        existingCountry.setPhoneCode(countryInfoDTO.getPhoneCode());
        existingCountry.setContinentCode(countryInfoDTO.getContinentCode());
        existingCountry.setCurrencyIsoCode(countryInfoDTO.getCurrencyIsoCode());
        existingCountry.setCountryFlag(countryInfoDTO.getCountryFlag());
        existingCountry.setLanguages(countryInfoDTO.getLanguages().stream()
                .map(this::convertToEntity).collect(Collectors.toList()));
        CountryInfo updatedCountry = countryInfoRepository.save(existingCountry);
        return convertToDto(updatedCountry);
    }

    @Override
    public void deleteCountry(Long id) {
        CountryInfo existingCountry = countryInfoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        countryInfoRepository.delete(existingCountry);
    }

    private CountryInfoDTO convertToDto(CountryInfo countryInfo) {
        CountryInfoDTO dto = new CountryInfoDTO();
//        dto.setId(countryInfo.getId());
        dto.setIsoCode(countryInfo.getIsoCode());
        dto.setName(countryInfo.getName());
        dto.setCapitalCity(countryInfo.getCapitalCity());
        dto.setPhoneCode(countryInfo.getPhoneCode());
        dto.setContinentCode(countryInfo.getContinentCode());
        dto.setCurrencyIsoCode(countryInfo.getCurrencyIsoCode());
        dto.setCountryFlag(countryInfo.getCountryFlag());
        dto.setLanguages(countryInfo.getLanguages().stream()
                .map(this::convertToDto).collect(Collectors.toList()));
        return dto;
    }

    private LanguageDTO convertToDto(Language language) {
        LanguageDTO dto = new LanguageDTO();
//        dto.setId(language.getId());
        dto.setIsoCode(language.getIsoCode());
        dto.setName(language.getName());
        return dto;
    }

    private CountryInfo convertToEntity(CountryInfoDTO countryInfoDTO) {
        CountryInfo entity = new CountryInfo();
        entity.setIsoCode(countryInfoDTO.getIsoCode());
        entity.setName(countryInfoDTO.getName());
        entity.setCapitalCity(countryInfoDTO.getCapitalCity());
        entity.setPhoneCode(countryInfoDTO.getPhoneCode());
        entity.setContinentCode(countryInfoDTO.getContinentCode());
        entity.setCurrencyIsoCode(countryInfoDTO.getCurrencyIsoCode());
        entity.setCountryFlag(countryInfoDTO.getCountryFlag());
        entity.setLanguages(countryInfoDTO.getLanguages().stream()
                .map(this::convertToEntity).collect(Collectors.toList()));
        return entity;
    }

    private Language convertToEntity(LanguageDTO languageDTO) {
        Language entity = new Language();
        entity.setIsoCode(languageDTO.getIsoCode());
        entity.setName(languageDTO.getName());
        return entity;
    }
}
