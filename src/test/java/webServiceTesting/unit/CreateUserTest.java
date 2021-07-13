package webServiceTesting.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateUserTest {

     CreateUser createUser = new CreateUser();

    String jsonWithUserAndJob = "{\n" +
            "    \"name\": \"testsName\",\n" +
            "    \"job\": \"testJob\"\n" +
            "}";

    String jsonWithUserNameSurnameAndJob = "{\n" +
            "    \"name\": \"testsName autoSurname\",\n" +
            "    \"job\": \"testJob\"\n" +
            "}";

    @Before
    public void setup(){
        createUser.setName("testName");
        createUser.setJob("testJob");

    }
    @Test
    public void buildBody_ValidUserAndJob_shouldReturnJsonWithUserAndJob(){
        Assert.assertEquals(jsonWithUserAndJob,createUser.buildBody());
    }
    @Test
    public void buildBodyWithSurname_validUserandJob_ShouldReturnJsonWithUserNameSurnameandJob(){
        Assert.assertEquals(jsonWithUserNameSurnameAndJob, createUser.buildBodyWithSurname());
    }
}
