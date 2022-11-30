package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AppleMacbookPro13 extends Utils {

    private By _EmailAFriendButtonOnAppleMacBookPage = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");


    public void verifyUserIsOnAppleMacBookProPage()
    {
        //Assert boolean condition to verify user is on registration page
        Assert.assertTrue(driver.getCurrentUrl().contains("apple-macbook-pro-13-inch"), "User is not on Apple MacBook Pro page ");
    }


    public void clickOnEmailAFriendButtonOnAppleMacBookPage() {
        //Command to click on email a friend button for Apple MacBook Pro 13-inch product
        clickOnElement(_EmailAFriendButtonOnAppleMacBookPage);
    }


}