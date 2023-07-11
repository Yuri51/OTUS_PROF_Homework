package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.AbsPageObject;

public class AbsComponent<T> extends AbsPageObject<T> {

  public AbsComponent(WebDriver driver) {
    super(driver);
    actions = new Actions(driver);
  }

  protected WebElement getComponentEntity() {
    return null;
  }
}


