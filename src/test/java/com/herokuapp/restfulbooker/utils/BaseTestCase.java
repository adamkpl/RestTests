package com.herokuapp.restfulbooker.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;

public class BaseTestCase {

    protected static RequestSpecification requestSpecification;

    @BeforeClass
    public static void setupClass() {
        //todo Full and proper requestSpecification implementation
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoint.MAIN_URL)
                .build();

        Assert.assertTrue("Service API did not return proper status code.", Ping.isOK());
    }

}