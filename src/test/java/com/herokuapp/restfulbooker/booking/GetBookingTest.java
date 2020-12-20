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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.Matchers.is;

public class GetBookingTest extends BaseTestCase {

    private static Booking payload;
    private static Response responsePost;
    private static Integer responsePostedId;
    private static Response responseGet;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @BeforeClass
    public static void setupTest() {
        // GIVEN Prepare & POST payload
        payload = TestData.generateDefaultBookingPayload();
        responsePost = HttpMethod.post(payload, Endpoint.MAIN_URL + Endpoint.BOOKING);
        responsePostedId = responsePost.jsonPath().getInt(Booking.BOOKING_ID_KEY_NAME);
        responseGet = HttpMethod.get(Endpoint.MAIN_URL + Endpoint.BOOKING, responsePostedId);
    }

    @Test
    public void shouldBeContentTypeJson() {
        // THEN Assert that the format of payload received is application/json
        responseGet.then()
                .assertThat()
                .contentType(ContentType.JSON);
    }

    @Test
    public void shouldGetResponseInLessThan3seconds() {
        // THEN get response time in max. 3 seconds
        responseGet.then()
                .assertThat()
                .time(Matchers.lessThan(3000L));
    }

    @Test
    public void shouldRespondOKWhenGetResponse() {
        // THEN Return Status Code = 200 OK
        responseGet.then()
                .assertThat()
                .statusCode(StatusCode.SC_OK);
    }

    @Test
    public void shouldGetCreatedPayloadAndVerifyAllValuesInsertedCorrectly() {
        // THEN Verify payload's key-values pairs if all were inserted as expected
        Bookingid bookingPost = responsePost.as(Bookingid.class);
        Booking bookingGet = responseGet.as(Booking.class);

        errorCollector.checkThat(bookingPost.getBooking().getFirstname(), is(bookingGet.getFirstname()));
        errorCollector.checkThat(bookingPost.getBooking().getLastname(), is(bookingGet.getLastname()));
        errorCollector.checkThat(bookingPost.getBooking().getTotalprice(), is(bookingGet.getTotalprice()));
        errorCollector.checkThat(bookingPost.getBooking().getDepositpaid(), is(bookingGet.getDepositpaid()));
        errorCollector.checkThat(bookingPost.getBooking().getBookingdates().getCheckin(), is(bookingGet.getBookingdates().getCheckin()));
        errorCollector.checkThat(bookingPost.getBooking().getBookingdates().getCheckout(), is(bookingGet.getBookingdates().getCheckout()));
        errorCollector.checkThat(bookingPost.getBooking().getAdditionalneeds(), is(bookingGet.getAdditionalneeds()));
    }

}