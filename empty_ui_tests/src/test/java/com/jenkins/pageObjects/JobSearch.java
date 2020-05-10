package com.jenkins.pageObjects;

import com.jenkins.BasePage;
import com.jenkins.CucumberHooks;
import com.jenkins.selenium.WaitForAjaxCalls;
import com.jenkins.utilities.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.jenkins.CucumberHooks.getDriver;

public class JobSearch extends BasePage {
    @Override
    public void isPageOpened() {
        new WaitForAjaxCalls(CucumberHooks.getDriver()).checkPendingRequests();

        Helper.getWait().until(ExpectedConditions.titleContains("Job Search"));


    }

    @And("I click log in link on Job Search page")
    public LogInPage iClickLogInLinkOnJobSearchPage() {

        Helper.click(By.xpath("//span[contains(text(),'Sign in')]"));
        return new LogInPage();
    }

    @Then("^I am signed in as (.*) user on Job Search Page$")
    public void iAmSignedInAsTHISUserOnJobSearchPage(String name) {


        Helper.click(By.xpath("//div[@class=\"gnav-MenuToggle-label gnav-NavIcon\"]"));
        String userName = CucumberHooks.getDriver().findElement(By.className("gnav-AccountMenu-user")).getText();
        Assert.assertEquals(userName, name, "Invalid username");


        // WebElement profile = CucumberHooks.getDriver().findElement(By.className("gnav-MenuToggle-label gnav-NavIcon")).click();
    }
}
