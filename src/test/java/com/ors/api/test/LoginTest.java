package com.ors.api.test;

import com.ors.Authorization;
import com.ors.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {
    private static ConfigReader configReader;
    private static Authorization authorization;


    @BeforeAll
    public static void setup() {
        configReader = new ConfigReader();
        authorization = new Authorization(configReader);
    }

    @Test
    public void testAuthentication() {
        String token = authorization.authenticate();
        if (token != null) {
            int statusCode = getAuthenticationStatusCode();
            if (statusCode == 200) {
                System.out.println("statusCode " + statusCode + " Вход в систему произведен");
            } else if (statusCode == 422) {
                System.out.println("statusCode " + statusCode + " Не удалось войти в систему");
            } else {
                System.out.println("Неизвестный статус-код: " + statusCode);
            }
        } else {
            System.out.println(  "Аутентификация не удалась.");
        }
    }

    private int getAuthenticationStatusCode() {
        String login = configReader.getProperty("login");
        String password = configReader.getProperty("password");
        String apiUrl = configReader.getProperty("apiUrl");

        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"login\": \"" + login + "\", \"password\": \"" + password + "\"}")
                .post(apiUrl);

        return response.getStatusCode();
    }
}