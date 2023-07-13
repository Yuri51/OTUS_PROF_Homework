package pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import annotations.Path;

@Path("/")
public class CoursePage extends AbsBasePage<CoursePage> {

  public CoursePage(WebDriver driver) {
    super(driver);
  }

  private String courseNameHeader = "div>div>h1";

  public CoursePage coursePageIsOpen() {
    assertThat(courseNameHeader)
        .as("Course name is not visible")
        .isVisible();
    return this;
  }
}

