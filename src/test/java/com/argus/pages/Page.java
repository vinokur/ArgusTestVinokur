package com.argus.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  public WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }


  public void setElementText(WebElement element, String text) {
    element.click();
    element.clear();
    //Log.info("entering text '" + text + "' into element " + element);
    element.sendKeys(text);
    // Assert.assertEquals(element.getAttribute("value"), text);
  }

  public void clickElement(WebElement element) {
    // Log.info("clicking on element " + element + "");
    element.click();
  }

  public void waitUntilIsLoadedCustomTime(WebElement element, int time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

    public void selectValueInDropdownbyText(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

    }

  public boolean verifyElementIsPresent(WebElement element) {
    try {
      element.getTagName();
      return true;
    } catch (NoSuchElementException e) {
      //  Log.info("---------------------------------");
      //  Log.info("element " + element + " can not be found by  element.getTagName()");
      //   Log.info("---------------------------------");
      return false;
    }
  }
    public boolean exists(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
            return false;
        }
    }
}