package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends PageObject{

    //atributos
    public String Pricereturned;

    @FindBy(id = "type")
    private WebElement selecttype;
    @FindBy(id = "support")
    private WebElement selectsupport;
    @FindBy(id = "duration")
    private WebElement selectduration;
    @FindBy(css = "button[id='calculate']")
    private WebElement buttoncalculate;
    @FindBy(css = "p[id='price']")
    private WebElement priceText;

    //construtor
    public Home (WebDriver driver){
        super (driver);
    }
    //metodos

    public void selectType(String type){
        Select select = new Select(selecttype);
        select.selectByVisibleText(type);
    }
    public void selectSupportPlan(String plan){
        Select select = new Select(selectsupport);
        select.selectByVisibleText(plan);
    }
    public void monthlyDuration(String duration){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("duration")));
        selectduration.sendKeys(duration);
    }
    public void calculatePriceClick(){
          buttoncalculate.click();
    }

    public String returnPrice() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='card']")));
        String priceReturned = priceText.getText();
        Thread.sleep(2000);
        return priceReturned;
    }

}
