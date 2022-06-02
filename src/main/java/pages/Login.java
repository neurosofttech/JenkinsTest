package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Login {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='bmwradio']")
    WebElement radiobutton;
    @FindBy(xpath = "//select[@id='carselect']")
    WebElement dropdown;
    public Login(WebDriver driver){

        this.driver=driver;

    }
    public void varifyRadioButton(){
        radiobutton.click();

    }
    public void varifydropdown(){


        Select select=new Select(dropdown);
        select.selectByIndex(2);

    }
    public void varifymultipleselection(){
        Select select=new Select(dropdown);
        select.selectByIndex(2);

    }


}
