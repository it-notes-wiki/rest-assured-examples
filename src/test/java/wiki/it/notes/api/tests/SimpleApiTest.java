package wiki.it.notes.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class SimpleApiTest {

    @Test
    void createUserTest() {
        var user = new User("Gunnar", "manager");

        given()
                .baseUri("https://reqres.in/api/")
                .contentType("application/json")
                .body(user)
                .when()
                .post("users")
                .then()
                .statusCode(201)
                .body("name", equalTo(user.name()))
                .body("job", equalTo(user.job()));
    }
}
