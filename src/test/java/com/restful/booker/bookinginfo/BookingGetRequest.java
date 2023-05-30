package com.restful.booker.bookinginfo;

import com.restful.booker.testbase.TestBaseBooking;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingGetRequest extends TestBaseBooking {

    @Test
    public void getAllIds(){
        given().log().all()
                .when()
                .get()
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getBookingById(){
        given().log().all()
                .header("Accept","application/json")
                .pathParam("bookingId", "1")
                .when()
                .get("/{bookingId}")
                .then()
                .statusCode(200)
                .log().all();
    }

}
