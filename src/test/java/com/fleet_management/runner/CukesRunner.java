package com.fleet_management.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/fleet_management/step_definitions",
        dryRun = false, //to check that all the snipes are implemented or not. if dryRun is true--> Without open browser
        tags = "@smoke"

)

public class CukesRunner {
}
