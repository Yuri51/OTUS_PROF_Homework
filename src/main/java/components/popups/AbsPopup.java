package components.popups;

import annotations.Popup;
import exceptions.PathEmptyException;
import org.openqa.selenium.WebDriver;
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
}


