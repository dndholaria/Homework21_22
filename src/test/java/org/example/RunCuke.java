package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = "@cat",
        plugin = {"pretty", "html:target/cucumber-reports.html"}, publish = true)

public class RunCuke
{




}
