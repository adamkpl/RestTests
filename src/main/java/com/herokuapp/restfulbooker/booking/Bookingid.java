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

public class Bookingid {
    private Integer bookingid;
    private Booking booking;

    public Bookingid() {}

    public Bookingid(Integer bookingid, Booking booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Bookingid{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }


    public static final class BookingidBuilder {
        private Integer bookingid;
        private Booking booking;

        public BookingidBuilder() {}

        public static BookingidBuilder aBookingid() {
            return new BookingidBuilder();
        }

        public BookingidBuilder withBookingid(Integer bookingid) {
            this.bookingid = bookingid;
            return this;
        }

        public BookingidBuilder withBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Bookingid build() {
            Bookingid bookingidobj = new Bookingid();
            bookingidobj.setBookingid(bookingid);
            bookingidobj.setBooking(booking);
            return bookingidobj;
        }

    }
}