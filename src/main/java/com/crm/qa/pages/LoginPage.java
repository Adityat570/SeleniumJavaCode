package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR:
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    ///  initializing the page object
    public LoginPage() {
        PageFactory.initElements(driver,this);

    }
    //action

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login (String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }




}
