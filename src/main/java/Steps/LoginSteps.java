package Steps;

import Pages.LoginPage;
import io.qameta.allure.Step;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Enter user credentials")
    public LoginSteps enterCredentials(String username,String password) {
        loginPage.username.setValue(username);
        loginPage.password.setValue(password);

        return this;
    }

    @Step("Click login button")
    public LoginSteps clickLoginButton() {
        loginPage.loginButton.click();

        return this;
    }
}
