package com.technical.assessment.repositories;

import com.technical.assessment.models.CountryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryInfoRepository extends JpaRepository<CountryInfo, Long> {

}
