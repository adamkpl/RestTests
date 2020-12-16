package com.herokuapp.restfulbooker.utils;

import com.utils.StatusCode;
import io.restassured.RestAssured;

public class Ping {

    public static Boolean isOK() {
        return RestAssured
                .given()
                    .get(Endpoint.MAIN_URL)
                .then()
                    .assertThat()
                    .statusCode(StatusCode.SC_OK)
                    .extract()
                    .statusCode() == StatusCode.SC_OK;
    }

}