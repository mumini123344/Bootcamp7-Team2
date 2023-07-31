package Steps;

import Pages.BooksPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class BooksSteps {
    BooksPage booksPage = new BooksPage();
    Response response;

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

    @Step("Clicking first book")
    public BooksSteps clickFirstBook() {
        booksPage.firstBook.click();
        return this;
    }

    @Step("Checking first book isbn")
    public BooksSteps firstBookIsbn() {
        booksPage.isbn.shouldBe(Condition.visible);
        return this;

    }

    @Step("Storing isbn as string")
    public String getFirstBookIsbn() {
        return booksPage.isbn.getText();
    }

    @Step("Get title")
    public String getFirstBookTitle() {
        return booksPage.title.getText();
    }

    @Step("Get Author")
    public String getFirstBookAuthor() {
        return booksPage.author.getText();
    }

}
