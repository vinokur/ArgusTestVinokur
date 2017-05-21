package com.argus;

import com.argus.pages.ArgusContactPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Vinokur on 5/17/2017.
 */
public class ArgusContactTest extends TestNgTestBase {
    // variables for positive tests
    public static String textName = "Jacque Fresco";
    public static String textEmail = "test@yopmail.com";
    public static String textSubject = "Test";
    public static String textMessage = "Only working together we can make the world a better place";
    // variables for negative tests
    public static String textNameNegative1 = " ";
    public static String textEmailNegative1 = "test@@yopmail,com";
    // variables for negative tests (not used)
    public static String textNameNegative2 = "♣ ♂";
    public static String textEmailNegative2 = "moc.liampoy@tset";

    private ArgusContactPage argusContactPage;


    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        /** or if we need Mozilla:
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        */
        argusContactPage = PageFactory.initElements(driver, ArgusContactPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        argusContactPage.OpenPage();
    }

    @Test(groups = {"contactPage", "positive"})
    public void testPositiveFillRequiredForms() {
        argusContactPage.WaitContacPageIsLoaded();
        argusContactPage.FillName(textName);
        argusContactPage.FillEmail(textEmail);
        argusContactPage.ClickbuttonSend();
        Assert.assertFalse(argusContactPage.IsErrorPresent(),
                "Message didn't send in positive test");
    }


    @Test(groups = {"contactPage", "positive"})
    public void testPositiveFillAllForms() {
        argusContactPage.WaitContacPageIsLoaded();
        argusContactPage.FillName(textName);
        argusContactPage.FillEmail(textEmail);
        argusContactPage.ClickdropListChooseSubject();
        argusContactPage.ClickdropoOtionGenInfo();
        argusContactPage.FillSubject(textSubject);
        argusContactPage.FillMessage(textMessage);
        argusContactPage.Clicksubscribe();
        argusContactPage.ClickbuttonSend();
        Assert.assertFalse(argusContactPage.IsErrorPresent(),
                "Message didn't send in positive test");
    }

    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongName() {
        argusContactPage.WaitContacPageIsLoaded();
        argusContactPage.FillName(textNameNegative1);
        argusContactPage.FillEmail(textEmail);
        argusContactPage.ClickbuttonSend();
        Assert.assertEquals("Validation errors occurred. Please confirm the fields and submit it again.",
                argusContactPage.GetTextFromErrorMessage(), "Message sent in negative test");
}

    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillRequiredFormsWrongEmail() {
        argusContactPage.WaitContacPageIsLoaded();
        argusContactPage.FillName(textName);
        argusContactPage.FillEmail(textEmailNegative1);
        argusContactPage.ClickbuttonSend();
        Assert.assertEquals("Validation errors occurred. Please confirm the fields and submit it again.",
                argusContactPage.GetTextFromErrorMessage(), "Message sent in negative test");
    }

    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillAllFormsWrongName() {
        argusContactPage.WaitContacPageIsLoaded();
        argusContactPage.FillName(textNameNegative2);
        argusContactPage.FillEmail(textEmail);
        argusContactPage.ClickdropListChooseSubject();
        argusContactPage.ClickdropoOtionGenInfo();
        argusContactPage.FillSubject(textSubject);
        argusContactPage.FillMessage(textMessage);
        argusContactPage.Clicksubscribe();
        argusContactPage.ClickbuttonSend();
        Assert.assertEquals("Validation errors occurred. Please confirm the fields and submit it again.",
                argusContactPage.GetTextFromErrorMessage(), "Message sent in negative test");
    }
    @Test(groups = {"contactPage", "negative"})
    public void testNegativeFillAllFormsWrongEmail() {
        argusContactPage.WaitContacPageIsLoaded();
        argusContactPage.FillName(textName);
        argusContactPage.FillEmail(textEmailNegative2);
        argusContactPage.ClickdropListChooseSubject();
        argusContactPage.ClickdropoOtionGenInfo();
        argusContactPage.FillSubject(textSubject);
        argusContactPage.FillMessage(textMessage);
        argusContactPage.Clicksubscribe();
        argusContactPage.ClickbuttonSend();
        Assert.assertEquals("Validation errors occurred. Please confirm the fields and submit it again.",
                argusContactPage.GetTextFromErrorMessage(), "Message sent in negative test");
    }
}
