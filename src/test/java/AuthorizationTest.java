import Data.AuthorizationData;
import Data.Models.Request.AuthorizationRequest;
import Steps.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.ConfigForTests;

import static com.codeborne.selenide.Selenide.open;

import static org.testng.Assert.assertEquals;

@Epic("Final project")
@Feature("Collection of different cases")
public class AuthorizationTest extends ConfigForTests {
    AuthorizationStep authorizationStep = new AuthorizationStep();
    LoginSteps loginSteps = new LoginSteps();
    UserProfileSteps userProfileSteps = new UserProfileSteps();
    BooksSteps booksSteps = new BooksSteps();
    BookDescriptionSteps bookDescriptionSteps = new BookDescriptionSteps();
    PopupSteps popupSteps = new PopupSteps();
    ValidatingBookDataSteps validatingBookDataSteps = new ValidatingBookDataSteps();
    String correctUser;
    String correctPassword;

    @Test(description = "Testing user account different scenarios", dataProvider = "authorizationData", dataProviderClass = AuthorizationData.class, priority = 1)
    @Story("Testing user authorization")
    @Description("Testing user authorization and fetching successful data")
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

    @Test(description = "Testing book deletion", priority = 2)
    @Story("Testing demoqa.com/books website functionalities")
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

    @Test(priority = 3)
    @Description("Selecting first book and checking UI and data parameters are equal")
    public void FirstBookTest() {
        open("/books");
        booksSteps.clickFirstBook()
                .firstBookIsbn();

        validatingBookDataSteps.getResp()
                .logAll()
                .validateIsbn()
                .validateTitle()
                .validateAuthor();
    }
}
