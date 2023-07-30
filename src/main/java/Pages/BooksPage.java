package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {
    public ElementsCollection bookCollection = $$(".mr-2");
    public SelenideElement profileButton = $(By.xpath("//span[text() ='Profile']"));

}
