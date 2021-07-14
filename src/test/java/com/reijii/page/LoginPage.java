package com.reijii.page;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final String fieldUsername = "//input[@id='inp_username']";
    private final String fieldPassword = "//input[@id='inp_password']";
    private final String buttonSubmitLogin = "//a[@class='greenButton' and @tabindex='3']";
    private final String buttonProceedToRegistration = "//*[contains(text(),'Register »')]";

    private final String testUserName = testDataReader(0);
    private final String testPassword = testDataReader(1);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(){
        new BasePage(driver).fillIn(fieldUsername, testUserName);
        return this;
    }

    public LoginPage fillPassword(){
        new BasePage(driver).fillIn(fieldPassword, testPassword);
        return this;
    }

    public LoginPage submitLogin(){
        new BasePage(driver).clickTo(buttonSubmitLogin);
        return this;
    }

    public LoginPage goToRegistration(){
        new BasePage(driver)
                .clickTo(buttonProceedToRegistration);
        return this;
    }

}
