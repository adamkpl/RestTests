package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.domainObjects.AbstractEntry;

/**
 * Booking
 * <p>
 * Example GET JSON Response:
 * <br>
 * HTTP/1.1 200 OK
 * Server: Cowboy
 * Connection: keep-alive
 * X-Powered-By: Express
 * Content-Type: application/json; charset=utf-8
 * Content-Length: 210
 * Etag: W/"d2-fc3UWT+PMqLZpHGsjB4F3iGGY+4"
 * Date: Mon, 14 Dec 2020 19:15:36 GMT
 * Via: 1.1 vegur
 *
 * {
 *     "bookingid": 11,
 *     "booking": {
 *         "firstname": "Jim",
 *         "lastname": "Brown",
 *         "totalprice": 111,
 *         "depositpaid": true,
 *         "bookingdates": {
 *             "checkin": "2018-01-01",
 *             "checkout": "2018-01-14"
 *         },
 *         "additionalneeds": "Breakfast before 7:00 AM"
 *     }
 * }
 * </pre>
 */

public class Booking extends AbstractEntry {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    public static final String BOOKING_PREFIX_KEY_NAME = "booking.";
    public static final String BOOKING_ID_KEY_NAME = "bookingid";
    public static final String FIRST_NAME_KEY_NAME = "firstname";
    public static final String LAST_NAME_KEY_NAME = "lastname";
    public static final String TOTAL_PRICE_KEY_NAME = "totalprice";
    public static final String DEPOSIT_PAID_KEY_NAME = "depositpaid";
    public static final String BOOKING_DATES_KEY_NAME = "bookingdates";
    public static final String BOOKING_DATES_CHECK_IN_KEY_NAME = "checkin";
    public static final String BOOKING_DATES_CHECK_OUT_KEY_NAME = "checkout";
    public static final String ADDITIONAL_NEEDS_KEY_NAME = "additionalneeds";

    private Booking() {}

    private Booking(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Bookingdates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }

    public static final class BookingBuilder {

        private String firstname;
        private String lastname;
        private Integer totalprice;
        private Boolean depositpaid;
        private Bookingdates bookingdates;
        private String additionalneeds;

        public BookingBuilder() {}

        public static BookingBuilder aBooking() {
            return new BookingBuilder();
        }

        public BookingBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public BookingBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public BookingBuilder withTotalprice(Integer totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public BookingBuilder withDepositpaid(Boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public BookingBuilder withBookingdates(Bookingdates bookingdates) {
            this.bookingdates = bookingdates;
            return this;
        }

        public BookingBuilder withAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
            return this;
        }

        public Booking build() {
            Booking booking = new Booking();
            booking.setFirstname(firstname);
            booking.setLastname(lastname);
            booking.setTotalprice(totalprice);
            booking.setDepositpaid(depositpaid);
            booking.setBookingdates(bookingdates);
            booking.setAdditionalneeds(additionalneeds);
            return booking;
        }
    }
}