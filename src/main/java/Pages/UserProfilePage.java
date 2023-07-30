package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UserProfilePage {
    public SelenideElement bookStoreButton = $("#gotoStore"),
            deleteAllBooksButton = $(By.xpath("//button[text()='Delete All Books']"));

    public ElementsCollection booksCollection = $$(".mr-2"),
            deleteBookIcon = $$("#delete-record-undefined");
}
