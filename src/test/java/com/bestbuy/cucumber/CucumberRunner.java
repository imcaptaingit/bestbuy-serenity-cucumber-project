package com.bestbuy.cucumber;

import com.bestbuy.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Author - Sarvat Shaikh
 * Project Name: bestbuy-serenity-cucumber-project
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/")


public class CucumberRunner extends TestBase {
}
