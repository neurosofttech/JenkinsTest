package pagesTast;

import basic.Common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class LoginTest extends Common {
    WebDriver driver;
    Login login ;
    Common common ;



    public LoginTest(WebDriver driver){
      this.driver=driver;


    }

    @BeforeMethod
    public void tearup(){

setup();
        common = PageFactory.initElements(driver, Common.class);
        login = PageFactory.initElements(driver, Login.class);
    }

    @Test
    public void RadioButtonTest() throws InterruptedException {


        //Home  homePage = PageFactory.initElements(driver, Home.class);
        login.varifyRadioButton();
        Thread.sleep(3000);




        driver.quit();


    }

    @Test
    public void dropdownTest() {

        login.varifydropdown();


    }
@AfterMethod
    public void teardown(){


        driver.quit();
    }

}