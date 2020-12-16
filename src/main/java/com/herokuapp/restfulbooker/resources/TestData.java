package com.herokuapp.restfulbooker.resources;

import com.herokuapp.restfulbooker.booking.Booking;
import com.herokuapp.restfulbooker.booking.Bookingdates;
import com.herokuapp.restfulbooker.utils.Authentication;

/**
 * <p>Fixed Test Data should be used as shown below</p>
 *
 * <pre>
 * import com.herokuapp.restfulbooker.booking.Booking;
 * import com.herokuapp.restfulbooker.booking.Bookingdates;
 *
 *      Booking booking = new Booking.BookingBuilder()
 *          .withFirstname(TestData.FIRST_NAME)
 *          .withLastname(TestData.LAST_NAME)
 *          .withTotalprice(TestData.TOTAL_PRICE)
 *          .withDepositpaid(TestData.DEPOSIT_PAID)
 *          .withBookingdates(new Bookingdates.BookingdatesBuilder()
 *                  .withCheckin(TestData.BOOKING_DATES_CHECK_IN)
 *                  .withCheckout(TestData.BOOKING_DATES_CHECK_OUT).build())
 *          .withAdditionalneeds(TestData.ADDITIONAL_NEEDS)
 *          .build();
 * </pre>
 */

public class TestData {
    public static final String FIRST_NAME = "James";
    public static final String LAST_NAME = "Bond";
    public static final Integer TOTAL_PRICE = 1962;
    public static final Boolean DEPOSIT_PAID = true;
    public static final String BOOKING_DATES_CHECK_IN = "2018-01-01";
    public static final String BOOKING_DATES_CHECK_OUT = "2018-01-14";
    public static final String ADDITIONAL_NEEDS = "Martini. Shaken, not stirred.";

    // Credentials for Authentication tests
    public static final String[] LOGINS = {"", "invalid", Authentication.DEMO_USERNAME};
    public static final String[] PASSWORDS = {"", "invalid", Authentication.DEMO_PASSWORD};

    public static Booking generateDefaultBookingPayload() {
        return new Booking.BookingBuilder()
                .withFirstname(FIRST_NAME)
                .withLastname(LAST_NAME)
                .withTotalprice(TOTAL_PRICE)
                .withDepositpaid(DEPOSIT_PAID)
                .withBookingdates(new Bookingdates.BookingdatesBuilder()
                        .withCheckin(BOOKING_DATES_CHECK_IN)
                        .withCheckout(BOOKING_DATES_CHECK_OUT).build())
                .withAdditionalneeds(ADDITIONAL_NEEDS)
                .build();
    }
}