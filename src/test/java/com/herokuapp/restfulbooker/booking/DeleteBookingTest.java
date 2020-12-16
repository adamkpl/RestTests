package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.resources.TestData;
import com.herokuapp.restfulbooker.utils.BaseTestCase;
import com.herokuapp.restfulbooker.utils.Endpoint;
import com.herokuapp.restfulbooker.utils.HttpMethod;
import com.utils.StatusCode;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteBookingTest extends BaseTestCase {

    private Response responseToDelete;
    private Integer actualBookingId;

    @Before
    public void setupTest() {
        // GIVEN Prepare & POST payload
        responseToDelete = HttpMethod.post(TestData.generateDefaultBookingPayload(),
                Endpoint.MAIN_URL + Endpoint.BOOKING);

        actualBookingId = responseToDelete.jsonPath().getInt(Booking.BOOKING_ID_KEY_NAME);
    }

    @Test
    public void verifyResponseStatusCodeAfterDelete() {
        // WHEN Delete THEN return Status Code = 201 Created
        Assert.assertEquals("Response status code should be: " + StatusCode.SC_CREATED, StatusCode.SC_CREATED,
                HttpMethod.delete(Endpoint.MAIN_URL + Endpoint.BOOKING, actualBookingId).getStatusCode());
    }

    @Test
    public void verifyIfPostedPayloadStillExistsAfterDelete() {
        // WHEN Delete previously POSTED payload
        HttpMethod.delete(Endpoint.MAIN_URL + Endpoint.BOOKING, actualBookingId);
        // THEN Get return Status Code = 404 Not Found
        HttpMethod.get(Endpoint.MAIN_URL + Endpoint.BOOKING, actualBookingId)
                .then().assertThat().statusCode(StatusCode.SC_NOT_FOUND);
    }

}