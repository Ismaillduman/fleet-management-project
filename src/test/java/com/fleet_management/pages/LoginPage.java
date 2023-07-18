package com.fleet_management.pages;

import com.fleet_management.utilities.BrowserUtilities;
import com.fleet_management.utilities.BrowserUtilities;
import com.fleet_management.utilities.ConfigurationReader;
import com.fleet_management.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriverWait wait;
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    @FindBy(id = "prependedInput")
    public WebElement user_name;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login_button;

    public void login_as_sales_manager() {

        user_name.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
        login_button.click();
    }
    public void login_as_store_manager() {

        user_name.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        password.sendKeys(ConfigurationReader.getProperty("store_manager_password"));
        login_button.click();
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        BrowserUtilities.verifyTitle("Dashboard");
    }
}
