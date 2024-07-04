package com.technical.assessment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isoCode;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_info_id")
    private CountryInfo countryInfo;
}
