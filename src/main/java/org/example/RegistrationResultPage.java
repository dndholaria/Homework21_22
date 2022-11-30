package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils
{
    private By _registrationSuccessMessage = By.className("result");
    private By _continueButtonAfterSuccessfulRegMessageDisplayed = By.xpath("//a[@class=\"button-1 register-continue-button\"]");

    public void verifyMessageDisplayedAfterSuccessfulRegistration()
    {
        //Assert to match actual message against expected.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(getTextFromElement(_registrationSuccessMessage),LoadProp.getProperty("expectedMessageAfterRegistration"), "registration message is wrong ");
        //Print message
        String message = getTextFromElement(_registrationSuccessMessage);
        System.out.println("Message after successful registration = " +message);

    }



    public void clickOnContinueButtonOnceSuccessfulRegistrationMessageIsVerified()
    {   //Click on continue button once user verify registration successful message is as expected
        clickOnElement(_continueButtonAfterSuccessfulRegMessageDisplayed);

    }













}
