package com.fleet_management.pages;

import com.fleet_management.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {

    public WebDriverWait wait;

    public AccountPage() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".fa-filter.hide-text")
    public WebElement filterIcon;

    @FindBy(css = ".add-filter-button")
    public WebElement manageFilter;
    @FindBy(xpath = "//*[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'][text()]")
    public List<WebElement> filters;
    @FindBy(xpath = "//li/label")
    public List<WebElement> filterHeaders;

    @FindBy(xpath = "(//li/label)[1]")
    public WebElement text;


}
