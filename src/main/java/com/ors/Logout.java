package com.ors;

import com.ors.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Logout {
    private ConfigReader configReader;

    public Logout(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public void logout(String authToken) {
        String logoutUrl = configReader.getProperty("logoutUrl");

        Response response = given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .post(logoutUrl);

        int statusCode = response.getStatusCode();
        if (statusCode == 204) {
            System.out.println("Выход из системы выполнен успешно");
        } else {
            System.out.println("Не удалось выполнить выход из системы. Статус-код: " + statusCode);
        }
    }
}