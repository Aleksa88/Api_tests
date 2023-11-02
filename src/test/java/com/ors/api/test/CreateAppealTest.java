package com.ors.api.test;
import com.ors.Authorization;
import com.ors.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateAppealTest {
    private String createAppealUrl = "https://api.gkh911.ru/api/employee/appeals";
    private String accessToken;

    @BeforeEach
    public void setupAuthorization() {
        ConfigReader configReader = new ConfigReader();
        Authorization authorization = new Authorization(configReader);
        accessToken = authorization.authenticate();
    }

    @Test
    public void testCreateAppeal() {
        String requestBody = "{\n" +
                "  \"house_id\": 3,\n" +
                "  \"phone\": \"9847365723\",\n" +
                "  \"desc\": \"Прорвало трубу\",\n" +
                "  \"flat_id\": 4,\n" +
                "  \"account_owner_id\": 5,\n" +
                "  \"person_id\": 5,\n" +
                "  \"employee_id\": 5,\n" +
                "  \"visit_at\": \"2022-01-20\",\n" +
                "  \"visit_time_range\": \"11:00 - 11:30\",\n" +
                "  \"plan_at\": \"2022-10-20 10:00:00\",\n" +
                "  \"is_pay\": false,\n" +
                "  \"is_crash\": true,\n" +
                "  \"is_guarantee\": true,\n" +
                "  \"floor\": 5,\n" +
                "  \"entrance\": 1,\n" +
                "  \"intercom_code\": \"039\",\n" +
                "  \"email\": \"test@test.com\",\n" +
                "  \"sum\": \"100.05\",\n" +
                "  \"comment\": \"Просили позвонить заранее\",\n" +
                "  \"appeal_job_id\": 84,\n" +
                "  \"appeal_source_id\": 5,\n" +
                "  \"appeal_place_id\": 10,\n" +
                "  \"status\": 1,\n" +
                "  \"pay_status\": \"string\",\n" +
                "  \"pay_comment\": \"string\",\n" +
                "  \"result_comment\": \"заявка выполнена\",\n" +
                "  \"reason\": \"тестовая заявка\",\n" +
                "  \"files\": [\n" +
                "    0\n" +
                "  ],\n" +
                "  \"personal_account_id\": 1,\n" +
                "  \"applicant_name\": \"дядя Вова\"\n" +
                "}";

        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(createAppealUrl);

        int statusCode = response.getStatusCode();
        if (statusCode == 201) {
            System.out.println("Заявка успешно создана!");
        } else {
            System.out.println("Не удалось создать заявку. Статус-код: " + statusCode);
        }
    }
}