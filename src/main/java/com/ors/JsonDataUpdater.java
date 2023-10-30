package com.ors;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class JsonDataUpdater {
    private static final Random random = new Random();
    private static final String[] FIRST_NAMES = {"Иван", "Петр", "Александр", "Дмитрий", "Андрей"};
    private static final String[] LAST_NAMES = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов"};
    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
    private static final int[] ROLE_IDS = {2967, 2968, 3375, 3376, 3381, 3383, 3444};

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Чтение JSON-объекта из файла
            RandomData randomData = objectMapper.readValue(new File("src/main/resources/random_data.json"), RandomData.class);

            // Изменение данных
            randomData.setEmail(generateRandomEmail());
            randomData.setFirst_name(getRandomElement(FIRST_NAMES));
            randomData.setLast_name(getRandomElement(LAST_NAMES));
            randomData.setRole_ids(new int[]{getRandomElement(ROLE_IDS)});

            // Запись обновленного JSON-объекта в файл
            objectMapper.writeValue(new File("src/main/resources/random_data.json"), randomData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomEmail() {
        String randomName = generateRandomString(3, 5);
        String domain = getRandomElement(DOMAINS);
        return randomName + "@" + domain;
    }

    private static String generateRandomString(int minLength, int maxLength) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private static String getRandomElement(String[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }

    private static int getRandomElement(int[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }

    private static class RandomData {
        private String phone;
        private String email;
        private String first_name;
        private String middle_name;
        private String last_name;
        private int company_id;
        private int house_group_id;
        private boolean is_blocked;
        private int[] role_ids;
        private int[] house_groups;
        private boolean is_co_executor;


        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getMiddle_name() {
            return middle_name;
        }

        public void setMiddle_name(String middle_name) {
            this.middle_name = middle_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public int getHouse_group_id() {
            return house_group_id;
        }

        public void setHouse_group_id(int house_group_id) {
            this.house_group_id = house_group_id;
        }

        public boolean isIs_blocked() {
            return is_blocked;
        }

        public void setIs_blocked(boolean is_blocked) {
            this.is_blocked = is_blocked;
        }

        public int[] getRole_ids() {
            return role_ids;
        }

        public void setRole_ids(int[] role_ids) {
            this.role_ids = role_ids;
        }

        public int[] getHouse_groups() {
            return house_groups;
        }

        public void setHouse_groups(int[] house_groups) {
            this.house_groups = house_groups;
        }

        public boolean isIs_co_executor() {
            return is_co_executor;
        }

        public void setIs_co_executor(boolean is_co_executor) {
            this.is_co_executor = is_co_executor;
        }


    }
}