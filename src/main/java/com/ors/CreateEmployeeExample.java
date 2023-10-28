package com.ors;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateEmployeeExample {
    public static void main(String[] args) {
        try {
            String jsonInput = "{ \"phone\": \"79456543456\", \"email\": \"Qwerty123.@mail.ru\", " +
                    "\"first_name\": \"Апишный\", \"middle_name\": \"Тестович\", " +
                    "\"last_name\": \"Тест\", \"company_id\": 1, \"house_group_id\": 1," +
                    " \"is_blocked\": false, \"role_ids\": [ 2968 ], \"house_groups\": [], \"abilities\": [ \"view\", \"edit\" ], \"is_co_executor\": true }";
            String url = "https://api.gkh911.ru/api/employee/employees";

            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonInput.getBytes());
            outputStream.flush();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
