package com.reijii.test;

import com.reijii.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestSteps {

    public WebDriver driver;
    protected String HOMEURL = testDataReader(3);
    protected final int TIMEOUT = 5;

    public TestSteps(WebDriver driver) {
        this.driver = driver;
    }

    public TestSteps() {

    }

    protected void goDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected void outDriver() {
        driver.quit();
        driver = null;
    }


    protected final String testDataReader(int n) {
        String dataGet = null;
        try {
            dataGet = Files.readAllLines(Paths.get("src\\test\\resources\\testData.txt")).get(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataGet;
        //  n:
//  0 - email/username;
//  1 - password;
//  3 - homepage;
//  4 - loginpage;
//  5 - usercabinet;
//  7 - from(world)
//  8 - to(world)
//  10 - from(Berlin)
//  11 - to(Berlin)
//  13 - fixedPricingPage
    }

    protected final String randomNameGenerator = DateTimeFormatter.ofPattern("HHmmss").format(LocalTime.now());


    protected TestSteps openHomePage() {
        new HomePage(driver).goToHomePage();
        return this;
    }

    protected TestSteps openLoginPage() {
        new HomePage(driver).clickLoginButton();
        return this;
    }

    protected TestSteps openRegistrationPage() {
        new HomePage(driver).clickPrivateTravelButton();
        new LoginPage(driver).goToRegistration();
        return this;
    }

    protected TestSteps openBerlinTaxiPortalPage() {
        new HomePage(driver).clickTaxiBerlinButton();
        return this;
    }

    protected TestSteps fillInLoginCredentialsAndSubmit() {
        new LoginPage(driver).fillUsername().fillPassword().submitLogin();

        return this;
    }

    protected TestSteps fillInRegistrationCredentialsAndSubmit() {
        new RegistrationPage(driver).fillCredentialsAndSubmit();
        return this;
    }

    protected TestSteps fillInPriceCalculatorAndSubmit() {
        new HomePage(driver).fillFromField().fillToField().selectDate().selectPassengersNumber().clickCalculatePriceButton();
        return this;
    }

    protected TestSteps fillInBerlinTaxiPortalFormAndSubmit() {
        new BerlinTaxiPortalPage(driver).fillFromField().fillToField().selectDate().selectPassengersNumber().clickCalculatePriceButton();
        return this;
    }

    protected TestSteps proceedToPrivateBookingPage() {
        new UserPage(driver).clickBookTransferButton();
        return this;
    }

    protected TestSteps fillInPrivateTransferFormAndSubmit() {
        new UserBookingPage(driver).fillPickedUpField().fillDroppedOffField().pickDate().clickSubmitButton();
        return this;
    }

    //CHECKS:

    protected void checkIfOnHomePage() {
        Assert.assertEquals(testDataReader(3), String.valueOf(driver.getCurrentUrl()));
        System.out.println("We are able to navigate to BetterTaxi!");
        System.out.println("Start Page URL is:  " + (driver.getCurrentUrl()));
    }

    protected void checkIfInUserCabinet() {
        Assert.assertEquals(testDataReader(5), String.valueOf(driver.getCurrentUrl()));
        System.out.println("Tester User is logged in!");
        System.out.println("User Page URL is:  " + (driver.getCurrentUrl()));
    }

    protected void checkIfOnSearchResultsPage() {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']")));
        Assert.assertTrue(String.valueOf(driver.findElement(By.xpath("//div[@class='title']")).getText()).contains("Search Results"));
        System.out.println("Anonymous User is able to check prices!");
        System.out.println("We are on Fixed Prices " + driver.findElement(By.xpath("//div[@class='title']")).getText() + " page");
    }

    protected void checkIfOnCustomerRegFinalPage() {
        Assert.assertTrue(driver.getTitle().contains("Customer Registration | World Transfer"));
        System.out.println("New User with random eMail registered!");
        System.out.println("We are on " + driver.getTitle() + " page");
        System.out.println("Username: random" + randomNameGenerator + "@mail.ru");
        System.out.println("Password: pass1212");
    }

    protected void checkIfOnPrivateSearchResultPage() {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']")));
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user']")));
        Assert.assertTrue(String.valueOf(driver.findElement(By.xpath("//div[@class='user']")).getText()).contains("John Cena"));
        System.out.println("Tester User is logged in and able to check prices!");
        System.out.println("We are on Fixed Prices " + driver.findElement(By.xpath("//div[@class='title']")).getText() + " page");
        System.out.println("Customer is " + driver.findElement(By.xpath("//div[@class='user']")).getText());
    }

    protected void checkIfOnBerlinSearchResultPage() {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title']")));
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='widget-content widget-info']")));
        Assert.assertTrue(String.valueOf(driver.findElement(By.xpath("//div[@class='widget-content widget-info']")).getText()).contains("Berlin"));
        System.out.println("Anonymous User is able to check prices in Berlin!");
        System.out.println("We are on Berlin Portal " + driver.findElement(By.xpath("//div[@class='title']")).getText() + " page");
    }
}
