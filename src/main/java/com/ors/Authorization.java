package com.ors;

import com.ors.ConfigReader;
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

        if (response.getStatusCode() == 200) {
            return response.getBody().jsonPath().getString("token");
        } else {
            return null;
        }
    }
}