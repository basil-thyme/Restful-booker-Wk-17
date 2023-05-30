package com.restful.booker.bookinginfo;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBaseBooking;
import com.restful.booker.utils.TestUtils;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPostRequest extends TestBaseBooking {

@Test
    public void createANewBooking(){
    HashMap<String, Object> booking = new HashMap<String, Object>();
    booking.put("checkin","2022-01-01");
    booking.put("checkout","2022-02-01");

    BookingPojo bookingPojo=new BookingPojo();

    bookingPojo.setFirstname(  "John" + TestUtils.getRandomValue());
    bookingPojo.setLastname( "Smith" +TestUtils.getRandomValue());
    bookingPojo.setTotalprice(200);
    bookingPojo.setDepositpaid(false);
    bookingPojo.setBookingdates(booking);
    bookingPojo.setAdditionalneeds("Access to Gym");

    given().log().all()
            .contentType(ContentType.JSON)
            .header("Accept","application/json")
            .body(bookingPojo)
            .when()
            .post()
            .then()
            .statusCode(200).log().all();



}


}
