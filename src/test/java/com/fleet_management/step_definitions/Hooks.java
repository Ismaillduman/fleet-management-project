package com.fleet_management.step_definitions;

import com.fleet_management.pages.LoginPage;
import com.fleet_management.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    LoginPage loginPage= new LoginPage();

    @Before
    public void setUp(){
//        Driver.getDriver().get("https://qa.fleetgru.com/");
//        loginPage.login_as_sales_manager();
//        loginPage.login_as_store_manager();
    }
    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

}
