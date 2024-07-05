package com.technical.assessment.controllers;

import com.technical.assessment.dto.CountryInfoDTO;
import com.technical.assessment.response.CountryInfoResponse;
import com.technical.assessment.services.CountryInfoCRUDService;
import com.technical.assessment.services.CountryInfoService;
import com.technical.assessment.dto.CountryDTO;
import com.technical.assessment.util.StringUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryInfoService countryInfoService;

    @Autowired
    private CountryInfoCRUDService countryInfoCRUDService;

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

    @PostMapping("/fullInfo")
    public CountryInfoDTO getFullCountryInfo(@RequestBody CountryDTO countryDTO) {
        // Convert country name to sentence case
        String countryName = StringUtil.toSentenceCase(countryDTO.getName());
        // Get ISO code
        String isoCode = countryInfoService.getCountryIsoCode(countryName);
        // Get full country info
        return countryInfoService.getFullCountryInfo(isoCode);

    }

    // Save Country Info to database
    @PostMapping("/saveInfo")
    public CountryInfoDTO saveCountryInfo(@RequestBody CountryDTO countryDTO) {
        // Convert country name to sentence case
        String countryName = StringUtil.toSentenceCase(countryDTO.getName());
        // Get ISO code
        String isoCode = countryInfoService.getCountryIsoCode(countryName);
        // Get full country info
        CountryInfoDTO country =  countryInfoService.getFullCountryInfo(isoCode);
        // Save country to DB
        countryInfoService.saveCountryInfo(country);

        return country;

    }

    // Fetch all countries
    @GetMapping
    public ResponseEntity<List<CountryInfoDTO>> getAllCountries() {
        List<CountryInfoDTO> countries = countryInfoCRUDService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    // Fetch country by ID
    @GetMapping("/{id}")
    public ResponseEntity<CountryInfoDTO> getCountryById(@PathVariable Long id) {
        CountryInfoDTO countryInfoDTO = countryInfoCRUDService.getCountryById(id);
        if (countryInfoDTO != null) {
            return ResponseEntity.ok(countryInfoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update country information
    @PutMapping("/{id}")
    public ResponseEntity<CountryInfoDTO> updateCountry(
            @PathVariable Long id,
            @Valid @RequestBody CountryInfoDTO countryRequestDTO) {
        CountryInfoDTO updatedCountry = countryInfoCRUDService.updateCountry(id, countryRequestDTO);
        if (updatedCountry != null) {
            return ResponseEntity.ok(updatedCountry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete country
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
//        boolean deleted = countryInfoCRUDService.deleteCountry(id);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        log.info("Deleting country with id: {}", id);
        countryInfoCRUDService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }

}
