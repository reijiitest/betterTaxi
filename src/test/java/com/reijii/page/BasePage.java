package com.reijii.page;

import com.reijii.test.TestSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends TestSteps {

    public BasePage(WebDriver driver) {
        super(driver);
    }



    protected BasePage clickTo(String xPath){
        WebElement clicker = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions
                    .elementToBeClickable(By.xpath(xPath)));
        clicker.click();
        return this;
    }

    protected BasePage clickToHidden(String xPath) {
        driver.findElement(By.id(xPath)).click();
        return this;
    }

    protected BasePage hoverTo(String Path1, String Path2){
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath(Path1))).build().perform();
        hover.moveToElement(driver.findElement(By.xpath(Path2))).build().perform();
        hover.click();
        return this;
    }

    protected BasePage fillIn(String fieldPath, String text){
        WebElement typer = driver.findElement(By.xpath(fieldPath));
        new BasePage(driver).clickTo(fieldPath);
        typer.sendKeys(text);
        return this;
    }

}



