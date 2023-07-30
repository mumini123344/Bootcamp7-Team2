import Data.AuthorizationData;
import Data.Models.Request.AuthorizationRequest;
import Steps.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ConfigForTests;

import static com.codeborne.selenide.Selenide.open;

import static org.testng.Assert.assertEquals;

@Epic("User Authorization")
@Feature("Authorize User")
public class AuthorizationTest extends ConfigForTests {
    AuthorizationStep authorizationStep = new AuthorizationStep();
    LoginSteps loginSteps = new LoginSteps();
    UserProfileSteps userProfileSteps = new UserProfileSteps();
    BooksSteps booksSteps = new BooksSteps();
    BookDescriptionSteps bookDescriptionSteps = new BookDescriptionSteps();
    PopupSteps popupSteps = new PopupSteps();
    String correctUser;
    String correctPassword;

    @Test(dataProvider = "authorizationData", dataProviderClass = AuthorizationData.class, priority = 0)
    public void authorizeUserTest(String userName, String password) throws JsonProcessingException {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        authorizationRequest.setUserName(userName);
        authorizationRequest.setPassword(password);

        Response response = authorizationStep.getRequest(authorizationRequest, userName);

        assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        if (response.getStatusCode() == 200) {
            correctUser = authorizationRequest.getUserName();
            correctPassword = authorizationRequest.getPassword();
        }
    }

    @Test(priority = 1)
    @Description("Testing book store various functionalities")
    public void bookStoreTest() {
        open("/login");
        loginSteps.enterCredentials(correctUser, correctPassword)
                .clickLoginButton();
        userProfileSteps.clickBookStoreButton();
        booksSteps.selectBook(0);
        bookDescriptionSteps.clickAddToCollectionButton();
        popupSteps.validatePopupMessage()
                .acceptPopup();
        bookDescriptionSteps.extractBookTitle()
                .clickBackToBookStoreButton();
        booksSteps.selectBook(1);
        bookDescriptionSteps.clickAddToCollectionButton();
        popupSteps.validatePopupMessage()
                .acceptPopup();
        bookDescriptionSteps.extractBookTitle()
                .clickBackToBookStoreButton();
        booksSteps.clickProfileButton();
        userProfileSteps.validateBookTitles()
                .deleteFirstBook();
        popupSteps.acceptDeleteBookPopup()
                .acceptPopup();
        userProfileSteps.validateBookCollectionSize()
                .deleteLastBook();
        popupSteps.acceptDeleteBookPopup()
                        .acceptPopup();
        userProfileSteps.validateBookCollectionIsEmpty();
    }
}
