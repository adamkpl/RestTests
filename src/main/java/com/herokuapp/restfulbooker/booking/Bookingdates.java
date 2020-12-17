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

public class Bookingdates {

    private String checkin;
    private String checkout;

    private Bookingdates() {}

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Bookingdates that = (Bookingdates) otherObject;
        return Objects.equals(checkin, that.checkin) && Objects.equals(checkout, that.checkout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkin, checkout);
    }

    @Override
    public String toString() {
        return "Bookingdates{" +
                "dateCheckIn='" + checkin + '\'' +
                ", dateCheckOut='" + checkout + '\'' +
                '}';
    }

    public static final class Builder {

        private String checkin;
        private String checkout;

        public Builder() {}

        public Builder withCheckin(String checkin) {
            this.checkin = checkin;
            return this;
        }

        public Builder withCheckout(String checkout) {
            this.checkout = checkout;
            return this;
        }

        public Bookingdates build() {
            Bookingdates bookingdates = new Bookingdates();
            bookingdates.checkin = this.checkin;
            bookingdates.checkout = this.checkout;
            return bookingdates;
        }
    }
}