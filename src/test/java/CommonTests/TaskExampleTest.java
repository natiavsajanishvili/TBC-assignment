package CommonTests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TaskExampleTest {

    @Test
    public void task2() {
        open("https://demoqa.com/books");
        Configuration.browserSize = "\"selenide.browserSize\", \"1920x1080\"";

        HashMap<Integer,String> map = new HashMap<>();

        int titleCount = $$(By.xpath("//span[@class='mr-2']/a")).size();

        for (int i = 1; i <= titleCount; i++) {

            if ($(By.xpath("(//span[@class='mr-2']/a)[" + i + "]")).getText().contains("JavaScript")) {

                if ($(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[" + i + "]/div/div[4]")).getText().contains("O'Reilly Media")) {

                    String bookName = $(By.xpath("(//span[@class='mr-2']/a)[" + i + "]")).getText();
                    Integer index = i;
                    map.put(index,bookName);
                }
            }
        }
        int mapSize = map.size();

        //assert (javaScriptBookList.size()!=10);

        try {
            assert (mapSize==10);
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("Wrong list size, list size is:" + mapSize);
        }



        Map.Entry<Integer, String> entry = map.entrySet().iterator().next();
        String value = entry.getValue();
        System.out.println("value:" + value);

        assert (value.equals("Learning JavaScript Design Patterns"));

        // Using Map.entrySet() method
        for (Map.Entry<Integer, String> entry2 : map.entrySet()) {
            Integer k = entry2.getKey();
            $(By.xpath("(//span[@class='mr-2'])[" + k + "]")).click();
            back();
            $(By.xpath("(//span[@class='mr-2'])[" + k + "]")).scrollIntoView(true);

        }

        // Using forEach
     /*   map.forEach((key,val) -> {
                    $(By.xpath("(//span[@class='mr-2'])[" + key + "]")).click();
                    back();
                    $(By.xpath("(//span[@class='mr-2'])[" + key + "]")).scrollIntoView(true);

                });*/

        // Using map.keySet() method - Keys only
    /*    Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            $(By.xpath("(//span[@class='mr-2'])[" + key + "]")).click();
            back();
            $(By.xpath("(//span[@class='mr-2'])[" + key + "]")).scrollIntoView(true);
        }*/
    }
}