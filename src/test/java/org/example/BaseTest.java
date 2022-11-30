package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{

    DriverManager driverManager = new DriverManager();




    @BeforeMethod    //Annotation
    public void setUp()
    {
        //call open Browser method through object
        driverManager.openBrowser();
    }





    @AfterMethod   //Annotation
    public void tearDown(ITestResult result)
    {   //To capture the screenshot for failed test case
        if(!result.isSuccess())
        {
            captureScreenShot(result.getName());
        }

        //call close browser method through object
        driverManager.closeBrowser();
    }


}
