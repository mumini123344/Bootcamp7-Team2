package Steps;

import Pages.BookDescriptionPage;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class BookDescriptionSteps {
    BookDescriptionPage bookDescriptionPage = new BookDescriptionPage();
    public List<String> bookTitles = new ArrayList<>();
    @Step("Extract Added book title")
    public BookDescriptionSteps extractBookTitle() {
        bookTitles.add(bookDescriptionPage.bookTitle.getText());

        return this;
    }
    @Step("Add book to your collection")
    public BookDescriptionSteps clickAddToCollectionButton() {
        bookDescriptionPage.addToCollection.click();

        return this;
    }

    @Step("Go back to books list")
    public BookDescriptionSteps clickBackToBookStoreButton() {
        bookDescriptionPage.backToBookStore.click();

        return this;
    }
}
