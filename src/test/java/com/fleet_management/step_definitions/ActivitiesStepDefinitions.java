package com.fleet_management.step_definitions;

import com.fleet_management.pages.ActivitiesPage;
import com.fleet_management.pages.LoginPage;
import com.fleet_management.utilities.BrowserUtilities;
import com.fleet_management.utilities.ConfigurationReader;
import com.fleet_management.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivitiesStepDefinitions {
    ActivitiesPage activities = new ActivitiesPage();
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @When("User click the Create Calender Event button")
    public void user_click_the_create_calender_event_button() {
        activities.create_calender_event.click();

    }

    @When("user navigate to Create Calender Event Page")
    public void user_navigate_to_create_calender_event_page() {

        BrowserUtilities.waitForTitleContains("Create Calendar event");
        BrowserUtilities.verifyTitle("Create Calendar event - Calendar Events - Activities");

    }

    @When("user check the repeat check box")
    public void user_check_the_repeat_check_box() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", activities.checkbox_repeat);
    }

    @When("User enter the invalid data in repeat every box")
    public void user_enter_the_invalid_data_in_repeat_every_box() {
        wait.until(ExpectedConditions.visibilityOf(activities.repeat_every));
        activities.repeat_every.sendKeys("100");
    }

    @When("user click the save and close button")
    public void user_click_the_save_and_close_button() {
        activities.save_and_close_button.click();
    }

    @Then("User should be able to see error message")
    public void user_should_be_able_to_see_error_message() {
        BrowserUtilities.verifyElementDisplayed(activities.repeat_error_message);
    }

    @Given("The user is on the DashboardPages")
    public void the_user_is_on_the_dashboard_pages() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fleetUrl"));
        loginPage.login_as_driver();
    }

    @Then("User see error message")
    public void user_see_error_message() {
        wait.until(ExpectedConditions.elementToBeClickable(activities.close_message));
        String actualErrorMessage = activities.error_message.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        String expectedErrorMessage = "You do not have permission to perform this action.";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage );
    }
}
