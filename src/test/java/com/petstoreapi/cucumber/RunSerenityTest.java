package com.petstoreapi.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;

/**
 * Created by Yana on 9/19/2018.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/PerStore.feature")
public class RunSerenityTest {


}
