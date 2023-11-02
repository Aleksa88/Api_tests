package com.ors.api.test;
import com.ors.Authorization;
import com.ors.ConfigReader;
import com.ors.CreateNotification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CreateNotificationTest {
    private String accessToken;

    @BeforeEach
    public void setupAuthorization() {
        ConfigReader configReader = new ConfigReader();
        Authorization authorization = new Authorization(configReader);
        accessToken = authorization.authenticate();
    }

    @Test
    public void testCreateNotification() throws IOException {
        CreateNotification createNotification = new CreateNotification(accessToken);
        createNotification.createNotification();
    }
}