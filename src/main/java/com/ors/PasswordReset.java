package com.ors;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PasswordReset {
    public void requestPasswordReset(String url, String email) {
        String requestBody = "{\"email\": \"" + email + "\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(url);

        int statusCode = response.getStatusCode();
        if (statusCode == 200) {
            System.out.println( statusCode + " statusCode "+ " Запрос на сброс пароля успешно отправлен");
        } else {
            System.out.println("Не удалось отправить запрос на сброс пароля. Статус-код: " + statusCode);
        }
    }
}
