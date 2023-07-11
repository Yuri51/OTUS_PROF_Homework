package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@Component("id:Course_block")
public class CourseTileComponent extends AbsComponent<CourseTileComponent> {
  public CourseTileComponent(WebDriver driver) {
    super(driver);
  }

  private String courseNameSelector = "div>h5";
  private String courseStartDateLocator = "//span[contains(text(), 'С ')]";

  private String courseTrainingPeriodLocator = "//span[contains(text(), 'месяц')]";

  public List<WebElement> getCourseNames() {
    return driver.findElements(By.cssSelector(courseNameSelector));
  }

  public List<WebElement> getCourseDataBegin() {
    return driver.findElements(By.xpath(courseStartDateLocator));
  }

  public void moveToCourse(String title) {
    moveAndPerform(driver.findElement(By.cssSelector(String.format(courseNameSelector, title))));
  }

  public void moveAndPerform(WebElement element) {
    waiters.waitForCondition(ExpectedConditions.visibilityOf(element));
    actions.moveToElement(element);
    actions.click().build().perform();
  }

  private List<Date> getDataList() {
    SimpleDateFormat format = new SimpleDateFormat("d MMMM", Locale.forLanguageTag("ru"));
    List<Date> dataList = driver.findElements(By.xpath(String.format(courseStartDateLocator)))
        .stream()
        .map(element -> element.getText().replace("С ", ""))
        .map(date -> {
          try {
            return format.parse(date);
          } catch (ParseException e) {
            throw new RuntimeException(e);
          }
        })
        .collect(Collectors.toList());

//    List<Date> TrainingPeriodList = driver.findElements(By.xpath(String.format(courseTrainingPeriodLocator)))
//        .stream().filter(element -> Pattern.matches("\\d+\\s+[а-яёА-ЯЁ]+\\s+\\d+\\s+[а-яёА-ЯЁ]+", element.getText()))
//        .map(el -> el.getText().replaceFirst("\\d+\s+месяцев|месяца", ""))
//        .map(period -> {
//          try {
//            return format.parse(period.replace("\\s+", ""));
//          } catch (ParseException e) {
//            throw new RuntimeException(e);
//          }
//        })
//        .collect(Collectors.toList());
//    getDataList().addAll(TrainingPeriodList);
    return dataList;
  }

  public CourseTileComponent getEarlierLaterCourse(boolean isEarly){
    BinaryOperator<Date> selectDate = null;
    if (isEarly){
      selectDate = (Date date1, Date date2) -> date1.before(date2) ? date1 : date2;
    }else {
      selectDate = (Date date1, Date date2) -> date1.after(date2) ? date1 : date2;
    }

    Date earlyDate = getDataList()
        .stream()
        .reduce(selectDate)
        .get();

    clickCourseByDate(earlyDate);

    return this;
  }

  public void clickCourseByDate(Date date){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    String partialLinkText = calendar.get(Calendar.DAY_OF_MONTH)
        + " " + Month.of(calendar.get(Calendar.MONTH) + 1).getDisplayName(TextStyle.FULL, new Locale("ru"));

    this.actions.moveToElement(findElement(By.partialLinkText(partialLinkText)))
        .click()
        .build()
        .perform();
  }

  private WebElement findElement(By by) {
    return driver.findElement(by);
  }

}


