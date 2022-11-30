package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class DriverManager extends Utils {


    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    String browserName = LoadProp.getProperty("browser");
    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("cloud"));   //System.getProperty also work but we need to change manually from project structure using -D
    MutableCapabilities capabilities = new MutableCapabilities();




    public void openBrowser() {

        if (runIncloud)  ///////////////////////////////   CLOUD ///////////////////////////////////////////////////////
        {
            System.out.println("Running in the cloud");
            if (browserName.equalsIgnoreCase("Edge")) {
                //connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);


            } else if (browserName.equalsIgnoreCase("Firefox")) {//connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);


            } else if (browserName.equalsIgnoreCase("Chrome")) {
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);


            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);


            }try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


        } else///////////////////////////////////////////     LOCAL      ///////////////////////////////////////////////////////////
        {
            System.out.println("Running locally");

            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");  // //method sets the system property indicated by the specified key.
                driver = new ChromeDriver(); //object driver for chromedriver - through typecasting


            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();


            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();


            } else {
                System.out.println("Your browser name is wrong or missing implementation" + browserName);
            }
        }

        //Command to maximise the window
        driver.manage().window().maximize();

        //command to open URL
        //waitForURLtoBe("https://demo.nopcommerce.com/", 5);
        driver.get(LoadProp.getProperty("url"));
    }

    public void closeBrowser() {
        //command to open URL
        //driver.close();
        driver.quit();
    }

}
