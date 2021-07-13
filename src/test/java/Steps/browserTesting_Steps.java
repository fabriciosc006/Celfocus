package Steps;

import Pages.Home;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class browserTesting_Steps {
    String url;
    WebDriver driver;
    Home home;

    @Before
    public void start(){
        url = "https://qa-automation-challenge.github.io/sandbox/";
        System.setProperty("webdriver.chrome.driver", "Chromedriver91.04/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        home = new Home(driver);
    }

    @After
    public void finish(){
        //driver.quit();
    }

    @Given("^I open Chrome and launch the application$")
    public void i_open_Chrome_and_launch_the_application() throws InterruptedException{
        driver.get(url);
        Thread.sleep(2000);
    }

    @Given("^I select type \"([^\"]*)\"$")
    public void i_select_type(String type)  {
          home.selectType(type);

    }

    @Given("^I select support plan \"([^\"]*)\"$")
    public void i_select_support_plan(String plan)  {
         home.selectSupportPlan(plan);

    }

    @Given("^I write monthly duration of \"([^\"]*)\"$")
    public void i_write_monthly_duration_of(String duration)  {
        home.monthlyDuration(duration);
    }

    @When("^I click in calculate price button$")
    public void i_click_in_calculate_price_button() {

        home.calculatePriceClick();
    }

    @Then("^I validate price is \"([^\"]*)\"$")
    public void i_validate_price_is(String price) throws InterruptedException  {
        Thread.sleep(5*1000);
        Assert.assertEquals(price, home.returnPrice());

    }
}
