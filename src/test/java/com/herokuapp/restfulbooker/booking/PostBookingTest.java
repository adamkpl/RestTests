package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.resources.TestData;
import com.herokuapp.restfulbooker.utils.BaseTestCase;
import com.herokuapp.restfulbooker.utils.Endpoint;
import com.herokuapp.restfulbooker.utils.HttpMethod;
import com.utils.StatusCode;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

public class PostBookingTest extends BaseTestCase {

    private Response response;

    @Before
    public void setupTest() {
        // GIVEN Prepare payload
        // WHEN Post
        response = HttpMethod.post(TestData.generateDefaultBookingPayload(),
                Endpoint.MAIN_URL + Endpoint.BOOKING);
    }

    @Test
    public void postPayloadAndVerifyStatusCodeIsOK() {
        // THEN
        response.then()
                .assertThat().statusCode(StatusCode.SC_OK);
    }

}