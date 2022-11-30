package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{




    HomePage homePage = new HomePage();//Object of HomePage to call method from this Page
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();//Object of registration result to call method from this Page
    NopCommerceNewReleasePage nopCommerceNewReleasePage = new NopCommerceNewReleasePage(); //Object of nopCommerceNewRelease Page to call method from this Page
    FacebookPage facebookPage = new FacebookPage(); //Object of facebook Page to call method from this Page
    AppleMacbookPro13 appleMacbookPro13 = new AppleMacbookPro13();
    ProductEmailAFriendPage productEmailAFriendPage = new ProductEmailAFriendPage();

    @Test
    public static void test()
    {
        System.out.println("TEST");

    }

    @Test  //Annotation

    public void userShouldAbleToRegisterSuccessfullyUsingValidCredentials() {


        //Method called from homepage to verify presence of register button using object
        homePage.verifyPresenceOfRegisterButtonOnHomePage();
        //Method called from homepage to click on Register Button using object
        homePage.clickOnRegisterButton();
        ////Method called from Registration page to verify user is on registration page using object
        registrationPage.verifyUserIsOnRegistrationPage();
        //Method called from Registration page to verify user is on registration page using object
        registrationPage.enterRegistrationDetails();
        //Method called from registration page using object
        registrationPage.clickOnRegisterButtonAfterRegistrationDetailIsEntered();
        //Method called from registration result page using object
        registrationResultPage.verifyMessageDisplayedAfterSuccessfulRegistration();
        //Method called from registration result page to click on continue after registration successful message displayed and verified
        registrationResultPage.clickOnContinueButtonOnceSuccessfulRegistrationMessageIsVerified();

    }



    @Test   //Annotation TestNG
    public void verifyCorrectCurrencyDisplayedForAllProductOnHomePage ()
    {
        //method CALLED from home page to test $ symbol in the prices of each product listed on home page
        homePage.verifyUSDSymbolDisplayedForAllProductsOnHomePage();

        System.out.println("______________________________________");   //Print statement to differentiate currency in the console

        //method called from home page to test euro symbol in the prices of each product listed on home page
        homePage.verifyEURSymbolDisplayedForAllProductsOnHomePage();
    }


    @Test  //Annotation TestNG
    public void verifyAlertAcceptanceAfterClickOnVoteButtonWithoutSelectingFeedback()
    {
        //method CALLED from home page to test vote button should not work without selecting feedback and handle alert
        homePage.clickOnVoteButtonOnHomePageAndHandleAlert();
    }


    @Test  //Annotation TestNG

    public void verifyNewsCommentAddedSuccessfullyInNopCommerceNewRelease()
    {
        //method called from home page to test news comment added successfully and in the last part of the comment box
        homePage.clickDetailsButtonOfNopCommerceNewReleaseNews();

        //Method called from NopCommerce New Release Page to validate that user is on this page
        nopCommerceNewReleasePage.verifyUserIsOnNopCommerceNewReleasePage();

        //Method called from NopCommerce New Release Page to enter comment and verify comment is added successfully and in the last
        nopCommerceNewReleasePage.enterYourCommentAfterClickOnDetailButtonOfNopCommerceNewReleaseNews();
    }

    @Test  //Annotation TestNG
    public void verifyUserShouldAbleToNavigateToFacebookPageFromHomePage()
    {
        //method called from home page to test user is able to accept alert on facebook page
        homePage.clickOnFacebookButtonOnHomePage();
        //Method called from Facebook page using object to verify user is on facebook page and user is able to do action on facebook page (child page)
        facebookPage.verifyUserIsOnNopCommerceFacebookPage();
    }


    @Test  //Annotation TestNG

    public void verifyRegisteredUserShouldAbleToEmailAFriendForAppleMacbookProductOnHomePage ()
    {

        userShouldAbleToRegisterSuccessfullyUsingValidCredentials();

        homePage.clickOnAppleMacbookProductDisplayedOnHomePage();

        appleMacbookPro13.verifyUserIsOnAppleMacBookProPage();

        appleMacbookPro13.clickOnEmailAFriendButtonOnAppleMacBookPage();

        productEmailAFriendPage.verifyUserIsOnProductEmailAFriendPage();

        productEmailAFriendPage.verifyUserIsAbleToSendEmailAFriendForAppleMacBookPro();

    }
    @Test
    public void userShouldAbleToHoverOverOnDesiredCategoryOrSubCategoryToFindTextOrBackgroundColorBeforeAndAfterHover()
    {
        //Method called from homepage to verify text colour of category "Computers"
        homePage.hoverOverAndNavigateToDesiredCategoryPageAndVerifyFontColor("Computers","Desktops");
        System.out.println("_______________");
        //Method called from homepage to verify background colour of subcategory "Desktop"
        homePage.hoverOverAndNavigateToDesktopSubcategoryToVerifyBackgroundColour();

    }


    @Test

    public void VerifySearchFunctionalityOnHomePageIsWorkingAsExpected (){

        //Method called from homepage to verify search function is able to search items
        homePage.verifySearchFunctionalityOnHomePage("Nike");

        System.out.println("-------------------------------------------");

        // //Method called from homepage to verify search function is able to search items
        homePage.verifySearchFunctionalityOnHomePage("adidas");
    }









}
