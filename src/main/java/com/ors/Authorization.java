package com.ors;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Authorization {
    private ConfigReader configReader;

    public Authorization(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public String authenticate() {
        String login = configReader.getProperty("login");
        String password = configReader.getProperty("password");
        String apiUrl = configReader.getProperty("apiUrl");

        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"login\": \"" + login + "\", \"password\": \"" + password + "\"}")
                .post(apiUrl);

        int statusCode = response.getStatusCode();
        if (statusCode == 200) {
            String token = response.jsonPath().getString("token");
            return token;
        } else {
            System.out.println("Failed to authenticate. Status code: " + statusCode);
            return null;
        }
    }
}
