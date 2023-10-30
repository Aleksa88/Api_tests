package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.JsonDataUpdater;
import com.ors.TokenProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class CreateEmployeeTest {
    private static String accessToken;

    @BeforeAll
    public static void setup() {
        ConfigReader configReader = new ConfigReader();
        TokenProvider tokenProvider = new TokenProvider(configReader);
        accessToken = tokenProvider.getAuthToken();
    }

    @Test
    public void testCreateEmployee() {
        try {
            // Чтение содержимого файла random_data.json
            String filePath = "src/main/resources/random_data.json";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder jsonInputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonInputBuilder.append(line);
            }
            reader.close();
            String jsonInput = jsonInputBuilder.toString();

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void teardown() {
        JsonDataUpdater.main(null);
    }

}