package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.Logout;
import com.ors.Authorization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutTest {
    private ConfigReader configReader;
    private Logout logout;
    private Authorization authorization;
    private String authToken;

    @BeforeEach
    public void setup() {
        configReader = new ConfigReader();
        logout = new Logout(configReader);
        authorization = new Authorization(configReader);
        authToken = authorization.authenticate();
    }

    @Test
    public void testLogout() {
        // Использование актуального токена в тесте
        logout.logout(authToken);
    }
}