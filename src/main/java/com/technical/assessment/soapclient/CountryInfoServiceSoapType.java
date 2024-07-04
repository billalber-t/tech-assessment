
package com.technical.assessment.soapclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CountryInfoServiceSoapType", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CountryInfoServiceSoapType {


    /**
     * Returns a list of continents ordered by name.
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftContinent
     */
    @WebMethod(operationName = "ListOfContinentsByName")
    @WebResult(name = "ListOfContinentsByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfContinentsByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfContinentsByName")
    @ResponseWrapper(localName = "ListOfContinentsByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfContinentsByNameResponse")
    public ArrayOftContinent listOfContinentsByName();

    /**
     * Returns a list of continents ordered by code.
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftContinent
     */
    @WebMethod(operationName = "ListOfContinentsByCode")
    @WebResult(name = "ListOfContinentsByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfContinentsByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfContinentsByCode")
    @ResponseWrapper(localName = "ListOfContinentsByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfContinentsByCodeResponse")
    public ArrayOftContinent listOfContinentsByCode();

    /**
     * Returns a list of currencies ordered by name.
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCurrency
     */
    @WebMethod(operationName = "ListOfCurrenciesByName")
    @WebResult(name = "ListOfCurrenciesByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfCurrenciesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCurrenciesByName")
    @ResponseWrapper(localName = "ListOfCurrenciesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCurrenciesByNameResponse")
    public ArrayOftCurrency listOfCurrenciesByName();

    /**
     * Returns a list of currencies ordered by code.
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCurrency
     */
    @WebMethod(operationName = "ListOfCurrenciesByCode")
    @WebResult(name = "ListOfCurrenciesByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfCurrenciesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCurrenciesByCode")
    @ResponseWrapper(localName = "ListOfCurrenciesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCurrenciesByCodeResponse")
    public ArrayOftCurrency listOfCurrenciesByCode();

    /**
     * Returns the name of the currency (if found)
     * 
     * @param sCurrencyISOCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CurrencyName")
    @WebResult(name = "CurrencyNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CurrencyName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CurrencyName")
    @ResponseWrapper(localName = "CurrencyNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CurrencyNameResponse")
    public String currencyName(
        @WebParam(name = "sCurrencyISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCurrencyISOCode);

    /**
     * Returns a list of all stored counties ordered by ISO code
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCountryCodeAndName
     */
    @WebMethod(operationName = "ListOfCountryNamesByCode")
    @WebResult(name = "ListOfCountryNamesByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfCountryNamesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCountryNamesByCode")
    @ResponseWrapper(localName = "ListOfCountryNamesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCountryNamesByCodeResponse")
    public ArrayOftCountryCodeAndName listOfCountryNamesByCode();

    /**
     * Returns a list of all stored counties ordered by country name
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCountryCodeAndName
     */
    @WebMethod(operationName = "ListOfCountryNamesByName")
    @WebResult(name = "ListOfCountryNamesByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfCountryNamesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCountryNamesByName")
    @ResponseWrapper(localName = "ListOfCountryNamesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCountryNamesByNameResponse")
    public ArrayOftCountryCodeAndName listOfCountryNamesByName();

    /**
     * Returns a list of all stored counties grouped per continent
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCountryCodeAndNameGroupedByContinent
     */
    @WebMethod(operationName = "ListOfCountryNamesGroupedByContinent")
    @WebResult(name = "ListOfCountryNamesGroupedByContinentResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfCountryNamesGroupedByContinent", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCountryNamesGroupedByContinent")
    @ResponseWrapper(localName = "ListOfCountryNamesGroupedByContinentResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfCountryNamesGroupedByContinentResponse")
    public ArrayOftCountryCodeAndNameGroupedByContinent listOfCountryNamesGroupedByContinent();

    /**
     * Searches the database for a country by the passed ISO country code
     * 
     * @param sCountryISOCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CountryName")
    @WebResult(name = "CountryNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CountryName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryName")
    @ResponseWrapper(localName = "CountryNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryNameResponse")
    public String countryName(
        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryISOCode);

    /**
     * This function tries to found a country based on the passed country name.
     * 
     * @param sCountryName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CountryISOCode")
    @WebResult(name = "CountryISOCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryISOCode")
    @ResponseWrapper(localName = "CountryISOCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryISOCodeResponse")
    public String countryISOCode(
        @WebParam(name = "sCountryName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryName);

    /**
     * Returns the  name of the captial city for the passed country code
     * 
     * @param sCountryISOCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CapitalCity")
    @WebResult(name = "CapitalCityResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CapitalCity", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CapitalCity")
    @ResponseWrapper(localName = "CapitalCityResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CapitalCityResponse")
    public String capitalCity(
        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryISOCode);

    /**
     * Returns the currency ISO code and name for the passed country ISO code
     * 
     * @param sCountryISOCode
     * @return
     *     returns com.technical.assessment.soapclient.TCurrency
     */
    @WebMethod(operationName = "CountryCurrency")
    @WebResult(name = "CountryCurrencyResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CountryCurrency", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryCurrency")
    @ResponseWrapper(localName = "CountryCurrencyResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryCurrencyResponse")
    public TCurrency countryCurrency(
        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryISOCode);

    /**
     * Returns a link to a picture of the country flag
     * 
     * @param sCountryISOCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CountryFlag")
    @WebResult(name = "CountryFlagResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CountryFlag", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryFlag")
    @ResponseWrapper(localName = "CountryFlagResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryFlagResponse")
    public String countryFlag(
        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryISOCode);

    /**
     * Returns the internation phone code for the passed ISO country code
     * 
     * @param sCountryISOCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CountryIntPhoneCode")
    @WebResult(name = "CountryIntPhoneCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CountryIntPhoneCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryIntPhoneCode")
    @ResponseWrapper(localName = "CountryIntPhoneCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountryIntPhoneCodeResponse")
    public String countryIntPhoneCode(
        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryISOCode);

    /**
     * Returns a struct with all the stored country information. Pass the ISO country code
     * 
     * @param sCountryISOCode
     * @return
     *     returns com.technical.assessment.soapclient.TCountryInfo
     */
    @WebMethod(operationName = "FullCountryInfo")
    @WebResult(name = "FullCountryInfoResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "FullCountryInfo", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.FullCountryInfo")
    @ResponseWrapper(localName = "FullCountryInfoResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.FullCountryInfoResponse")
    public TCountryInfo fullCountryInfo(
        @WebParam(name = "sCountryISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sCountryISOCode);

    /**
     * Returns an array with all countries and all the language information stored
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCountryInfo
     */
    @WebMethod(operationName = "FullCountryInfoAllCountries")
    @WebResult(name = "FullCountryInfoAllCountriesResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "FullCountryInfoAllCountries", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.FullCountryInfoAllCountries")
    @ResponseWrapper(localName = "FullCountryInfoAllCountriesResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.FullCountryInfoAllCountriesResponse")
    public ArrayOftCountryInfo fullCountryInfoAllCountries();

    /**
     * Returns a list of all countries that use the same currency code. Pass a ISO currency code
     * 
     * @param sISOCurrencyCode
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftCountryCodeAndName
     */
    @WebMethod(operationName = "CountriesUsingCurrency")
    @WebResult(name = "CountriesUsingCurrencyResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "CountriesUsingCurrency", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountriesUsingCurrency")
    @ResponseWrapper(localName = "CountriesUsingCurrencyResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.CountriesUsingCurrencyResponse")
    public ArrayOftCountryCodeAndName countriesUsingCurrency(
        @WebParam(name = "sISOCurrencyCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sISOCurrencyCode);

    /**
     * Returns an array of languages ordered by name
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftLanguage
     */
    @WebMethod(operationName = "ListOfLanguagesByName")
    @WebResult(name = "ListOfLanguagesByNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfLanguagesByName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfLanguagesByName")
    @ResponseWrapper(localName = "ListOfLanguagesByNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfLanguagesByNameResponse")
    public ArrayOftLanguage listOfLanguagesByName();

    /**
     * Returns an array of languages ordered by code
     * 
     * @return
     *     returns com.technical.assessment.soapclient.ArrayOftLanguage
     */
    @WebMethod(operationName = "ListOfLanguagesByCode")
    @WebResult(name = "ListOfLanguagesByCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "ListOfLanguagesByCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfLanguagesByCode")
    @ResponseWrapper(localName = "ListOfLanguagesByCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.ListOfLanguagesByCodeResponse")
    public ArrayOftLanguage listOfLanguagesByCode();

    /**
     * Find a language name based on the passed ISO language code
     * 
     * @param sISOCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LanguageName")
    @WebResult(name = "LanguageNameResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "LanguageName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.LanguageName")
    @ResponseWrapper(localName = "LanguageNameResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.LanguageNameResponse")
    public String languageName(
        @WebParam(name = "sISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sISOCode);

    /**
     * Find a language ISO code based on the passed language name
     * 
     * @param sLanguageName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "LanguageISOCode")
    @WebResult(name = "LanguageISOCodeResult", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
    @RequestWrapper(localName = "LanguageISOCode", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.LanguageISOCode")
    @ResponseWrapper(localName = "LanguageISOCodeResponse", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo", className = "com.technical.assessment.soapclient.LanguageISOCodeResponse")
    public String languageISOCode(
        @WebParam(name = "sLanguageName", targetNamespace = "http://www.oorsprong.org/websamples.countryinfo")
        String sLanguageName);

}
