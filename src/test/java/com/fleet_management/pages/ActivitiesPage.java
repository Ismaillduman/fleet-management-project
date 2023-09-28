package com.fleet_management.pages;

import com.fleet_management.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ActivitiesPage {
    public ActivitiesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='recurrence-subview-control__number'])[1]")
    public WebElement repeat_every;

    @FindBy(css = ".btn.btn-success.action-button")
    public WebElement save_and_close_button;
    @FindBy(css = ".btn.main-group.btn-primary.pull-right ")
    public WebElement create_calender_event;

    @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement checkbox_repeat;
    @FindBy(xpath = "//span[text()='The value have not to be more than 99.']")
    public WebElement repeat_error_message;

    @FindBy(xpath = "//div[contains(text(),'You do not have permission')]")
    public WebElement error_message;

    @FindBy(xpath = "(//button[@class='close'])[3]")
    public WebElement close_message;



}
