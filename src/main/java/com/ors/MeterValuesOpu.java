package com.ors;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MeterValuesOpu {
    private String accessToken;

    public MeterValuesOpu(String accessToken) {
        this.accessToken = accessToken;
    }

    public void enterMeterValuesOpu() {
        String jsonInput = readJsonFromFile("Opu_meter_values.json");

        RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(jsonInput)
                .when()
                .post("https://api.gkh911.ru/api/employee/house-meter-values/values")
                .then()
                .statusCode(200)
                .assertThat()
                .statusLine("HTTP/1.1 200 OK")
                .extract()
                .response();

        System.out.println("Показания переданы успешно");
    }

    private String readJsonFromFile(String fileName) {
        try {
            File file = new File("src/main/resources/" + fileName);
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}