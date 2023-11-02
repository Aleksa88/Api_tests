package com.ors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateEmployeeExample {
    public static void createEmployee() {
        try {
            ConfigReader configReader = new ConfigReader();
            Authorization authorization = new Authorization(configReader);
            String token = authorization.authenticate();
            if (token != null) {
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
                String url = "https://api.gkh911.ru/api/employee/employees";
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Authorization", "Bearer " + token); // Добавлен заголовок Authorization
                connection.setDoOutput(true);

                try (OutputStream outputStream = connection.getOutputStream()) {
                    outputStream.write(jsonInput.getBytes());
                    outputStream.flush();
                }

                int responseCode = connection.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                if (responseCode == 201) {
                    System.out.println("Сотрудник успешно создан!");
                }

                connection.disconnect();
            } else {
                System.out.println("Аутентификация не удалась.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}