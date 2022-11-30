package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class NopCommerceNewReleasePage extends Utils
{

    private By _titleFieldOfCommentOnNopCommerceNewRelease = By.xpath("//input[@class=\"enter-comment-title\"]");
    private By _commentFieldOfCommentOnNopCommerceNewRelease = By.id("AddNewComment_CommentText");
    private By _newCommentButtonOnNopCommerceNewRelease=By.name("add-comment");

    private By _resultMessageAfterClickOnCommentButtonOnNopCommerceNewRelease = By.className("result");





    public void verifyUserIsOnNopCommerceNewReleasePage()
    {
        //Assert boolean condition to verify user is on registration page
        Assert.assertTrue(driver.getCurrentUrl().contains("nopcommerce-new-release"), "User is not on nopcommerce-new-release page");
    }


    public void enterYourCommentAfterClickOnDetailButtonOfNopCommerceNewReleaseNews()
    {

        //command to find Title using xpath locator and enter title.
        typeText(_titleFieldOfCommentOnNopCommerceNewRelease,"FeedbackMrPatel");

        //command to find comment box using id locator and enter comment
        typeText(_commentFieldOfCommentOnNopCommerceNewRelease,"Very important news");

        //command to click on add comment by name locator and click on it.
        clickOnElement(_newCommentButtonOnNopCommerceNewRelease);

        //find the message appear after successful adding comment and note down the successful message using get text.
        String commentResultMessage = getTextFromElement(_resultMessageAfterClickOnCommentButtonOnNopCommerceNewRelease);

        Assert.assertEquals(commentResultMessage, LoadProp.getProperty("textOfNewsCommentAddedSuccessfully"), "News comment not added successfully");

        //print message
        System.out.println("Message appeared after successful adding comment : " + commentResultMessage);

        System.out.println("-------Assert to verify my comment is added in the last as below-------");

        //Dynamic list , Find LAST div using last() method
        String lastCommentTitle = driver.findElement(By.xpath("//div[@class=\"comments\"]/div[last()]/div[2]/div[2]")).getText();

        //Print title of added comment.
        System.out.println("Comment Title = " + lastCommentTitle);

        //Assert to test that added comment is displayed in the very last part of all comment
        Assert.assertEquals(lastCommentTitle, "FeedbackMrPatel", "Entered comment is not added in the last part of comment list");

    }










}
