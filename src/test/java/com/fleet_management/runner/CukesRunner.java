package com.fleet_management.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {

                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/fleet_management/step_definitions",
        dryRun = false, //to check that all the snipes are implemented or not. if dryRun is true--> Without open browser
        tags = "@wip"

)

public class CukesRunner {

}
