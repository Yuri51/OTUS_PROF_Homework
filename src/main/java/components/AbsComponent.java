package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.AbsPageObject;

public class AbsComponent<T> extends AbsPageObject<T> {

  {
    waiters.waitForElementVisible();
  }

  public AbsComponent(WebDriver driver) {
    super(driver);
  }

  protected WebElement getComponentEntity() {
    return null;
  }
}
