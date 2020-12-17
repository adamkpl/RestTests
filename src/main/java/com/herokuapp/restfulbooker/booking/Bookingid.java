package com.herokuapp.restfulbooker.booking;

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

public class Bookingid {

    private Integer bookingid;
    private Booking booking;

    private Bookingid() {}

    public Integer getBookingid() {
        return bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Bookingid that = (Bookingid) otherObject;
        return Objects.equals(bookingid, that.bookingid) && Objects.equals(booking, that.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingid, booking);
    }

    @Override
    public String toString() {
        return "Bookingid{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }

    public static final class Builder {

        private Integer bookingid;
        private Booking booking;

        public Builder() {}

        public Builder withBookingid(Integer bookingid) {
            this.bookingid = bookingid;
            return this;
        }

        public Builder withBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

    }
}