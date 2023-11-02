package com.ors.api.test;

import com.ors.Authorization;
import com.ors.ConfigReader;
import com.ors.JsonDataUpdater;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateEmployeeTest {
    private String jsonInput;
    private String accessToken;

    @BeforeEach
    public void setupBeforeEachTest() {
        // Обновление данных и запись их в файл перед каждым запуском теста
        JsonDataUpdater.updateDataAndAuthenticate();

        // Чтение содержимого файла random_data.json
        try {
            String filePath = "src/main/resources/random_data.json";
            jsonInput = new String(Files.readAllBytes(Paths.get("src/main/resources/random_data.json")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void setupAuthorization() {
        ConfigReader configReader = new ConfigReader();
        Authorization authorization = new Authorization(configReader);
        accessToken = authorization.authenticate();
    }

    @Test
    public void testCreateEmployee() {
        RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(jsonInput)
                .when()
                .post("https://api.gkh911.ru/api/employee/employees")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();

        System.out.println("Сотрудник успешно создан!");
    }
}