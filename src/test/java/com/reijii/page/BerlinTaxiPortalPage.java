package com.reijii.page;

import org.openqa.selenium.WebDriver;

public class BerlinTaxiPortalPage extends BasePage{

    private final String fieldFrom = "//input[@id='from']";
    private final String fieldTo = "//input[@id='to']";
    private final String buttonCalculatePrice = "//input[@id='jetz_taxi']";
    private final String buttonCalendarOpen = "//span[@id='departure_h3']";
    private final String buttonCalendar31 = "//*[@href='#' and contains(text(),'31')]";
    private final String buttonCalendarClose = "//span[@class='close_datetime']";
    private final String buttonPassengersDropDown = "//select[@id='passenger_options']";
    private final String buttonPassengers2 = "//select[@id='passenger_options']";

    private final String destinationOfDeparture = testDataReader(10);
    private final String destinationOfArrival = testDataReader(11);

    public BerlinTaxiPortalPage(WebDriver driver) {
        super(driver);
    }

    public BerlinTaxiPortalPage fillFromField(){
        new BasePage(driver).fillIn(fieldFrom, destinationOfDeparture);
        return this;
    }

    public BerlinTaxiPortalPage fillToField(){
        new BasePage(driver).fillIn(fieldTo, destinationOfArrival);
        return this;
    }

    public BerlinTaxiPortalPage clickCalculatePriceButton(){
        new BasePage(driver).clickTo(buttonCalculatePrice);
        return this;
    }

    public BerlinTaxiPortalPage selectDate(){
        new BasePage(driver).clickTo(buttonCalendarOpen).clickTo(buttonCalendar31).clickTo(buttonCalendarClose);
        return this;
    }

    public BerlinTaxiPortalPage selectPassengersNumber(){
        new BasePage(driver).clickTo(buttonPassengersDropDown).clickTo(buttonPassengers2);
        return this;
    }

}
