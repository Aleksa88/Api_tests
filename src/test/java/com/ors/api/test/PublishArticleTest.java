package com.ors.api.test;
import com.ors.Authorization;
import com.ors.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class PublishArticleTest {
    private String publishArticleUrl = "https://api.gkh911.ru/api/employee/announces";
    private String accessToken;

    @BeforeEach
    public void setupAuthorization() {
        ConfigReader configReader = new ConfigReader();
        Authorization authorization = new Authorization(configReader);
        accessToken = authorization.authenticate();
    }

    @Test
    public void testPublishArticle() throws IOException {
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
