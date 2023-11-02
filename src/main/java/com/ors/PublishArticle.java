package com.ors;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class PublishArticle {
    private String publishArticleUrl = "https://api.gkh911.ru/api/employee/announces";
    private String accessToken;

    public PublishArticle(String accessToken) {
        this.accessToken = accessToken;
    }

    public void publishArticle() throws IOException {
        String requestBody = FileUtils.readFileToString(new File("src/main/resources/publishArticle.json"), StandardCharsets.UTF_8);

        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(publishArticleUrl);

        int statusCode = response.getStatusCode();
        if (statusCode == 201) {
            System.out.println("Статья успешно опубликована!");
        } else {
            System.out.println("Не удалось опубликовать статью. Статус-код: " + statusCode);
        }
    }
}