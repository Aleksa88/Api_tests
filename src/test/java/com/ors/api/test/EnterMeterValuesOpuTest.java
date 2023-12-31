package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.MeterValuesOpu;
import com.ors.Authorization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnterMeterValuesOpuTest {
    private String accessToken;
    private MeterValuesOpu meterValuesOpu;

    @BeforeEach
    public void setup() {
        ConfigReader configReader = new ConfigReader();
        Authorization authorization = new Authorization(configReader);
        accessToken = authorization.authenticate();
        meterValuesOpu = new MeterValuesOpu(accessToken);
    }

    @Test
    public void testEnterMeterValues() {
        meterValuesOpu.enterMeterValuesOpu();
    }
}