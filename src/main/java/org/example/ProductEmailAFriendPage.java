package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ProductEmailAFriendPage extends Utils
{

    private By _friendEmailField =By.id("FriendEmail");
    private By _yourEmailField = By.id("YourEmailAddress");
    private By _sendEmailButton= By.name("send-email");
    private By _resultMessageAfterEmailAFriend= By.className("result");

    public void verifyUserIsOnProductEmailAFriendPage()
    {
        //Assert boolean condition to verify user is on registration page
        Assert.assertTrue(driver.getCurrentUrl().contains("productemailafriend"), "User is not on Product Email A Friend Page");
    }


    public void verifyUserIsAbleToSendEmailAFriendForAppleMacBookPro()
    {

        //Enter email address of Friend
        typeText(_friendEmailField, "db" + getTimeStamp() + "@gmail.com");

        //Enter your email address. Copy from registration functionality
        typeText(_yourEmailField, "");

        //Click on button to send email to a friend
        clickOnElement(_sendEmailButton);

        //Capture the message after sending an email to friend store in the String X
        String x = getTextFromElement(_resultMessageAfterEmailAFriend);

        //message on screen after sending an email to a friend
        System.out.println("Message on screen after sending an email to a friend: " + x);

        //Assert to verify message displayed after sending email to friend is as expected
        Assert.assertEquals(x, LoadProp.getProperty("textAfterSendingEmailAFriendForProduct"), "Your message not sent to a friend");
    }


}













