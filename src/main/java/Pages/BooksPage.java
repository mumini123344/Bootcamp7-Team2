package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {
    public ElementsCollection bookCollection = $$(".mr-2");
    public SelenideElement profileButton = $(By.xpath("//span[text() ='Profile']"));
    public SelenideElement firstBook = $(By.linkText("Git Pocket Guide"));
    public SelenideElement isbn = $(byXpath("//div[@id='ISBN-wrapper']//label[@id='userName-value']"));
    public SelenideElement title = $(byXpath("//div[@id='title-wrapper']//label[@id='userName-value']"));
    public SelenideElement author = $(byXpath("//div[@id='author-wrapper']//label[@id='userName-value']"));


}
