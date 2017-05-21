package com.argus.pages;
import com.argus.util.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vinokur on 5/17/2017.
 *
 * Hello,
 * In this project you will find 2 classes:
 * 1) ArgusContactPage class - contains all needed elements locators from webContactPage https://argus-sec.com/contact/
 * and all methods what are used in testClass.
 * 2) ArgusContactTest class - contains few examples of negative and positive tests.
 *
 * I made this project using testNG-archetype "ru.stqa.selenium" from Maven repository.
 * Link: http://search.maven.org/#artifactdetails%7Cru.stqa.selenium%7Cwebdriver-testng-archetype%7C4.0%7Cmaven-archetype
 *
 */

public class ArgusContactPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(xpath = "//h2[@id='fancy-title-528']/span/p")
    WebElement textContactUs;

    @FindBy(xpath = "//input[@name='your-name']")
    WebElement inputName;         //or
    @FindBy(name = "your-name")
    WebElement name;

    @FindBy(xpath = "//input[@name='your-email']")
    WebElement inputEmail;       //or
    @FindBy(name = "your-email")
    WebElement email;

    @FindBy(xpath = "//select[@name='listsubject']")
    WebElement dropListSubject;      //or
    @FindBy(name = "listsubject")
    WebElement listSubject;

    @FindBy(xpath = "//option[@value='General information']")
    WebElement dropoOtionGenInfo;
    @FindBy(xpath = "//option[@value='Sales information']")
    WebElement dropoOtionSales;
    @FindBy(xpath = "//option[@value='Partnership opportunities']")
    WebElement dropOptionPartnership;
    @FindBy(xpath = "//option[@value='Journalists/analyst']")
    WebElement dropOptionJournalists;

    @FindBy(xpath = "//input[@name='your-subject']")
    WebElement inputSubject;        //or
    @FindBy(name = "your-subject")
    WebElement subject;
    @FindBy(xpath = "//input[@name='your-message']")
    WebElement inputMessage;        //or
    @FindBy(name = "your-message")
    WebElement message;

    @FindBy(xpath = "//input[@name='_mc4wp_subscribe_contact-form-7'])[2]")
    WebElement subscribe;
    @FindBy(xpath = "//input[@value='Send']")
    WebElement buttonSend;
    @FindBy(xpath = "//div[@id='wpcf7-f7847-p3135-o1']/form/div[2]")
    WebElement validError;
    @FindBy(xpath = "//div[@id='wpcf7-f7847-p3135-o1']/form/p[6]/span")
    WebElement emailActiveLoader;


    public ArgusContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void OpenPage () {
        driver.get ("https://argus-sec.com/contact/");
    }

    public void WaitContacPageIsLoaded (){ waitUntilIsLoadedCustomTime(textContactUs, 7);
        Log.info("Waiting until Conatact page is loaded");
    }
    public void FillName(String nameText) {  setElementText(name, nameText);
        Log.info("Filling form Name with " + nameText);
    }
    public void FillEmail(String emailText) { setElementText(email, emailText);
        Log.info("Filling form Email with " + emailText);
    }

    public void ClickdropListChooseSubject() {clickElement(dropListSubject);
        Log.info("Subject dropdown list is clicked");}
    public void ClickdropoOtionGenInfo() {clickElement(dropoOtionGenInfo);
        Log.info("menu General Info  is clicked");}
    public void ClickdropoOtionSales() {clickElement(dropoOtionSales);
        Log.info("menu Sales  is clicked");}
    public void ClickdropOptionPartnership() {clickElement(dropOptionPartnership);
        Log.info("menu Partnership  is clicked");}
    public void ClickdropOptionJournalists() {clickElement(dropOptionJournalists);
        Log.info("menu Journalists is clicked");}

        public void FillSubject(String subjectText) {setElementText(subject, subjectText);
        Log.info("Filling form Subject with " + subjectText);
    }
    public void FillMessage(String messageText) {setElementText(message, messageText);
        Log.info("Filling form Message with " + messageText);
    }
    public void Clicksubscribe() {clickElement(subscribe);
        Log.info("Subscribe button is clicked");
    }
    public void ClickbuttonSend() {clickElement(buttonSend);
        Log.info("Send button is clicked");
    }

    public String GetTextFromErrorMessage(){
        String TextFromExitLink = validError.getText();
        Log.info("Text validation error = " + TextFromExitLink);
        return TextFromExitLink;
    }
    public Boolean IsErrorPresent(){
        return verifyElementIsPresent(validError);
    }


}
