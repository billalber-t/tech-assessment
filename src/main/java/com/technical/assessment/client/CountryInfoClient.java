package com.technical.assessment.client;

import com.technical.assessment.soapclient.CountryISOCode;
import com.technical.assessment.soapclient.CountryISOCodeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryInfoClient extends WebServiceGatewaySupport {

    public String getCountryISOCode(String countryName) {
        CountryISOCode request = new CountryISOCode();
        request.setSCountryName(countryName);

        CountryISOCodeResponse response = (CountryISOCodeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso", request);

        return response.getCountryISOCodeResult();
    }
}
