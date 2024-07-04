package com.technical.assessment.services;

import com.technical.assessment.dto.FullCountryInfoDTO;
import com.technical.assessment.dto.LanguageDTO;
import com.technical.assessment.repositories.CountryInfoRepository;
import com.technical.assessment.repositories.LanguageRepository;
import com.technical.assessment.models.CountryInfo;
import com.technical.assessment.models.Language;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class CountryInfoService {

    @Autowired
    private CountryInfoRepository countryInfoRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public String getCountryIsoCode(String countryName) {
        String apiUrl = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
        String requestXml = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <web:CountryISOCode>\n" +
                "         <web:sCountryName>" + countryName + "</web:sCountryName>\n" +
                "      </web:CountryISOCode>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            connection.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(requestXml);
                wr.flush();
            }

            int responseCode = connection.getResponseCode();
            log.info("Response Code: " + responseCode);

            StringBuilder response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            String responseXml = response.toString();
            log.info("Response XML: \n" + responseXml);

            // Extract the ISO code from the response XML
            String isoCode = extractIsoCode(responseXml);
            log.info("Country ISO Code: " + isoCode);

            return isoCode;

        } catch (Exception e) {
            log.error("Error while calling SOAP API", e);
            return null;
        }
    }

    private String extractIsoCode(String responseXml) {
        String patternString = "<m:CountryISOCodeResult>(.*?)</m:CountryISOCodeResult>";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(responseXml);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }


    public FullCountryInfoDTO getFullCountryInfo(String isoCode) {
        String apiUrl = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
        String requestXml = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <web:FullCountryInfo>\n" +
                "         <web:sCountryISOCode>" + isoCode + "</web:sCountryISOCode>\n" +
                "      </web:FullCountryInfo>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            connection.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(requestXml);
                wr.flush();
            }

            int responseCode = connection.getResponseCode();
            log.info("Response Code: " + responseCode);

            StringBuilder response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }

            String responseXml = response.toString();
            log.info("Response XML: \n" + responseXml);

            // Extract full country info from the response XML
            return extractFullCountryInfo(responseXml);

        } catch (Exception e) {
            log.error("Error while calling SOAP API", e);
            return null;
        }
    }

    private FullCountryInfoDTO extractFullCountryInfo(String responseXml) {
        FullCountryInfoDTO countryInfo = new FullCountryInfoDTO();

        String patternString = "<m:FullCountryInfoResult>(.*?)</m:FullCountryInfoResult>";
        Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(responseXml);

        if (matcher.find()) {
            String countryInfoXml = matcher.group(1);

            countryInfo.setIsoCode(extractTagValue(countryInfoXml, "m:sISOCode"));
            countryInfo.setName(extractTagValue(countryInfoXml, "m:sName"));
            countryInfo.setCapitalCity(extractTagValue(countryInfoXml, "m:sCapitalCity"));
            countryInfo.setPhoneCode(extractTagValue(countryInfoXml, "m:sPhoneCode"));
            countryInfo.setContinentCode(extractTagValue(countryInfoXml, "m:sContinentCode"));
            countryInfo.setCurrencyIsoCode(extractTagValue(countryInfoXml, "m:sCurrencyISOCode"));
            countryInfo.setCountryFlag(extractTagValue(countryInfoXml, "m:sCountryFlag"));

            // Handle languages (if needed)
        }

        return countryInfo;
    }

    private void saveCountryInfo(FullCountryInfoDTO fullCountryInfoDTO) {
        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setIsoCode(fullCountryInfoDTO.getIsoCode());
        countryInfo.setName(fullCountryInfoDTO.getName());
        countryInfo.setCapitalCity(fullCountryInfoDTO.getCapitalCity());
        countryInfo.setPhoneCode(fullCountryInfoDTO.getPhoneCode());
        countryInfo.setContinentCode(fullCountryInfoDTO.getContinentCode());
        countryInfo.setCurrencyIsoCode(fullCountryInfoDTO.getCurrencyIsoCode());
        countryInfo.setCountryFlag(fullCountryInfoDTO.getCountryFlag());

        List<Language> languages = new ArrayList<>();
        for (LanguageDTO languageDTO : fullCountryInfoDTO.getLanguages()) {
            Language language = new Language();
            language.setIsoCode(languageDTO.getIsoCode());
            language.setName(languageDTO.getName());
            language.setCountryInfo(countryInfo);
            languages.add(language);
        }
        countryInfo.setLanguages(languages);

        countryInfoRepository.save(countryInfo);
        languageRepository.saveAll(languages);
    }


    private String extractTagValue(String xml, String tagName) {
        String patternString = "<" + tagName + ">(.*?)</" + tagName + ">";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(xml);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
