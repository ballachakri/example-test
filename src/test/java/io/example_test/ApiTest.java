package io.example_test;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ApiTest {

@Steps
RestWrapper restWrapper;

    /**
     * Test to verify all CountrIes API
     */
    @Test
public void getAllCountries() {
    Response response=restWrapper.getCountry("https://restcountries-v1.p.rapidapi.com/all");
    restWrapper.verifyStatusCode(response);
    //Country[] countries=response.as(Country[].class);
    //Assert.asserEquals(205,counties.lenght());

}

    /**
     * Test to verify country by code
     */
public void getCountryByCode(){
    Response response = restWrapper.getCountry("https://restcountries-v1.p.rapidapi.com/alpha/ru");
    restWrapper.verifyStatusCode(response);
//    Country country = response.as(Country.class);
//    Assert.assertEquals("Russia", country.getName());
}

/**
 * Test to verify country by capital and calling code
 */
public void verifyCountryByCapitalAndCallingCode() {
    Response responseForCapital = restWrapper.getCountry("https://restcountries-v1.p.rapidapi.com/capital/tallinn");
    restWrapper.verifyStatusCode(responseForCapital);
    Response responseForCallingCode = restWrapper.getCountry("https://restcountries-v1.p.rapidapi.com/callingcode/372");
    restWrapper.verifyStatusCode(responseForCallingCode);
//    Country[] countriesForCode = responseForCapital.as(Country[].class);
//    Country[] countriesForCallingCode = responseForCallingCode.as(Country[].class);
//    Assert.assertEquals(countriesForCode[0].getName(), countriesForCallingCode[0].getName());
}
}
