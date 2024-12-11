package placeHolder.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import placeHolder.models.InfoDataModel1;

public class ObjectUser implements Question<InfoDataModel1> {
    private final String name;
    private final String email;
    private final String age;

    public ObjectUser(String name, String email, String age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }

    @Override
    public InfoDataModel1 answeredBy(Actor actor) {
        return InfoDataModel1.builder()
                .name(name)
                .email(email)
                .age(age).build();
    }
}