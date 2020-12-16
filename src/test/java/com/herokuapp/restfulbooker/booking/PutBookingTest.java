package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.resources.TestData;
import com.herokuapp.restfulbooker.utils.BaseTestCase;
import com.herokuapp.restfulbooker.utils.Endpoint;
import com.herokuapp.restfulbooker.utils.HttpMethod;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class PutBookingTest extends BaseTestCase {

    private Response response;
    private Response responseUpdated;
    private Booking newPayload;
    private Integer responseCreatedBookingId;
    private String firstnameUpdated = "Shigeru";
    private String lastnameUpdated = "Miyamoto";
    private Integer totalPriceUpdated = 1952;
    private Boolean depositPaidUpdated = false;
    private String dateCheckInUpdated = "2020-12-01";
    private String dateCheckOutUpdated = "2020-12-31";
    private String additionalNeedsUpdated = "VIP Taxi service from-to airport";

    @Before
    public void setupTest() {
        // GIVEN Prepare & POST payload
        response = HttpMethod.post(TestData.generateDefaultBookingPayload(),
                Endpoint.MAIN_URL + Endpoint.BOOKING);

        responseCreatedBookingId = response.jsonPath().getInt(Booking.BOOKING_ID_KEY_NAME);

        // Assert the created response before overwriting it
        response.then()
                    .assertThat()
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.FIRST_NAME_KEY_NAME, is(TestData.FIRST_NAME))
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.LAST_NAME_KEY_NAME, is(TestData.LAST_NAME))
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.TOTAL_PRICE_KEY_NAME, is(TestData.TOTAL_PRICE))
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.DEPOSIT_PAID_KEY_NAME, is(TestData.DEPOSIT_PAID))
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.BOOKING_DATES_KEY_NAME + "."
                            + Booking.BOOKING_DATES_CHECK_IN_KEY_NAME, is(TestData.BOOKING_DATES_CHECK_IN))
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.BOOKING_DATES_KEY_NAME + "."
                            + Booking.BOOKING_DATES_CHECK_OUT_KEY_NAME, is(TestData.BOOKING_DATES_CHECK_OUT))
                    .body(Booking.BOOKING_PREFIX_KEY_NAME + Booking.ADDITIONAL_NEEDS_KEY_NAME, is(TestData.ADDITIONAL_NEEDS));

        // Prepare new payload data
        newPayload = new Booking.BookingBuilder()
                .withFirstname(firstnameUpdated)
                .withLastname(lastnameUpdated)
                .withTotalprice(totalPriceUpdated)
                .withDepositpaid(depositPaidUpdated)
                .withBookingdates(new Bookingdates.BookingdatesBuilder()
                        .withCheckin(dateCheckInUpdated)
                        .withCheckout(dateCheckOutUpdated).build())
                .withAdditionalneeds(additionalNeedsUpdated)
                .build();
    }

    @Test
    public void putBookingIdAndVerifyNewData() {
        // WHEN Put new payload and overwrite all data previously POSTed
        responseUpdated = HttpMethod.put(newPayload, Endpoint.MAIN_URL + Endpoint.BOOKING, responseCreatedBookingId);

        // THEN Verify payload's key-values pairs if all updated as expected
        responseUpdated.then()
                .assertThat()
                .body(Booking.FIRST_NAME_KEY_NAME, is(firstnameUpdated))
                .body(Booking.LAST_NAME_KEY_NAME, is(lastnameUpdated))
                .body(Booking.TOTAL_PRICE_KEY_NAME, is(totalPriceUpdated))
                .body(Booking.DEPOSIT_PAID_KEY_NAME, is(depositPaidUpdated))
                .body(Booking.BOOKING_DATES_KEY_NAME + "." + Booking.BOOKING_DATES_CHECK_IN_KEY_NAME,
                        is(dateCheckInUpdated))
                .body(Booking.BOOKING_DATES_KEY_NAME + "." + Booking.BOOKING_DATES_CHECK_OUT_KEY_NAME,
                        is(dateCheckOutUpdated))
                .body(Booking.ADDITIONAL_NEEDS_KEY_NAME, is(additionalNeedsUpdated));
    }

}