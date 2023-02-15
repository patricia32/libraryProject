package libraryproject.cucumberTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;

    @Given("browser is open")
    public void browser_is_open() {
        String projectPath=System.getProperty("user.dir");
        System.out.println("Path = "+projectPath);

        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("http://localhost:8090/account/login");
    }


    @When("user enters username and password")
    public void user_enters_email_and_password_fail() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("client@dsaf.com");
        driver.findElement(By.name("password")).sendKeys("123d456");

        Thread.sleep(2000);
    }


    @And("user clicks on login")
    public void user_clicks_on_login() {
        driver.findElement(By.name("action")).click();
    }


    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_client_page() throws InterruptedException {

        driver.findElement(By.className("content"));
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
