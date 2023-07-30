package Steps;

import Pages.PopupPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class PopupSteps {
    PopupPage popupPage = new PopupPage();
    @Step("Validate popup message")
    public PopupSteps validatePopupMessage() {
        String actualPopupText = Selenide.switchTo().alert().getText();
        Assert.assertEquals(actualPopupText, "Book added to your collection.");

        return this;
    }

    @Step("Accept popup after validating the message")
    public PopupSteps acceptPopup() {
        Selenide.switchTo().alert().accept();

        return this;
    }

    @Step("Press ok on Delete books popup")
    public PopupSteps acceptDeleteBookPopup() {
        popupPage.deletePopup.click();

        return this;
    }
}
