package com.typicode.jsonplaceholder.comments;

import com.typicode.jsonplaceholder.utils.Endpoints;
import com.typicode.jsonplaceholder.utils.StatusCodes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Get Comments Test
 * @version     alpha 0.2
 * @since       2020-02-07
 * @author      Adam K.
 */

public class GetCommentTest {

    private static Response response;

    @BeforeClass
    public static void getCommentsEndpoint(){
        response =
                given()
                    .expect()
                    .statusCode(StatusCodes.SC_OK)
                .when()
                    .get(Endpoints.COMMENTS_ENDPOINT);
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