package com.jenkins.pageObjects;

import com.jenkins.BasePage;
import com.jenkins.CucumberHooks;
import com.jenkins.selenium.WaitForAjaxCalls;
import com.jenkins.utilities.Helper;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jenkins.utilities.Helper.*;

public class LogInPage extends BasePage {


    @Override
    public void isPageOpened() {
        new WaitForAjaxCalls(CucumberHooks.getDriver()).checkPendingRequests();

        getWait().until(ExpectedConditions.titleIs("Sign In | Indeed Accounts"));
        getWait().until(ExpectedConditions.urlContains("login"));


    }

    @And("^I set (.*) as username on Login page$")
    public void iSetTHISAsUsernameOnLoginPage(String username) {
        typeText(By.id("login-email-input"), (username));
    }

    @And("^I set (.*) as password on Login page$")
    public void iSetTHISAsPasswordOnLoginPage(String password) {
        typeText(By.id("login-password-input"), (password));
    }

    @And("I click Sign in button on Login page")
    public JobSearch iClickSignInButtonOnLoginPage() {
        Helper.click(By.id("login-submit-button"));
        return new JobSearch();
    }
}
