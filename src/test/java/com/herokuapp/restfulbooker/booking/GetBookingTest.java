package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.resources.TestData;
import com.herokuapp.restfulbooker.utils.BaseTestCase;
import com.herokuapp.restfulbooker.utils.Endpoint;
import com.herokuapp.restfulbooker.utils.HttpMethod;
import com.utils.StatusCode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class GetBookingTest extends BaseTestCase {

    private static Response response;

    @BeforeClass
    public static void setupTest() {
        // GIVEN Prepare & POST payload
        response = HttpMethod.get(Endpoint.MAIN_URL + Endpoint.BOOKING,
                HttpMethod.post(TestData.generateDefaultBookingPayload(),
                        Endpoint.MAIN_URL + Endpoint.BOOKING).jsonPath().getInt(Booking.BOOKING_ID_KEY_NAME));
    }

    @Test
    public void shouldBeContentTypeJson() {
        // THEN Assert that the format of payload received is application/json
        response.then()
                    .assertThat()
                    .contentType(ContentType.JSON);
    }

    @Test
    public void shouldGetResponseInLessThan3seconds() {
        // THEN get response time in max. 3 seconds
        response.then()
                    .assertThat()
                    .time(Matchers.lessThan(3000L));
    }

    @Test
    public void shouldRespondOKWhenGetResponse() {
        // THEN Return Status Code = 200 OK
        response.then()
                    .assertThat()
                    .statusCode(StatusCode.SC_OK);
    }

    @Test
    public void shouldGetCreatedPayloadAndVerifyAllValuesInsertedCorrectly() {
        // THEN Verify payload's key-values pairs if all were inserted as expected
        response.then()
                    .assertThat()
                    .body(Booking.FIRST_NAME_KEY_NAME, is(TestData.FIRST_NAME))
                    .body(Booking.LAST_NAME_KEY_NAME, is(TestData.LAST_NAME))
                    .body(Booking.TOTAL_PRICE_KEY_NAME, is(TestData.TOTAL_PRICE))
                    .body(Booking.DEPOSIT_PAID_KEY_NAME, is(TestData.DEPOSIT_PAID))
                    .body(Booking.BOOKING_DATES_KEY_NAME + "." + Booking.BOOKING_DATES_CHECK_IN_KEY_NAME,
                            is(TestData.BOOKING_DATES_CHECK_IN))
                    .body(Booking.BOOKING_DATES_KEY_NAME + "." + Booking.BOOKING_DATES_CHECK_OUT_KEY_NAME,
                            is(TestData.BOOKING_DATES_CHECK_OUT))
                    .body(Booking.ADDITIONAL_NEEDS_KEY_NAME, is(TestData.ADDITIONAL_NEEDS));
    }

}