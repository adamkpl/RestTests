package com.typicode.jsonplaceholder.comments;

import com.typicode.jsonplaceholder.utils.Endpoints;
import com.utils.StatusCode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetCommentTest {

    private static Response response;

    @BeforeClass
    public static void getCommentsEndpoint(){
        response =
                given()
                    .expect()
                    .statusCode(StatusCode.SC_OK)
                .when()
                    .get(Endpoints.COMMENTS);
    }

    @Test
    public void getCommentsAssertContentTypeIsJSON(){
        response
                .then()
                    .assertThat()
                    .contentType(ContentType.JSON);
    }

    @Test
    public void getCommentsGetSpecificRecord(){
        response
                .then()
                    .assertThat()
                    .body("email", hasItem("Eliseo@gardner.biz"));
    }

}