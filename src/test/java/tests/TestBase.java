package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPageWithFaker;

import java.util.Map;

public class TestBase {
    RegistrationPageWithFaker registrationPagewithfaker = new RegistrationPageWithFaker();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browserPosition = "0x0";
        Configuration.browser = System.getProperty("browser", "firefox");
        System.out.println(Configuration.browser);
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.remote = "https://user1:1234@" + System.getProperty("base_remote_Url", "selenoid.autotests.cloud/") + "wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

    }


    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}