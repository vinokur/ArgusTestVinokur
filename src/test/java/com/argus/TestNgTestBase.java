package com.argus;

import com.argus.util.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 *
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  public WebDriver driver;

@BeforeSuite(alwaysRun = true)
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
  }
  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
