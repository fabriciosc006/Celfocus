package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import webServiceTesting.unit.CreateUser;
import static org.hamcrest.core.Is.is;

public class webServiceTesting_Steps {
    CreateUser createUser;
    String name,job;
    Response response;
    String id;
    String jsonemail = "{\n" +
            "    \"email\": \"challenge@automation.com\", \n" +
            "}";

    @Given("^I use user creation service$")
    public void iUseUserCreationService() {
        createUser = new CreateUser();
    }

    @When("^I set name \"([^\"]*)\"$")
    public void iSetName(String name)  {
        createUser.setName(name);
        this.name = name;
    }

    @And("^I set job \"([^\"]*)\"$")
    public void iSetJob(String job)  {
        createUser.setName(job);
        this.job = job;

    }
    @Then("^I validate my response is correct$")
    public void iValidateMyResponseIsCorrect() {
        response =
                RestAssured.given().
                        relaxedHTTPSValidation().
                        body(createUser.buildBody()).
                     when().
                     post("https://reqres.in/api/users");

        response.then().
                        statusCode(HttpStatus.SC_CREATED).
                        log().all();

        id = response.path("id");
        System.out.println(id);

    }

    @When("^I Delete an user$")
    public void iDeleteAnUser() {
    }

    @Then("^I validate user deleted$")
    public void iValidateUserDeleted() {
         RestAssured.given().
                 pathParam("user", "2").
                      when().
                      delete("https://reqres.in/api/users/{user}");
          response.then().statusCode(HttpStatus.SC_NO_CONTENT).
                  log().all();
    }

    @When("^I submit a register without password$")
    public void iSubmitARegisterWithoutPassword() {
    }

    @Then("^I validate the register is not created$")
    public void iValidateTheRegisterIsNotCreated() {
          RestAssured.given().
                  relaxedHTTPSValidation().
                  body(jsonemail).
                  when().
                   post("https://reqres.in/api/register");

          response.then().statusCode(400).
                   body("error", is ("missing password")).
                   log().all();
    }
}
