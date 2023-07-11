package pages;

import static org.assertj.core.api.Assertions.assertThat;
import annotations.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


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

//  public String searchCourseSection(String title) {
//    List<WebElement> sections = $$(courseSectionsLocator)
//        .stream()
//        .filter((WebElement element) -> element.getText().equals(title))
//        .collect(Collectors.toList());
//    return;
//  }
//  }

//  public void clickCourseBy(WebElement element) {
//    actions.moveToElement(element).build().perform();
//    assertThat(waiters.waitForElementVisible(element))
//        .as("Course is displayed on the page");
//    element.click();
//  }
//}

