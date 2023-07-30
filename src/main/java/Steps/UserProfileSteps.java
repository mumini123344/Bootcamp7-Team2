package Steps;

import Pages.UserProfilePage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

public class UserProfileSteps {
    UserProfilePage userProfilePage = new UserProfilePage();
    BookDescriptionSteps bookDescriptionSteps = new BookDescriptionSteps();

    @Step("Click Go To Book Store button")
    public UserProfileSteps clickBookStoreButton() {
        userProfilePage.bookStoreButton.click();

        return this;
    }

    @Step("Validate added books with titles")
    public UserProfileSteps validateBookTitles() {
        int i = 0;
        for (SelenideElement bookElement : userProfilePage.booksCollection) {
            Assert.assertEquals(bookElement.getText(), bookDescriptionSteps.bookTitles.get(i));
        }

        return this;
    }

    @Step("Delete first book using 'Delete' icon from Action")
    public UserProfileSteps deleteFirstBook() {
        userProfilePage.deleteBookIcon.first().click();

        return this;
    }

    @Step("Validate that collection has only one book")
    public UserProfileSteps validateBookCollectionSize() {
        Assert.assertTrue(userProfilePage.booksCollection.size() == 1);

        return this;
    }

    @Step("Delete last book using 'Delete All Books' button")
    public UserProfileSteps deleteLastBook() {
        userProfilePage.deleteAllBooksButton.click();

        return this;
    }

    @Step("Validate that book collection is empty")
    public UserProfileSteps validateBookCollectionIsEmpty() {
        Assert.assertTrue(userProfilePage.booksCollection.isEmpty());

        return this;
    }
}
