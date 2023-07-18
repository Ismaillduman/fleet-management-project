package com.fleet_management.step_definitions;

import com.fleet_management.pages.AccountPage;
import com.fleet_management.pages.BasePage;
import com.fleet_management.pages.LoginPage;
import com.fleet_management.utilities.BrowserUtilities;
import com.fleet_management.utilities.ConfigurationReader;
import com.fleet_management.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class AccountsStepDefinitions extends BasePage {
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();


    @Given("The user is on the DashboardPage")
    public void the_user_is_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("fleetUrl"));
        loginPage.login_as_sales_manager();
    }

    @When("User hovers mouse over {string} tab and click {string} module")
    public void user_hovers_mouse_over_module_and_click_on_the_submenu(String tab, String module) {
        navigateToModule(tab, module);

    }

    @And("User go to the {string}")
    public void userGoToThe(String title) {
        BrowserUtilities.waitForTitleContains(title);
        BrowserUtilities.verifyTitle(title);
    }

    @Then("User should be able to see  below eight filter items on the Accounts page")
    public void user_should_be_able_to_see_below_filter_eight_items_on_the_accounts_page(List<String> expectedFilters) {

        accountPage.filterIcon.click();

       List<String >actualFilter= BrowserUtilities.getElementsText(accountPage.filters);

       Assert.assertEquals(expectedFilters,actualFilter);

//        accountPage.manageFilter.click();
//
//        List<String> actualFilterHeaders = new ArrayList<>();
//        for (WebElement eachFilterHeader : accountPage.filterHeaders) {
//            actualFilterHeaders.add(eachFilterHeader.getText());
//        }
//        System.out.println(actualFilterHeaders);
//        Assert.assertEquals(expectedFilters, actualFilterHeaders);
    }


}
