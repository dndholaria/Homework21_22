package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationPage extends Utils
{

   // protected String  registeredEmailAddress = "abc"+getTimeStamp()+"@gmail.com";
    protected String  registeredEmailAddress = LoadProp.getProperty("emailAddressPart")+getTimeStamp()+LoadProp.getProperty("emailAddressPart2");

    private By _maleGenderField = By.id("gender-male");//Private variable for Male gender radio button
    private By _firstNameField = By.id("FirstName");//Private variable for first name field
    private By _lastNameField = By.id("LastName");//Private variable for last name field
    private By _DateOfBirthDay = By.name("DateOfBirthDay");//Private variable for day of Birthdate
    private By _DateOfBirthMonth = By.name("DateOfBirthMonth");//Private variable for month of Birthdate
    private By _DateOfBirthYear  = By.name("DateOfBirthYear");//Private variable for year of Birthdate
    private By _emailField = By.id("Email");//Private variable for email field
    private By _passwordField = By.id("Password");//Private variable for password field
    private By _confirmPasswordField = By.id("ConfirmPassword");//Private variable for confirm password field
    private By _registerButtonOnRegistrationPage = By.id("register-button");




    public void verifyUserIsOnRegistrationPage()
    {
        //Assert boolean condition to verify user is on registration page
        Assert.assertTrue(driver.getCurrentUrl().contains("register"), "User is not on registration page");
    }




    public void enterRegistrationDetails()
    {
        //Command to locate male radio button and click on it
        clickOnElement(_maleGenderField);
        //Command to locate first name and type DB on registration page
        typeText(_firstNameField,LoadProp.getProperty("firstName"));
        //Command to locate last name and type Patel on registration page
        typeText(_lastNameField, LoadProp.getProperty("lastName"));
        //Command to select day of Birth date
        selectFromDropdownByVisibleText(_DateOfBirthDay,LoadProp.getProperty("dayOfBirthDate"));
        //selectFromDropdownByValue(_DateOfBirthDay,"10");
        //Command to select month of Birth date
        selectFromDropdownByVisibleText(_DateOfBirthMonth, LoadProp.getProperty("monthOfBirthDate"));
        //selectFromDropdownByValue(_DateOfBirthMonth,"2");
        //Command to select year of Birth date
        selectFromDropdownByVisibleText(_DateOfBirthYear, LoadProp.getProperty("yearOfBirthDate"));
        //selectFromDropdownByValue(_DateOfBirthYear,"1920");
        //Command to locate email by id and type email address as per sendKeys on registration page
        typeText(_emailField,registeredEmailAddress);
        //Command to locate password by id and type password as per sendKeys on registration page
        typeText(_passwordField,LoadProp.getProperty("password"));
        //Command to locate confirm password by id and type password as per sendKeys on registration page
        typeText(_confirmPasswordField,LoadProp.getProperty("confirmPassword"));


    }


    public void clickOnRegisterButtonAfterRegistrationDetailIsEntered()
    {
        // command to locate registration button by id locator and click on registration
        clickOnElement(_registerButtonOnRegistrationPage);
    }



}
