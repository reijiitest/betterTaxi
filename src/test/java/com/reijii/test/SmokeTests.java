package com.reijii.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTests{

    private final TestSteps testSteps = new TestSteps();

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        testSteps.goDriver();
    }

    @Test(description = "Go to bettertaxi.com")
    public void openStartPageTest(){
        testSteps.openHomePage().checkIfOnHomePage();
    }

    @Test(description = "Register new customer")
    public void registerNewUserTest(){
        testSteps.openHomePage().openRegistrationPage().fillInRegistrationCredentialsAndSubmit().checkIfOnCustomerRegFinalPage();
    }

    @Test(description = "Login customer with given credentials")
    public void loginRegisteredUserTest(){
        testSteps.openHomePage().openLoginPage().fillInLoginCredentialsAndSubmit().checkIfInUserCabinet();
    }

    @Test(description = "Check Fixed Pricing for Transfer (without logging in)")
    public void checkPricesNoLoginTest(){
        testSteps.openHomePage().fillInPriceCalculatorAndSubmit().checkIfOnSearchResultsPage();
    }

    @Test(description = "Check Fixed Pricing for Transfer (with logging in)")
    public void checkPricesLoginTest(){
        testSteps.openHomePage().openLoginPage().fillInLoginCredentialsAndSubmit().proceedToPrivateBookingPage().fillInPrivateTransferFormAndSubmit().checkIfOnPrivateSearchResultPage();
    }

    @Test(description = "Check price of some taxi in Berlin (without logging in)")
    public void checkBerlinTaxiPrice(){
        testSteps.openHomePage().openBerlinTaxiPortalPage().fillInBerlinTaxiPortalFormAndSubmit().checkIfOnBerlinSearchResultPage();
    }

    @AfterMethod(alwaysRun = true)
    public void KillBrowser(){
        testSteps.outDriver();
    }

}
