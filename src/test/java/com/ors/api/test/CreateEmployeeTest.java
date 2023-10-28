package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.TokenProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreateEmployeeTest {
    private static String accessToken;

    @BeforeAll
    public static void setup() {
        ConfigReader configReader = new ConfigReader(); // Создаем экземпляр ConfigReader
        TokenProvider tokenProvider = new TokenProvider(configReader); // Создаем экземпляр TokenProvider с передачей ConfigReader
        accessToken = tokenProvider.getAuthToken(); // Вызываем метод getAuthToken() для получения access token
    }

    @Test
    public void testCreateEmployee() {
        String jsonInput = "{ \"phone\": \"79456543456\", \"email\": \"Qwerty123.@mail.ru\", \"first_name\": \"Апишный\"," +
                " \"middle_name\": \"Тестович\", \"last_name\": \"Тест\", \"company_id\": 1, " + "\"house_group_id\": 1, " +
                "\"is_blocked\": false, \"role_ids\": [ 2968 ], \"house_groups\": [], \"abilities\": [ \"view\", \"edit\" ], \"is_co_executor\": true }";

        RestAssured.given()
                .header("Authorization", "Bearer " + accessToken) // Добавляем заголовок авторизации
                .contentType(ContentType.JSON)
                .body(jsonInput)
                .when()
                .post("https://api.gkh911.ru/api/employee/employees")
                .then()
                .statusCode(201);
    }
}
