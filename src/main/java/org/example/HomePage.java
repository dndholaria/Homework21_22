package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage extends Utils
{
    private By _registerButtonOnHomePage = By.className("ico-register"); // variable of locator for register button on home page
    private By _currencySymbol$ = By.id("customerCurrency"); // variable of locator for $ on home page
    private By _productsPriceOnHomePage = By.xpath("//span[@class=\"price actual-price\"]"); // variable of locator for product price of items on home page
    private By _currencySymbolEuro = By.xpath("//select[@id=\"customerCurrency\"]/option[2]"); // variable of locator for Euro currency on home page
    private By _voteButtonOnHomepage = By.id("vote-poll-1");  // variable of locator for vote button on home page
    private By _detailsButtonOfNopCommerceNewReleaseNews = By.xpath("//div[@class=\"news-list-homepage\"]/div[2]/div[2]/div[3]/a");
    private By _facebookButtonOnHomePage = By.linkText("Facebook"); // Locator of facebook button on home page
    private By _linkTextOfAppleMacBookProOnHomePage = By.linkText("Apple MacBook Pro 13-inch");
    private By _searchFieldOnHomePage = By.name("q"); // Locator for search field on home page
    private By _searchButtonOnHomePage = By.xpath("//form[@id=\"small-search-box-form\"]/button");

    private By _productTitleOfSearchedItems = By.className("product-title");

    public void verifyPresenceOfRegisterButtonOnHomePage()
    {
        //Assert to check boolean condition
        Assert.assertEquals(getTextFromElement(_registerButtonOnHomePage), LoadProp.getProperty("textOfRegisterButtonHomePage"), "Registered button is not present on home page");
    }


    public void clickOnRegisterButton()
    {
        //Reusable method used to locate register button along with explicit wait 10 seconds
        waitForElementToBeClickable(_registerButtonOnHomePage, 10);

        //Reusable method used to click register button
        clickOnElement(_registerButtonOnHomePage);
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void verifyUSDSymbolDisplayedForAllProductsOnHomePage()
    {
        //Command to locate and get $ currency
        Select select = new Select(driver.findElement(_currencySymbol$));
        select.getFirstSelectedOption();

        //Array List for List of product prices
        List<WebElement> listProductsPrices = driver.findElements(_productsPriceOnHomePage);

        //For each loop to prices of products
        for (WebElement productsPrices : listProductsPrices) {
        System.out.println(productsPrices.getText());

        //Assert to find $ symbol in product prices
        Assert.assertTrue(productsPrices.getText().contains("$"), "Product price do not contain $ symbol" + productsPrices.getText());
        }
    }




    public void verifyEURSymbolDisplayedForAllProductsOnHomePage()
    {

        //Command to locate and get Euro currency
        clickOnElement(_currencySymbolEuro);

        //Array List for List of product prices
        List<WebElement> listProductsPrices = driver.findElements(_productsPriceOnHomePage);

        //For each loop to prices of products
        for (WebElement productsPrices : listProductsPrices) {
        System.out.println(productsPrices.getText());

        //Assert to find € symbol in product prices
        Assert.assertTrue(productsPrices.getText().contains("€"), "Product price do not contain € symbol" + productsPrices.getText());

        }
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void clickOnVoteButtonOnHomePageAndHandleAlert()
    {
        //Command to click on vote button
        clickOnElement(_voteButtonOnHomepage);

        //Command to handle Alert
        Alert alertMessage = driver.switchTo().alert();

        //Displayed alert message when user clicked vote button without selecting answer
        System.out.printf("Displayed alert message when user clicked vote button without selecting answer is: " + alertMessage.getText());

        //Assert to test displayed message is as expected
        Assert.assertEquals(alertMessage.getText(), LoadProp.getProperty("textIfVoteButtonOnHomePageClickedWithoutFeedback"), "Displayed message is wrong");

        //Acceptance of Alert using accept command
        alertMessage.accept();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void clickDetailsButtonOfNopCommerceNewReleaseNews()
    {
        //command to go to DETAILS and click
        clickOnElement(_detailsButtonOfNopCommerceNewReleaseNews);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void clickOnFacebookButtonOnHomePage()
    {
        //command to locate facebook button and click
        clickOnElement(_facebookButtonOnHomePage);

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void clickOnAppleMacbookProductDisplayedOnHomePage() {
        //Command to click on Apple MacBook Pro 13-inch product displayed on home page
        clickOnElement(_linkTextOfAppleMacBookProOnHomePage);
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void hoverOverAndNavigateToDesiredCategoryPageAndVerifyFontColor(String category, String subCategory)

    {   //Find common locator of category and stored in variable categoryLink *Parameterised X Path*
        WebElement categoryLink = driver.findElement(By.xpath("//ul[contains(@class,\"notmobile\")]//a[contains(.,'"+category+"')]"));

        //check text colour of category before hover
        String beforeHover = categoryLink.getCssValue("color");
        System.out.println("Colour for category before hover: " +beforeHover);

        //Action class created
        Actions builder = new Actions(driver);
        //build
        Action mouseOverCategory = builder.moveToElement(categoryLink).build();
        //Perform
        mouseOverCategory.perform();

        //check text colour of category after hover action
        String afterHover = categoryLink.getCssValue("color");
        System.out.println("Colour for category before hover: " +afterHover);

        clickOnElement(By.linkText(subCategory));

    }

    public void hoverOverAndNavigateToDesktopSubcategoryToVerifyBackgroundColour() {

             //Action class created
             Actions builder = new Actions(driver);

             //Locator of category computer and desktop stored as a variable
             WebElement computer = driver.findElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a"));
             WebElement desktop = driver.findElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/ul[1]/li[1]/a"));

             //Build
             builder.moveToElement(computer).moveToElement(desktop).build();

             //check background colour of desktop subcategory before hover action and print css value
             String beforeHover = desktop.getCssValue("background-color");
             System.out.println("background Colour of desktop before hover is: " + beforeHover);

             //Perform
            builder.moveToElement(computer).moveToElement(desktop).build().perform();

            //check background colour of desktop subcategory after hover action and print css value
            String afterHover = desktop.getCssValue("background-color");
            System.out.println("background Colour of desktop after hover is: " + afterHover);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Test
    public void verifySearchFunctionalityOnHomePage(String searchName)
    {
    //Find locator for search field and type name
    typeText(_searchFieldOnHomePage,searchName);

    //Click on search button on home page
    clickOnElement(_searchButtonOnHomePage);

    //Array list of web elements
    List<WebElement> productTitle = driver.findElements(_productTitleOfSearchedItems);

    //Size of the Array list
    System.out.println("Number of products match with search "+searchName +"=" +productTitle.size());

    //Count number of products match search criteria using following condition
    int count = 0;

        for (WebElement productNames :productTitle)

        {
            System.out.println(productNames.getText());
        }

        for (WebElement productNames :productTitle)

        {
            if (productNames.getText().contains(searchName)) {
                count++;
            } else {
                System.out.println("Some product do not meet search criteria");
            }
        }
        //Assert to match the counts
        Assert.assertEquals(count,productTitle.size(),"One or more products do not meet searched criteria");


    }































    }
