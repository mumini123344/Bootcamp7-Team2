import Steps.BooksSteps;
import Steps.ValidatingBookDataSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import utils.ConfigForTests;

import static com.codeborne.selenide.Selenide.open;

@Epic("Select first book")
@Feature("Validate parameters")
public class ValidatingFirstBookTest extends ConfigForTests {

    BooksSteps booksSteps = new BooksSteps();
    ValidatingBookDataSteps validatingBookDataSteps = new ValidatingBookDataSteps();

    @Test()
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
