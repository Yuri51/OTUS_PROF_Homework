package otus.bdd.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Если;
import otus.bdd.components.CoursesTilesComponent;

public class FavouriteCoursesBlockSteps {

    @Inject
    private CoursesTilesComponent coursesTilesComponent;

    @Если("Кликнуть на плитку курса {string}")
    public void clickSelectedCourseTile(String title) {
        coursesTilesComponent.moveCourse(title);
    }
}
