package com.restful.booker.bookinginfo;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBaseBooking;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPutRequest extends TestBaseBooking {
    @Test
    public void updateBooking() {

        HashMap<String, Object> booking = new HashMap<String, Object>();
        booking.put("checkin", "2022-01-01");
        booking.put("checkout", "2022-02-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Name after");
        bookingPojo.setLastname("put request");
        bookingPojo.setTotalprice(300);
        bookingPojo.setDepositpaid(false);
        bookingPojo.setBookingdates(booking);
        bookingPojo.setAdditionalneeds("Vegetarian Meals");

     given().log().all()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("cookie", "token=34d8e0a4880dd78")
                .pathParam("bookingId", "1")
                .body(bookingPojo)
                .when()
                .put("/{bookingId}")
                .then()
             .statusCode(200)
                .log().all();
    }

}
