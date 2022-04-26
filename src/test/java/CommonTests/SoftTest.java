package CommonTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftTest {
    @Test
    public void softAssert(){
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert Method Was Started");
        softAssertion.assertTrue(false);
        System.out.println("softAssert Method Was Executed");
        System.out.println("blaaaaaaaaaaaaaaaa");
        softAssertion.assertAll();
        System.out.println("amas ar dabechdavs");

    }

    @Test
    public void hardAssert(){
        System.out.println("hardAssert Method Was Started");
        Assert.assertTrue(false);
        System.out.println("hardAssert Method Was Executed");

    }
}