package CommonTests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class Task1Test {
    @Test
    public void task1() {
        System.setProperty("Selenide.browser","chrome");
        open("https://demoqa.com/books");
        Configuration.browserSize = "1920x1080";

        // Assert that each books images, title, author and publisher are not empty.

        int bookImageCount = $$(By.xpath("//div[@class='rt-td']/img")).size();
        int titleCount = $$(By.xpath("//span[@class='mr-2']/a")).size();
        int authorCount = $$(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]")).size();
        int publisherCount = $$(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]")).size();

        int count = Math.max(bookImageCount, titleCount);
        count = Math.max(count, authorCount);
        count = Math.max(count, publisherCount);

        // Assert that each books images are not empty
        for (int i = 1; i <= count; i++) {
            SelenideElement element = $(By.xpath("(//div[@class='rt-td']/img)[" + i + "]"));
            assert (Objects.requireNonNull(element.getAttribute("src")).contains("image"));
        }

        // Assert that each books title  are not empty
        for(int i = 1; i <= count; i++){
            SelenideElement element = $(By.xpath("(//span[@class='mr-2']/a)["+ i +"]"));
            element.shouldNotBe(empty);
        }

        // Assert that each books author  are not empty
        for (int i = 1; i <= count; i++){
            SelenideElement element = $(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div["+ i +"]/div[1]/div[3]"));
            element.shouldNotBe(empty);
        }

        // Assert that each books publisher  are not empty
        for (int i = 1; i <= count; i++){
            SelenideElement element = $(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div["+ i +"]/div[1]/div[4]"));
            element.shouldNotBe(empty);
        }
    }
}
