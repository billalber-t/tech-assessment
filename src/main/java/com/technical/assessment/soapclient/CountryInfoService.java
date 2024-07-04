
package com.technical.assessment.soapclient;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This DataFlex Web Service opens up country information. 2 letter ISO codes are used for Country code. There are functions to retrieve the used Currency, Language, Capital City, Continent and Telephone code.
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CountryInfoService", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", wsdlLocation = "http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL")
public class CountryInfoService
    extends Service
{

    private final static URL COUNTRYINFOSERVICE_WSDL_LOCATION;
    private final static WebServiceException COUNTRYINFOSERVICE_EXCEPTION;
    private final static QName COUNTRYINFOSERVICE_QNAME = new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COUNTRYINFOSERVICE_WSDL_LOCATION = url;
        COUNTRYINFOSERVICE_EXCEPTION = e;
    }

    public CountryInfoService() {
        super(__getWsdlLocation(), COUNTRYINFOSERVICE_QNAME);
    }

    public CountryInfoService(WebServiceFeature... features) {
        super(__getWsdlLocation(), COUNTRYINFOSERVICE_QNAME, features);
    }

    public CountryInfoService(URL wsdlLocation) {
        super(wsdlLocation, COUNTRYINFOSERVICE_QNAME);
    }

    public CountryInfoService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COUNTRYINFOSERVICE_QNAME, features);
    }

    public CountryInfoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CountryInfoService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap() {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"), CountryInfoServiceSoapType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CountryInfoServiceSoapType
     */
    @WebEndpoint(name = "CountryInfoServiceSoap")
    public CountryInfoServiceSoapType getCountryInfoServiceSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoServiceSoap"), CountryInfoServiceSoapType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COUNTRYINFOSERVICE_EXCEPTION!= null) {
            throw COUNTRYINFOSERVICE_EXCEPTION;
        }
        return COUNTRYINFOSERVICE_WSDL_LOCATION;
    }

}
