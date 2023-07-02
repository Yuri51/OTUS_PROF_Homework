package pages;

import annotations.Template;
import annotations.UrlTemplates;
import org.openqa.selenium.WebDriver;

@UrlTemplates(
        templates = {
                @Template(name = "news", template = "/{1}/new/{2}"),
                @Template(name = "articles", template = "/{1}")
        }
)
public class MainPage extends AbsBasePage<MainPage> {
    public MainPage(WebDriver driver) {
        super(driver);
    }
}
