package com.ors;

public class TokenProvider {
    private ConfigReader configReader;

    public TokenProvider(ConfigReader configReader) {
        this.configReader = configReader;
    }

    public String getAuthToken() {
        Authorization authorization = new Authorization(configReader);
        return authorization.authenticate();
    }
}
