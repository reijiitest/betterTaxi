package com.reijii.page;

import org.openqa.selenium.WebDriver;

public class UserBookingPage extends BasePage {

    private final String fieldFrom = "//input[@id='start_search_inp']";
    private final String fieldTo = "//input[@id='ziel_search_inp']";
    private final String buttonDatePicker = "//input[@id='transfertag']";
    private final String buttonCalendar31 = "//*[@href='#' and contains(text(),'31')]";
    private final String buttonSearchFixedPrices = "//*[contains(text(),'Search fixed prices »')]";

    private final String destinationOfDeparture = testDataReader(7);
    private final String destinationOfArrival = testDataReader(8);

    public UserBookingPage(WebDriver driver) {
        super(driver);
    }

    public UserBookingPage fillPickedUpField(){
        new BasePage(driver).fillIn(fieldFrom, destinationOfDeparture);
        return this;
    }

    public UserBookingPage fillDroppedOffField(){
        new BasePage(driver).fillIn(fieldTo, destinationOfArrival);
        return this;
    }

    public UserBookingPage pickDate(){
        new BasePage(driver).clickTo(buttonDatePicker).clickTo(buttonCalendar31);
        return this;
    }

    public UserBookingPage clickSubmitButton(){
        new BasePage(driver).clickTo(buttonSearchFixedPrices);
        return this;
    }

}
