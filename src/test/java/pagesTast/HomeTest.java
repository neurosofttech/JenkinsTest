package pagesTast;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class HomeTest {
    WebDriver driver;
    Home homePage ;



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://courses.letskodeit.com/practice");

        homePage = PageFactory.initElements(driver, Home.class);///
    }

    @Test
    public void RadioButtonTest() throws InterruptedException {


        //Home  homePage = PageFactory.initElements(driver, Home.class);
        homePage.varifyRadioButton();
        Thread.sleep(3000);
        driver.quit();


    }

    @Test
    public void dropdownTest() {

        homePage.varifydropdown();


    }
@Test
    public void multipleselectTest(){

        homePage.varifymultipleselection();
    }

@Test

    public void checkboxTest() throws InterruptedException {
        homePage.varifycheckbox();


    }

    @Test
    public void OpenwindowTest() throws InterruptedException {

        homePage.varifywindowhandaller();
    }

@Test
    public void openTabTest() throws InterruptedException {

        homePage.varifyopentab();

    }


    @Test
    public void alertTest() throws InterruptedException {
        homePage.varifyalert();

    }

    @Test
    public void mouseoverTest() throws InterruptedException {

        homePage.varifymouseover();

    }

    @Test
    public void iframeTest() throws InterruptedException {

        homePage.varifyiframe();

    }


@AfterMethod
    public void teardown(){
        driver.quit();
    }

}