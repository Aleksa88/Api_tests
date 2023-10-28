package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.Logout;
import com.ors.TokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutTest {
    private ConfigReader configReader;
    private Logout logout;
    private TokenProvider tokenProvider;
    private String authToken;

    @BeforeEach
    public void setup() {
        configReader = new ConfigReader();
        logout = new Logout(configReader);
        tokenProvider = new TokenProvider(configReader);
        authToken = tokenProvider.getAuthToken();
    }

    @Test
    public void testLogout() {
        // Использование актуального токена в тесте
        logout.logout(authToken);
    }
}
