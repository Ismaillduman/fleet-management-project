package com.fleet_management.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {
    private Driver() {
    }

    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver() {

        String browserType = ConfigurationReader.getProperty("browser");
        //String url=ConfigurationReader.getProperty("env");
        if (driverPool.get() == null) {

            switch (browserType) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.167.76.222";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":

                    // WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    // driver.get(url);
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    // WebDriverManager.chromedriver().setup();
                    driverPool.set(new FirefoxDriver());
                    //driver.get(url);
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "headless-chrome":
                    // WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driverPool.set(new ChromeDriver(option));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }


        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();

            //driverPool.set(null);
            driverPool.remove();
        }
    }
}
