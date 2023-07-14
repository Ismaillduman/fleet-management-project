package com.fleetManagement.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void  sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify(
            String expectedInUrl, String expectedTitle){

        Set<String> windowsHandel = Driver.getDriver().getWindowHandles();
        for (String eachWindow : windowsHandel) {
            Driver.getDriver().switchTo().window(eachWindow);
            if ( Driver.getDriver().getCurrentUrl().contains(expectedTitle)) {
                break;
            }
        }

        String actualTitle =  Driver.getDriver().getTitle();
        //verifyTitleContains(expectedTitle, actualTitle);
        System.out.println("actualTitle = " + actualTitle);
        String currentUrl= Driver.getDriver().getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //Assert.assertTrue(actualTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
        Assert.assertTrue(currentUrl.contains(expectedInUrl));
    }

    /*TC #3: Create utility method
1. Create a new method for title verification
2. Create a method to make title verification logic re-usable
3. When method is called, it should simply verify expected title with actual
title
Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle*/

    public static void verifyTitleContains(String expectedTitle){
        String currentTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(currentTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
    }
    public static void verifyTitle(String expectedTitle){
        String currentTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,currentTitle);
    }

    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title){
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void scrollDown(int pixels){
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0,"+ pixels +")");
    }

    public static List<String> dropdown_options_as_string(WebElement dropDownElement){
        Select month= new Select(dropDownElement);
        List<WebElement> actual_months= month.getOptions();

        List<String> actual_months_as_string= new ArrayList<>();
        for (WebElement each_month_element : actual_months) {
            actual_months_as_string.add(each_month_element.getText());
        }
        return  actual_months_as_string;
    }
}
