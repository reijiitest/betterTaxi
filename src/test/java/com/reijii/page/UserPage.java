package com.reijii.page;

import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

    private final String buttonBookTransfer = "//*[contains(text(),'Book a transfer')]";

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void clickBookTransferButton(){
        new BasePage(driver).clickTo(buttonBookTransfer);
    }

}
