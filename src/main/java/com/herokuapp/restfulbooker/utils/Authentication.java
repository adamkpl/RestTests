package com.herokuapp.restfulbooker.utils;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static final String DEMO_USERNAME = "admin";
    public static final String DEMO_PASSWORD = "password123";

    public static RequestSpecification authenticate(String username, String password) {
        return given().auth().preemptive().basic(username, password);
    }

    public static RequestSpecification authenticate() {
        return authenticate(DEMO_USERNAME, DEMO_PASSWORD);
    }

}