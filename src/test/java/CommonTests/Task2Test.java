package CommonTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Task2Test {

    @Test
    public void task2() {

        // Find all books with publisher 'O'Reilly Media' containing title 'Javascript'
        // Check that size of returned list equals to 10 (this check should fail)
        // Check that the search result's first row's title equals to 'Learning JavaScript Design Patterns'
        // Click on all matching row's titles.

        open("https://demoqa.com/books");
        Configuration.browserSize ="\"selenide.browserSize\", \"1920x1080\"";

        List<String> javaScriptBookList = new ArrayList<>();
        List<Integer> javaScriptBookIndex = new ArrayList<>();

        int titleCount = $$(By.xpath("//span[@class='mr-2']/a")).size();

        for (int i = 1; i <= titleCount; i++) {

            if ($(By.xpath("(//span[@class='mr-2']/a)[" + i + "]")).getText().contains("JavaScript")) {

                if ($(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[" + i + "]/div/div[4]")).getText().contains("O'Reilly Media")) {

                    String bookName = $(By.xpath("(//span[@class='mr-2']/a)[" + i + "]")).getText();
                    Integer index = i;
                    javaScriptBookIndex.add(i);
                    javaScriptBookList.add(bookName);
                }
            }
        }
        int listSize = javaScriptBookList.size();

        //assert (javaScriptBookList.size()!=10);

        try {
            assert (listSize==10);
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("Wrong list size, list size is:" + listSize);
        }

        assert (javaScriptBookList.get(0).equals("Learning JavaScript Design Patterns"));

        for (Integer scriptBookIndex : javaScriptBookIndex) {
            $(By.xpath("(//span[@class='mr-2'])[" + scriptBookIndex + "]")).click();
            back();
            $(By.xpath("(//span[@class='mr-2'])[" + scriptBookIndex + "]")).scrollIntoView(true);
        }
        System.out.println("task2 ma imushava");
    }
}