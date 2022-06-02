package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Home {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='bmwradio']")
    WebElement radiobutton;
    @FindBy(xpath = "//select[@id='carselect']")
    WebElement dropdown;
    @FindBy(id = "multiple-select-example")
    WebElement Multipleselect;

    @FindBy(id = "benzcheck")
    WebElement chechboxntbenzcheck;

    @FindBy(id = "hondacheck")
    WebElement hondacheck;



    @FindBy(id = "openwindow")
    WebElement openwindowbtn;

    @FindBy(xpath = "//select[@name='categories']")
    WebElement dropdowninsideopenwindow;

    @FindBy(id = "opentab")
    WebElement openTAB;

    @FindBy(id = "confirmbtn")
    WebElement alertconfirmbtn;

    @FindBy(id = "mousehover")
    WebElement mousehover;

    @FindBy(xpath = " //a[text()='Reload']")
    WebElement reloadlink;



    public Home(WebDriver driver) {

        this.driver = driver;

    }

    public void varifyRadioButton() {
        radiobutton.click();

    }

    public void varifydropdown() {


        Select select = new Select(dropdown);
        select.selectByIndex(2);

    }

    public void varifymultipleselection() {
        Select select = new Select(Multipleselect);
        select.selectByIndex(0);
        select.selectByIndex(2);

    }




    public void varifycheckbox() throws InterruptedException {

        chechboxntbenzcheck.click();
        hondacheck.click();
Thread.sleep(4000);

    }
    public void varifywindowhandaller() throws InterruptedException {
        //How to handle popups in Selenium
        openwindowbtn.click();



        String MainWindow = driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();


        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                //dropdowninsideopenwindow
                Select sel=new Select(dropdowninsideopenwindow);
                sel.selectByIndex(3);
                Thread.sleep(4000);

            }

        }
// Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }

    public void varifyopentab() throws InterruptedException {

        openTAB.click();

        // store window handle ids


        ArrayList<String> allwindows = new ArrayList<String>(driver.getWindowHandles());
        //switch to open tab
        driver.switchTo().window(allwindows.get(1));
        System.out.println("New tab title: " + driver.getTitle());

        //dropdowninsideopenwindow
        Select sel=new Select(dropdowninsideopenwindow);
        sel.selectByIndex(1);
        Thread.sleep(4000);

        //switch to first tab
        driver.switchTo().window(allwindows.get(0));
        System.out.println("First tab title: " + driver.getTitle());
        // Opens a new tab and switches to new tab
        //driver.switchTo().newWindow(SafariDriver.WindowType.TAB);

// Opens a new window and switches to new window
       // driver.switchTo().newWindow(WindowType.WINDOW);

    }
public  void varifyalert() throws InterruptedException {


    alertconfirmbtn.click();

    // Switching to Alert
    Alert alert = driver.switchTo().alert();

    // Capturing alert message.
    String alertMessage= driver.switchTo().alert().getText();

   // alert.getText();
    //alert.accept();  //OK button click
   // alert.dismiss();  //Cencel button click

    // Displaying alert message
    System.out.println(alertMessage);
    Thread.sleep(5000);

    // Accepting alert
    alert.accept();

}

public void varifymouseover() throws InterruptedException {



    Actions actions = new Actions(driver);

   // WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
    //Mouse hover menuOption 'Music'

    actions.moveToElement(mousehover).build().perform();
    Thread.sleep(4000);

    reloadlink.click();
    System.out.println("Done Mouse hover");


}
}
