package core.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public abstract class RestAssuredConfiguration {
    private static RequestSpecification requestSpecification;

    /**
     * Base request and response setting for RestAssured
     */
    public static void baseSetup() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(Endpoints.BASE_URI)
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        RestAssured.requestSpecification = requestSpecification;
    }

}
