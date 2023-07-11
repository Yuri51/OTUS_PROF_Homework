package factory;

import exceptions.BrowserNotSupportedException;
import factory.implement.ChromeWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FactoryDriver {
  private final static String BROWSER_NAME = System.getProperty("browser", "chrome");

  public EventFiringWebDriver getDriver() throws BrowserNotSupportedException {
    switch (BROWSER_NAME) {
      case "chrome": {
        ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
        chromeWebDriver.downloadLocalWebDriver(BROWSER_NAME);
        return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
      }
      default:
        throw new BrowserNotSupportedException(BROWSER_NAME);
    }
  }
}


