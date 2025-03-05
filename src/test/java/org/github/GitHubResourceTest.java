package org.github;
import io.quarkus.test.junit.QuarkusTest;
//
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

@QuarkusTest
public class GitHubResourceTest {
    @Test
    void returnRepoWithBranches() {
        //given 
        String ownerLogin = "gragland"; //test user
        given()
            .when().get("/github/" + ownerLogin) //when
            .then().statusCode(200) //then
            .contentType(ContentType.JSON)
            .body("$.size()", greaterThan(0)) //repo exist 
            .body("[0].branches.size()", greaterThan(0)) //branches exist 
            .body("fork", everyItem(is(false))); //forks not exist
    }
}
