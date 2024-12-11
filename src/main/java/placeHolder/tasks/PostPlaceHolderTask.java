package placeHolder.tasks;

import placeHolder.models.InfoDataModel1;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPlaceHolderTask implements Task {
    private final InfoDataModel1 user;
    private final String endPoint;

    public PostPlaceHolderTask(InfoDataModel1 user, String endPoint) {
        this.user = user;
        this.endPoint = endPoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endPoint).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("accept", "application/json")
                                .body(user).log().all()
                )
        );

    }

    public static Performable withUserData(InfoDataModel1 user, String endPoint) {
        return instrumented(PostPlaceHolderTask.class, user, endPoint);
    }
}