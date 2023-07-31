import Steps.BooksSteps;
import Steps.ValidatingBookDataSteps;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Epic("Select first book")
@Feature("Validate parameters")
public class ValidatingFirstBookTest {

    BooksSteps booksSteps = new BooksSteps();
    ValidatingBookDataSteps validatingBookDataSteps = new ValidatingBookDataSteps();

    @BeforeMethod(alwaysRun = true)
    @Story("Opening url for all tests")
    @Description("Maximize browsers windows")
    public void setUp() {
        open("https://demoqa.com/books");
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @Test()
    @Description("Selecting first book and checking UI and data parameters are equal")
    public void FirstBookTest() {
        booksSteps.clickFirstBook()
                .firstBookIsbn();

        validatingBookDataSteps.getResp()
                .logAll()
                .validateIsbn()
                .validateTitle()
                .validateAuthor();

    }

}
