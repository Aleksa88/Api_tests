/*package com.ors;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PasswordChange {
    private String passwordChangeUrl;

    public PasswordChange(String passwordChangeUrl) {
        this.passwordChangeUrl = passwordChangeUrl;
    }

    public void changePassword(String currentPassword, String newPassword, String authToken) {
        String requestBody = "{\"current_password\": \"" + currentPassword + "\", \"password\": \"" + newPassword + "\"}";

        Response response = given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(passwordChangeUrl);

        int statusCode = response.getStatusCode();
        if (statusCode == 204) {
            System.out.println(statusCode + " - Пароль успешно изменен");
        } else {
            System.out.println("Не удалось изменить пароль. Статус-код: " + statusCode);
        }
    }
}*/