package main;

import static org.assertj.core.api.Assertions.assertThat;
import annotations.Driver;
import components.CourseTileComponent;
import components.EducationMenuComponent;
import exceptions.PathEmptyException;
import extentsions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import java.util.List;
import java.util.stream.Collectors;


@ExtendWith(UIExtensions.class)
public class MainPage_Test {

  @Driver
  public WebDriver driver;

  @Test
  public void filterCoursesTest() throws PathEmptyException {
    MainPage mainPage = new MainPage(driver)
        .open();
    List<WebElement> collect = new CourseTileComponent(driver)
        .getCourseNames()
        .stream()
        .filter(element -> element.getText().equals("Специализация Python"))
        .collect(Collectors.toList());
    assertThat(collect)
        .as("Course %s not found")
        .hasSize(1);
  }

  @Test
  public void moveToEducationMenuComponent() throws PathEmptyException, InterruptedException {
    new MainPage(driver)
        .open();
    new EducationMenuComponent(driver)
        .moveToEducationMenu("Обучение");
  }

  @Test
  public void clickOnLatestCourseTest() throws PathEmptyException {
    new MainPage(driver)
        .open();
    new CourseTileComponent(driver)
        .getEarlierLaterCourse(true);
  }
}