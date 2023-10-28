package com.ors.api.test;

import com.ors.ConfigReader;
import com.ors.MeterValuesOpu;
import com.ors.TokenProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EnterMeterValuesOpuTest {
    private static String accessToken;
    private static MeterValuesOpu meterValuesOpu;

    @BeforeAll
    public static void setup() {
        ConfigReader configReader = new ConfigReader();
        TokenProvider tokenProvider = new TokenProvider(configReader);
        accessToken = tokenProvider.getAuthToken();
        meterValuesOpu = new MeterValuesOpu(accessToken);
    }

    @Test
    public void testEnterMeterValues() {
        meterValuesOpu.enterMeterValuesOpu();
    }

}
