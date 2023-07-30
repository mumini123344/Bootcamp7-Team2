package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement username = $("#userName"),
            password = $("#password"),
            loginButton = $("#login");

}
