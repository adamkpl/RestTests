package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.resources.TestData;
import com.herokuapp.restfulbooker.utils.BaseTestCase;
import com.herokuapp.restfulbooker.utils.Endpoint;
import com.herokuapp.restfulbooker.utils.HttpMethod;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBookingsTest extends BaseTestCase {

    private Response responseCreated;
    private Response responseUnfiltered;
    private Response responseFiltered;

    @Before
    public void setupTest() {
        // GIVEN Prepare & POST payload
        responseCreated = HttpMethod.post(TestData.generateDefaultBookingPayload(),
                Endpoint.MAIN_URL + Endpoint.BOOKING);
    }

    @Test
    public void getUnfilteredBookingIdsListShouldNotBeEmpty() {
        // WHEN Get the ids of all the bookings that exist within the API
        responseUnfiltered = responseCreated;
        responseUnfiltered = given().spec(requestSpecification).get(Endpoint.BOOKING);

        List<Integer> bookingIds = responseUnfiltered.jsonPath().getList(Booking.BOOKING_ID_KEY_NAME);
        // THEN Assert list should NOT be empty
        Assert.assertFalse("List is empty, but it should NOT be", bookingIds.isEmpty());
    }

    @Test
    public void getFilteredBookingIdsListShouldNotBeEmpty() {
        // WHEN Get specific ids
        responseFiltered = responseCreated;
        responseFiltered = given()
                .spec(requestSpecification
                    .queryParam(Booking.FIRST_NAME_KEY_NAME, TestData.FIRST_NAME)
                    .queryParam(Booking.LAST_NAME_KEY_NAME, TestData.LAST_NAME))
                .get(Endpoint.BOOKING);

        List<Integer> bookingIds = responseFiltered.jsonPath().getList(Booking.BOOKING_ID_KEY_NAME);
        // THEN Assert list should NOT be empty, and have at least 1 id
        Assert.assertFalse("List is empty, but it should not be", bookingIds.isEmpty());
    }
}