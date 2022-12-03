package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs
{

    HomePage homePage = new HomePage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    RegistrationPage registrationPage = new RegistrationPage();

    //Utils utils = new Utils();



    @Given("user is on register page")
    public void user_is_on_register_page() {
        // Write code here that turns the phrase above into concrete actions

        homePage.clickOnRegisterButton();
        registrationPage.verifyUserIsOnRegistrationPage();
    }
    @When("user enter required registration details")
    public void user_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions

        registrationPage.enterRegistrationDetails();
        registrationPage.clickOnRegisterButtonAfterRegistrationDetailIsEntered();

    }
    @Then("user should able to register successfully")
    public void user_should_able_to_register_successfully() {
        // Write code here that turns the phrase above into concrete actions
       registrationResultPage.verifyMessageDisplayedAfterSuccessfulRegistration();
       registrationResultPage.clickOnContinueButtonOnceSuccessfulRegistrationMessageIsVerified();
    }


    @When("I click on {string} link")
    public void iClickOnLink(String categoryLink)
    {
        homePage.clickOnCategory(categoryLink);
    }


    @Then("I should able to navigate to {string} page successfully")
    public void iShouldAbleToNavigateToPageSuccessfully(String categoryName)
    {
    Utils.assertCurrentURL(categoryName);
    }
}
