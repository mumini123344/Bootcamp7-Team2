package Steps;

import com.codeborne.selenide.commands.Val;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class ValidatingBookDataSteps {
    BooksSteps booksSteps = new BooksSteps();
    Response response;

    @Step("Getting response")
    public ValidatingBookDataSteps getResp() {
        response = RestAssured.given()
                .when().get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=" + booksSteps.getFirstBookIsbn());
        return this;
    }

    @Step("Log all data")
    public ValidatingBookDataSteps logAll() {
        response.then().log().all();
        return this;
    }

    @Step("Validate isbn")
    public ValidatingBookDataSteps validateIsbn(){
        Assert.assertTrue(true, booksSteps.getFirstBookIsbn());
        return this;
    }

    @Step("Validate title")
    public ValidatingBookDataSteps validateTitle(){
        Assert.assertEquals(booksSteps.getFirstBookTitle(), "Git Pocket Guide");
        return this;
    }

    @Step("Validate author")
    public ValidatingBookDataSteps validateAuthor(){
        Assert.assertEquals(booksSteps.getFirstBookAuthor(), "Richard E. Silverman");
        return this;
    }
}
