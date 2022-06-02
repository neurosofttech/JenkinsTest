package basic;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeTest {
    WebDriver driver;
   @Test
    public void verifyHome() throws InterruptedException {
       WebDriverManager.chromedriver().setup();

       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       driver.get("https://courses.letskodeit.com/practice");

       Home homePage= PageFactory.initElements(driver, Home.class);
       //homePage.verifyRadioButton();
      // homePage.verifyDropDown();
       //homePage.verifyMultiDropDown();
      // homePage.verifyCheckbox();
       //homePage.verifySwitchWindow();
       //homePage.verifySwitchTab();


       homePage.verifyEnterName();
       homePage.verifyEnableField();
       homePage.verfyHidebtn();
       homePage.verifyShowbtn();
       homePage.verifyMouseHover();
       homePage.verifyFrame();
   }
}
