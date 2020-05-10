package com.jenkins.pageObjects;

import com.jenkins.BasePage;
import com.jenkins.CucumberHooks;
import io.cucumber.java.en.When;

import static com.jenkins.CucumberHooks.getDriver;


public class GeneralSteps {
    @When("I open Job Search Page")
    public JobSearch iOpenJobSearchPage() {
        String baseUrl = "https://www.indeed.com/";
        getDriver().get(baseUrl);
        return new JobSearch();


    }
}