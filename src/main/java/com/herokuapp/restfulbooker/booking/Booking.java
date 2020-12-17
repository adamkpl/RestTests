package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.domainObjects.AbstractEntry;

import java.util.Objects;

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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Booking booking = (Booking) otherObject;
        return Objects.equals(firstname, booking.firstname)
                && Objects.equals(lastname, booking.lastname)
                && Objects.equals(totalprice, booking.totalprice)
                && Objects.equals(depositpaid, booking.depositpaid)
                && Objects.equals(bookingdates, booking.bookingdates)
                && Objects.equals(additionalneeds, booking.additionalneeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
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

    public static final class Builder {

        private String firstname;
        private String lastname;
        private Integer totalprice;
        private Boolean depositpaid;
        private Bookingdates bookingdates;
        private String additionalneeds;

        public Builder() {}

        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withTotalprice(Integer totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public Builder withDepositpaid(Boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public Builder withBookingdates(Bookingdates bookingdates) {
            this.bookingdates = bookingdates;
            return this;
        }

        public Builder withAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
            return this;
        }

        public Booking build() {
            Booking booking = new Booking();
            booking.firstname = this.firstname;
            booking.lastname = this.lastname;
            booking.totalprice = this.totalprice;
            booking.depositpaid = this.depositpaid;
            booking.bookingdates = this.bookingdates;
            booking.additionalneeds = this.additionalneeds;
            return booking;
        }
    }
}