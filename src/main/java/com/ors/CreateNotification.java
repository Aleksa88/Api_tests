package com.ors;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class CreateNotification {//Создание шаблона уведомлений
    private String createNotificationUrl = "https://api.gkh911.ru/api/employee/message-templates";
    private String accessToken;

    public CreateNotification(String accessToken) {
        this.accessToken = accessToken;
    }

    public void createNotification() throws IOException {
        String requestBody = FileUtils.readFileToString(new File("src/main/resources/createNotification.json"), StandardCharsets.UTF_8);

        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(createNotificationUrl);

        int statusCode = response.getStatusCode();
        if (statusCode == 201) {
            System.out.println("Уведомление успешно создано!");
        } else {
            System.out.println("Не удалось создать уведомление. Статус-код: " + statusCode);
        }
    }
}