/*package com.ors.api.test;

import com.ors.Authorization;
import com.ors.PasswordChange;
import com.ors.ConfigReader;
import org.junit.jupiter.api.Test;

public class PasswordChangeTest {
    private ConfigReader configReader = new ConfigReader();
    private String passwordChangeUrl = configReader.getProperty("passwordChangeUrl");
    private String currentPassword = configReader.getProperty("currentPassword");
    private String newPassword = configReader.getProperty("newPassword");

    @Test
    public void testPasswordChange() {
        Authorization authorization = new Authorization(configReader);
        String authToken = authorization.authenticate();

        PasswordChange passwordChange = new PasswordChange(passwordChangeUrl);
        passwordChange.changePassword(currentPassword, newPassword, authToken);
    }
}*/