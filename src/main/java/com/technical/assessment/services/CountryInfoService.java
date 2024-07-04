package com.technical.assessment.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class CountryInfoService {

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
}
