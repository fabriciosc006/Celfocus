package webServiceTesting.unit;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class CreateUser {
    private String name;
    private String job;

    private final RequestSpecification requestSpecification;

    public CreateUser(){
        this.requestSpecification = RestAssured.given().
                baseUri("https:reqres.in/api").
                basePath("/users");

    }
    public RequestSpecification getRequestSpecification(){
        return requestSpecification;
    }
    public void setName(String Name){
        this.name = name;
    }
    public void setJob(String Job){
        this.job = job;
    }
    public String buildBody() {
        return "{\n" +
                "    \"name\": \"testsName\",\n" +
                "    \"job\": \"testJob\"\n" +
                "}";
    }
    public String buildBodyWithSurname(){
        return "{\n" +
                "    \"name\": \"testsName autoSurname\",\n" +
                "    \"job\": \"testJob\"\n" +
                "}";
    }
}
