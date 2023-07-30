package utils;

import com.codeborne.selenide.Configuration;

public class ConfigForTests {
    public ConfigForTests() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }
}
