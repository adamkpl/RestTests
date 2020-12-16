package com.herokuapp.restfulbooker.booking;

import com.herokuapp.restfulbooker.resources.TestData;
import com.herokuapp.restfulbooker.utils.BaseTestCase;
import com.herokuapp.restfulbooker.utils.Endpoint;
import com.herokuapp.restfulbooker.utils.HttpMethod;
import com.utils.StatusCode;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static com.herokuapp.restfulbooker.resources.TestData.LOGINS;
import static com.herokuapp.restfulbooker.resources.TestData.PASSWORDS;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class AuthenticationTest extends BaseTestCase {

    private String login;
    private String password;
    private Response responseInvalidCredentials;

    public AuthenticationTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameters(name = "{index}: {0} & {1}")
    public static Iterable<Object[]> credentials() {
        return Arrays.asList(new Object[][]{
                {LOGINS[0], PASSWORDS[0]}
                , {LOGINS[0], PASSWORDS[1]}
                , {LOGINS[0], PASSWORDS[2]}
                , {LOGINS[1], PASSWORDS[0]}
                , {LOGINS[1], PASSWORDS[1]}
                , {LOGINS[1], PASSWORDS[2]}
                , {LOGINS[2], PASSWORDS[0]}
                , {LOGINS[2], PASSWORDS[1]}
                //,{TestData.LOGINS[2],TestData.PASSWORDS[2]}
        });
    }

    @Before
    public void setupTest() {
        // GIVEN Prepare & PUT payload with invalid credentials
        responseInvalidCredentials = HttpMethod.put(login, password, TestData.generateDefaultBookingPayload(),
                Endpoint.MAIN_URL + Endpoint.BOOKING, 1);
    }

    @Test
    public void shouldReturnStatusCodeForbidden403ForInvalidCredentials() {
        assertEquals(StatusCode.SC_FORBIDDEN, responseInvalidCredentials.getStatusCode());
    }

}