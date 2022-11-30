package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;

public class FacebookPage extends Utils {

    public void verifyUserIsOnNopCommerceFacebookPage() {

        //Exception handling using try catch method
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Handle multiple window
        Set<String> windowHandles = driver.getWindowHandles();
        //Iterator method to handle multiple windows  (Parent window and child window
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        System.out.println("Parent window ID: " + parentWindow);
        String childWindow = iterator.next();
        System.out.println("Child window ID: " + childWindow);
        //command to switch to child window
        driver.switchTo().window(childWindow);
        //Save facebook URL in String variable
        String urlOfFacebookPage = driver.getCurrentUrl();
        //Print statement to print url of facebook page
        System.out.println("URL of current page: " + urlOfFacebookPage);

        //Handle Cookies
        Cookie cobj = new Cookie("Mycookies", "1");
        driver.manage().addCookie(cobj);

        //Exception handling
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Assert to verify user is on facebook page
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"), "user is not on facebook page");

        //Enter email on facebook page [for practice only ]
        typeText(By.name("email"), "abcd@gmail.com");

        //Switch to parent window [for practice only]
        driver.switchTo().window(parentWindow);

    }


}
