package com.reijii.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String buttonLoginDropDown = "//*[@class='bt_extended_menu_item show-for-large is-dropdown-submenu-parent opens-right']";
    private final String buttonLogin = "//*[@class='button-anmelden']";
    private final String buttonPrivateTravel = "//*[contains(text(),'Private travel')]";
    private final String fieldFrom = "//input[@id='from']";
    private final String fieldTo = "//input[@id='to']";
    private final String buttonCalculatePrice = "//input[@id='jetz_taxi']";
    private final String buttonCalendarOpen = "//span[@id='departure_h3']";
    private final String buttonCalendar31 = "//*[@href='#' and contains(text(),'31')]";
    private final String buttonCalendarClose = "//span[@class='close_datetime']";
    private final String buttonPassengersDropDown = "//select[@id='passenger_options']";
    private final String buttonPassengers2 = "//select[@id='passenger_options']";
    private final String buttonTaxiDropDown = "//a[contains(text(),'Taxi')]";
    private final String buttonBerlin = "//a[@href='/taxi/berlin/' and contains(text(),'Berlin')]";

    private final String destinationOfDeparture = testDataReader(7);
    private final String destinationOfArrival = testDataReader(8);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage(){
        driver.get(HOMEURL);
    }

    public void clickLoginButton(){
        new BasePage(driver).hoverTo(buttonLoginDropDown, buttonLogin).clickTo(buttonLogin);
    }

    public void clickPrivateTravelButton() {
        new BasePage(driver).hoverTo(buttonLoginDropDown, buttonPrivateTravel).clickTo(buttonPrivateTravel);

    }

    public HomePage fillFromField(){
        new BasePage(driver).fillIn(fieldFrom, destinationOfDeparture);
        return this;
    }

    public HomePage fillToField(){
        new BasePage(driver).fillIn(fieldTo, destinationOfArrival);
        return this;
    }

    public HomePage clickCalculatePriceButton(){
        new BasePage(driver).clickTo(buttonCalculatePrice);
        return this;
    }

    public HomePage selectDate(){
        new BasePage(driver).clickTo(buttonCalendarOpen).clickTo(buttonCalendar31).clickTo(buttonCalendarClose);
        return this;
    }

    public HomePage selectPassengersNumber(){
        new BasePage(driver).clickTo(buttonPassengersDropDown).clickTo(buttonPassengers2);
        return this;
    }

    public HomePage clickTaxiBerlinButton() {
        new BasePage(driver).hoverTo(buttonTaxiDropDown, buttonBerlin).clickTo(buttonBerlin);
        return this;
    }
}
