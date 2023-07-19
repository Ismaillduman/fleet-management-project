package com.fleet_management.pages;

import com.fleet_management.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivitiesPage {
    public ActivitiesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".recurrence-subview-control__number.error")
    public WebElement repeat_every;

    @FindBy(css = ".btn.btn-success.action-button")
    public WebElement save_and_close_button;
    @FindBy(css = ".btn.main-group.btn-primary.pull-right ")
    public WebElement create_calender_event;

    @FindBy(id = "recurrence-repeat-view3136")
    public WebElement checkbox_repeat;
    @FindBy(xpath = "//span[text()='The value have not to be more than 99.']")
    public WebElement repeat_error_message;
}
