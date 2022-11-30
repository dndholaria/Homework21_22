package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage
{

    //REUSABLE METHODS


    public static void clickOnElement(By by) //Reusable method to Click on Web Element
    {
        //Command to find element using locator and selenium will perform click action
        driver.findElement(by).click();
    }



    public static void typeText(By by, String text) //Reusable method to Type
    {
        //command to find element using locator and selenium will perform Type action.
        driver.findElement(by).sendKeys(text);
    }



    public static String getTextFromElement(By by) //Reusable method to get text from web element
    {
        //Command to find element using locator and get text
        return driver.findElement(by).getText();
    }


    public static String getTimeStamp() //Reusable method to get Time Stamp
    {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }



    public static void waitForElementToBeClickable(By by, int timeInSeconds) //Reusable method for explicit wait - wait for an element to be clickable

    {   //Command to wait explicitly until web element found and then click on it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public static void waitForElementToBeVisible(By by, int timeInSeconds) //Reusable method for an element to be visible
    {
        //Command to wait explicitly until web element visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    public static void waitForURLtoBe(String url, int timeInSeconds) // Reusable method for URL to be
    {
        //Command to wait explicitly until URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.urlToBe(url));
    }



    public static void selectFromDropdownByVisibleText(By by, String text) //Reusable method to select web element from drop down by visible text
    {
        //Command to select web element from drop down by visible text
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }



    public static void selectFromDropdownByValue(By by, String text) // Reusable method to select web element from drop down by value
    {
        //Command to select web element from drop down by value
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }



    public static void selectFromDropdownByIndex(By by, int index) //Reusable method to select web element from drop down by index
    {
        //Command to select web element from drop down by index
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }


    public static void captureScreenShot(String screenShotName)
    {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File("src/main/ScreenShots/" +screenShotName+getTimeStamp()+ ".jpg");

        //Handle exception
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
