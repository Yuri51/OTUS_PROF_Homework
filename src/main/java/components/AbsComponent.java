package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbsPageObject;

public abstract class AbsComponent<T> extends AbsPageObject<T> {

  public AbsComponent(WebDriver driver) {
    super(driver);
    this.actions = new Actions(driver);
  }

  protected WebElement getComponentEntity() {
    return null;
  }

  protected void moveAndPerform(WebElement element) {
    waiters.waitForCondition(ExpectedConditions.visibilityOf(element));
    actions.moveToElement(element);
    actions.click().build().perform();
  }
}


