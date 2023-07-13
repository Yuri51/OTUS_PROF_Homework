package pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import annotations.Path;

@Path("/")
public class MainPage extends AbsBasePage<MainPage> {
  public MainPage(WebDriver driver) {
    super(driver);
  }

  private String courseSectionsLocator = "//main//div[section]";

  public MainPage pageCourseSectionsShouldBeVisible() {
    List<WebElement> sections = $$(courseSectionsLocator);
    long actualCourseThumbs = sections.stream().filter(
        (WebElement courseThumbs) -> waiters.waitForElementVisible(courseThumbs)).count();
    assertThat(actualCourseThumbs)
        .as("")
        .isEqualTo(sections.size());
    return this;
  }
}

