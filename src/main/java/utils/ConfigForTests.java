package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

public class ConfigForTests {
@BeforeMethod
public void setup() {
    Configuration.browser = "chrome";
    Configuration.screenshots = true;
    Configuration.savePageSource = false;
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
}
    @AfterMethod()
    public void teardown(ITestResult rs, Method method) throws IOException {
        if(rs.getStatus() == ITestResult.FAILURE){
            takeScreenShot(method.getName());
        }
        Selenide.closeWebDriver();
    }
    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName){
        return Selenide.screenshot(OutputType.BYTES);
    }
}
