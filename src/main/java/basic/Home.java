package basic;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Home {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='bmwradio']")
    WebElement radiobutton;

    @FindBy(xpath = "//Select[@id='carselect']")
    WebElement dropdown;
    @FindBy(xpath = "//select[@id='multiple-select-example']")
    WebElement multiDropdown;
    @FindBy(xpath = "//input[@id='hondacheck']")
    WebElement checkbox;
    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement switchWindow;
    @FindBy(linkText = "Open Tab")
    WebElement switchTab;
    @FindBy(xpath = "//input[@name='enter-name']")
    WebElement enterName;
    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alert;
    @FindBy(xpath = "//input[@id='confirmbtn']")
    WebElement confirm;
    @FindBy(xpath = "//input[@id='enabled-button']")
    WebElement enable;
    @FindBy(xpath = "//input[@id='enabled-example-input']")
    WebElement enableField;
    @FindBy(xpath = "//input[@id='hide-textbox']")
    WebElement hidebtn;
    @FindBy(xpath = "//input[@id='show-textbox']")
    WebElement showbtn;
    @FindBy(xpath = "//button[@id='mousehover']")
    WebElement mousehover;
    @FindBy(linkText = "Top")
    WebElement top;
    @FindBy(xpath = "//select[@name='categories']")
    WebElement frame;

    public Home(WebDriver driver){
        this.driver=driver;

    }
    public void verifyRadioButton(){
        radiobutton.click();
    }
    public void verifyDropDown(){
        Select select=new Select(dropdown);
        select.selectByIndex(1);
    }
    public void verifyMultiDropDown(){
        Select select=new Select(multiDropdown);
            select.selectByIndex(0);
            select.selectByIndex(2);
    }
    public void verifyCheckbox(){
        checkbox.click();
    }
    public void verifySwitchWindow(){
        switchWindow.click();
    }
    public void verifySwitchTab(){
        switchTab.click();
    }
    public void verifyEnterName() throws InterruptedException {
        enterName.sendKeys("sssss");
        alert.click();
        Thread.sleep(1000);
        Alert a=driver.switchTo().alert();
        a.accept();
        enterName.sendKeys("sha");
        confirm.click();
        Thread.sleep(1000);
        a.dismiss();
    }
    public void verifyEnableField(){
        enable.click();
        enableField.sendKeys("sssss");
    }
    public void verfyHidebtn() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        hidebtn.click();
        Thread.sleep(1000);
    }
    public void verifyShowbtn(){
        showbtn.click();
    }
    public void verifyMouseHover(){
        Actions action=new Actions(driver);
        action.moveToElement(mousehover).build().perform();
        //top.click();
    }
    public void verifyFrame(){
        driver.switchTo().frame(0);
        Select select=new Select(frame);
        select.selectByIndex(1);
    }



}
