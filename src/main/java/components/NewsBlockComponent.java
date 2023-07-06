package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Component("id:test_block")
public class NewsBlockComponent extends AbsComponent<NewsBlockComponent> {

  public NewsBlockComponent(WebDriver driver) {
    super(driver);
  }

  public NewsBlockComponent checkLink() {
    getComponentEntity().findElement(By.xpath(".//*")).click();
    return this;
  }
}
