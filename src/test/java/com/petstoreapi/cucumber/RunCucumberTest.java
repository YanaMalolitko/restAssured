package com.petstoreapi.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Yana on 9/18/2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},features = {"C:\\Users\\Yana\\IdeaProjects\\www\\restAssureed\\src\\test\\resources\\PerStore.feature"} )
public class RunCucumberTest {


}
