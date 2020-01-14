package io.example_test;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper class on Rest Assured for reusable functions and to report response
 */
public class RestWrapper {

    /**
     * Method to get the GET API
     * @param path API URL
     * @return API response
     */
    public Response getCountry(String path) {
        Map<String, String> headers=new HashMap<>();
        headers.put("X-RapidAPI-Host","restcountries-v1.p.rapidapi.com");
        headers.put("X-RapidAPI-Key","8bcb167f50msh8c2f0f0c3daa81ep162e14jsn12daa5cf7d03");
        return SerenityRest.given().headers(headers).get(path);
    }

    /**
     * Method to verify the status code
     * @param response API Response
     */
    public void verifyStatusCode(Response response){
        response.then().statusCode(200);
    }
}
