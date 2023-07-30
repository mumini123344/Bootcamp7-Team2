package Steps;

import Pages.BooksPage;
import io.qameta.allure.Step;

public class BooksSteps {
    BooksPage booksPage = new BooksPage();

    @Step("Select book")
    public BooksSteps selectBook(int bookIndex) {
        booksPage.bookCollection.get(bookIndex).click();

        return this;
    }

    @Step("Go Back to Profile page")
    public BooksSteps clickProfileButton() {
        booksPage.profileButton.scrollIntoView(true);
        booksPage.profileButton.click();

        return this;
    }
}
