package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.PasswordReset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordResetTest {
    private ConfigReader configReader;
    private PasswordReset passwordReset;

    @BeforeEach
    public void setup() {
        configReader = new ConfigReader();
        passwordReset = new PasswordReset();
    }

    @Test
    public void testPasswordReset() {
        String url = "https://api.gkh911.ru/api/employee/password/reset";
        String email = "valya@mail.ru";

        passwordReset.requestPasswordReset(url, email);
    }
}
