package com.ors;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Logout {
    private ConfigReader configReader;

    public Logout(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public void logout(String authToken) {
        String apiUrl = configReader.getProperty("logoutUrl");

        Response response = given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .post(apiUrl);

        int statusCode = response.getStatusCode();

        if (statusCode == 204) {
            System.out.println("Выход из системы выполнен успешно. Статус-код: " + statusCode);
        } else {
            System.out.println("Не удалось выполнить выход из системы. Статус-код: " + statusCode);
        }
    }
}
