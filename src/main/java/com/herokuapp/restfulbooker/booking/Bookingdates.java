package com.herokuapp.restfulbooker.booking;

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

    public Bookingdates() {}

    public Bookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Bookingdates{" +
                "dateCheckIn='" + checkin + '\'' +
                ", dateCheckOut='" + checkout + '\'' +
                '}';
    }

    public static final class BookingdatesBuilder {

        private String checkin;
        private String checkout;

        public BookingdatesBuilder() {}

        public static BookingdatesBuilder aBookingdates() {
            return new BookingdatesBuilder();
        }

        public BookingdatesBuilder withCheckin(String checkin) {
            this.checkin = checkin;
            return this;
        }

        public BookingdatesBuilder withCheckout(String checkout) {
            this.checkout = checkout;
            return this;
        }

        public Bookingdates build() {
            Bookingdates bookingdates = new Bookingdates();
            bookingdates.setCheckin(checkin);
            bookingdates.setCheckout(checkout);
            return bookingdates;
        }
    }
}