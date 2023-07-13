package main;


import components.CourseTileComponent;
import components.EducationMenuComponent;
import exceptions.PathEmptyException;
import extentsions.UIExtensions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.MainPage;
import annotations.Driver;


@ExtendWith(UIExtensions.class)
public class OtusHomework1_Test {

  @Driver
  public WebDriver driver;

  @Test
  public void filterCoursesTest() throws PathEmptyException {
    new MainPage(driver)
        .open();
    new CourseTileComponent(driver)
        .filterCoursesByTitle("Специализация Java-разработчик");
  }

  @Test
  public void selectCourseTest() throws PathEmptyException {
    new MainPage(driver)
        .open();
    new CourseTileComponent(driver)
        .moveCourse("Специализация Java-разработчик");
  }

  @Test
  public void moveToEducationMenuComponentTest() throws PathEmptyException, InterruptedException {
    new MainPage(driver)
        .open();
    new EducationMenuComponent(driver)
        .moveToEducationMenu("Обучение");
  }

  @Test
  public void clickOnEarlyCourseTest() throws PathEmptyException {
    new MainPage(driver)
        .open();
    new CourseTileComponent(driver)
        .getEarlierLaterCourse(true);
    new CoursePage(driver)
        .coursePageIsOpen();
  }

  @Test
  public void clickOnLatestCourseTest() throws PathEmptyException {
    new MainPage(driver)
        .open();
    new CourseTileComponent(driver)
        .getEarlierLaterCourse(false);
    new CoursePage(driver)
        .coursePageIsOpen();
  }
}