package components.popups;

import annotations.Popup;
import data.StatePopupData;
import exceptions.PathEmptyException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbsPageObject;

public class AbsPopup<T> extends AbsPageObject<T> implements IPopup<T> {
  public AbsPopup(WebDriver driver) {
    super(driver);
  }

  private String getPopup() throws PathEmptyException {
    Class<? extends AbsPopup> clazz = this.getClass();
    if (clazz.isAnnotationPresent(Popup.class)) {
      Popup popup = clazz.getAnnotation(Popup.class);
      return popup.value();
    }
    throw new PathEmptyException();
  }

  @Override
  public T statePopup(StatePopupData statePopupData) throws PathEmptyException {
    ExpectedCondition expectedCondition = statePopupData.isState()
        ? ExpectedConditions.visibilityOfElementLocated(By.xpath(getPopup())) :
        ExpectedConditions.visibilityOfElementLocated(By.xpath(getPopup()));
    return (T) this;
  }
}


