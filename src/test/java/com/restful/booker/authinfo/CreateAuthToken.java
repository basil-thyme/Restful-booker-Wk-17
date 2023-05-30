package com.restful.booker.authinfo;

import com.restful.booker.model.AuthPojo;
import com.restful.booker.testbase.TestBaseAuth;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateAuthToken extends TestBaseAuth {
    static String token;

    @Test
    public void createToken(){
        AuthPojo authPojo=new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");

        String token =given()
                .header("Content-Type","application/json")
                .body(authPojo)
                .when()
                .post()
                .then().extract().path("token");
        System.out.println("Token is: " +token);


    }

}
