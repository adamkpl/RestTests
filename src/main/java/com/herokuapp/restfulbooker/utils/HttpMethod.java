package com.herokuapp.restfulbooker.utils;

import com.herokuapp.restfulbooker.booking.Booking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class HttpMethod {
    //todo PATCH

    public static Response get(String fromEndpoint, Integer id) {
        String parameterName = Booking.BOOKING_PREFIX_KEY_NAME.replace(".", "") + "Id";

        return given()
                    .contentType(ContentType.JSON) // Default: "application/json"
                    .pathParam(parameterName, id)
                    //.header("Accept", ContentType.XML) // XML: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBooking
                .when()
                    .get(fromEndpoint + "/{" + parameterName + "}")
                .then()
                    .extract()
                    .response();
    }

    public static Response get(String path, Integer id, RequestSpecification requestSpecification) {
        String parameterName = Booking.BOOKING_PREFIX_KEY_NAME.replace(".", "") + "Id";

        return given()
                    .spec(requestSpecification)
                    .contentType(ContentType.JSON) // Default: "application/json"
                    .pathParam(parameterName, id)
                //.header("Accept", ContentType.XML) // XML: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBooking
                .when()
                    .get(path + "/{" + parameterName + "}")
                .then()
                    .extract()
                    .response();
    }

    public static Response post(Object payload, String toEndpoint) {
        return given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .post(toEndpoint)
                .then()
                    .extract()
                    .response();
    }

    public static Response put(Object payload, String toEndpoint, Integer id) {
        return Authentication.authenticate() // Required: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-UpdateBooking
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .put(toEndpoint + "/" + id)
                .then()
                    .extract()
                    .response();
    }

    public static Response put(String login, String password, Object payload, String toEndpoint, Integer id) {
        return Authentication.authenticate(login, password) // Required: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-UpdateBooking
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .put(toEndpoint + "/" + id)
                .then()
                    .extract()
                    .response();
    }

    public static Response delete(String fromEndpoint, Integer id) {
        return Authentication.authenticate() // Required: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-DeleteBooking
                    .contentType(ContentType.JSON)
                .when()
                    .delete(fromEndpoint + "/" + id)
                .then()
                    .extract()
                    .response();
    }

    public static Response delete(String login, String password, String fromEndpoint, Integer id) {
        return Authentication.authenticate(login, password) // Required: https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-DeleteBooking
                    .contentType(ContentType.JSON)
                .when()
                    .delete(fromEndpoint + "/" + id)
                .then()
                    .extract()
                    .response();
    }
}