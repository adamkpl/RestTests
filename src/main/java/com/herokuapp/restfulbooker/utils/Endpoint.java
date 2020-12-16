package com.herokuapp.restfulbooker.utils;

/**
 * Application's endpoints.
 * @see <a href="https://restful-booker.herokuapp.com/">Restful-Booker</a>
 */

public class Endpoint {

    /**
     * @see <a href="https://restful-booker.herokuapp.com/apidoc/index.html">API documentation</a>
     */
    public static final String MAIN_URL = "https://restful-booker.herokuapp.com";

    /**
     * @see <a href="https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth">Auth - CreateToken</a>
     */
    public static final String AUTH = "/auth";

    /**
     * @see <a href="https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking">Booking</a>
     */
    public static final String BOOKING = "/booking";

    /**
     * @see <a href="https://restful-booker.herokuapp.com/apidoc/index.html#api-Ping">Ping - HealthCheck</a>
     */
    public static final String PING = "/ping";
}