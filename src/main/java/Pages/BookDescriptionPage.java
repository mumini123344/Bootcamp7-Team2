package Pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BookDescriptionPage {
    public SelenideElement addToCollection = $(By.xpath("//button[text()='Add To Your Collection']")),
            backToBookStore = $(By.xpath("//button[text()='Back To Book Store']")),
            bookTitle = $(By.xpath("//div[@id='title-wrapper']/div[last()]"));
}
