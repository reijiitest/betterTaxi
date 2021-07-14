package com.reijii.page;

import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private final String fieldSalutationDropDown = "tmp_profil_anrede";
    private final String buttonSalutationDr = "//li[contains(text(),'Dr.')]";
    private final String fieldFirstName = "//input[@id='profil_vorname']";
    private final String fieldSecondName = "//input[@id='profil_name']";
    private final String fieldCountryCode = "tmp_profil_mobil_vorwahl";
    private final String fieldMobile = "//input[@id='profil_mobil']";
    private final String fieldEmail = "//input[@id='profil_email']";
    private final String fieldEmailConfirm = "//input[@id='confirm_profil_email']";
    private final String buttonAccessData = "//h4[@id='zugangsdaten']";
    private final String fieldPassword = "//input[@id='profil_pass1']";
    private final String fieldPasswordConfirm = "//input[@id='profil_pass2']";
    private final String checkboxPrivacyStatement = "//input[@id='check_datenschutz']";
    private final String buttonNext = "//*[contains(text(),'Next »')]";

    private final String eMail = "random" + randomNameGenerator + "@mail.ru";
    private final String name = testDataReader(15);
    private final String surname = testDataReader(16);
    private final String phoneNumber = testDataReader(17);
    private final String password = testDataReader(18);

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void fillCredentialsAndSubmit() {
        new BasePage(driver).clickToHidden(fieldSalutationDropDown)
                            .clickTo(buttonSalutationDr)
                            .fillIn(fieldFirstName, name)
                            .fillIn(fieldSecondName, surname)
                            .clickToHidden(fieldCountryCode)
                            .fillIn(fieldMobile, phoneNumber)
                            .fillIn(fieldEmail, eMail)
                            .fillIn(fieldEmailConfirm, eMail)
                            .clickTo(buttonAccessData)
                            .fillIn(fieldPassword, password)
                            .fillIn(fieldPasswordConfirm, password)
                            .clickTo(checkboxPrivacyStatement)
                            .clickTo(buttonNext);


    }
}
