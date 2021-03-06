package com.jenkins;

import com.jenkins.selenium.SeleniumConfig;
import com.jenkins.selenium.WaitForAjaxCalls;
import com.jenkins.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jenkins.CucumberHooks.getContext;
import static com.jenkins.CucumberHooks.getDriver;

/**
 * This is the main class for page objects
 */
public abstract class BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    /**
     * checks is page opened
     */
    public abstract void isPageOpened();

    /**
     * This constructor is just for the internal Cucumber use as on first call of a step from any page
     * object. Use constructor with boolean parameter
     */
    public BasePage() {
        String pageName = this.getClass().getSimpleName();
        getContext().setPageName(pageName);
        LOG.debug("open {}", pageName);
        waitForOpen();
    }

    /**
     * Waiting for page opening
     */
    protected void waitForOpen() {
        LOG.info("{} page loading started", this.getClass().getSimpleName());
        long currentTime = System.currentTimeMillis();
        new WaitForAjaxCalls(getDriver()).checkPendingRequests();
        try {
            isPageOpened();
        } catch (WebDriverException e) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " page was not opened!", e.getCause());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info(String.format("%s page loaded in %.1f s on %s url",
                this.getClass().getSimpleName(),
                (float) (System.currentTimeMillis() - currentTime) / 1000,
                getDriver().getCurrentUrl()));
    }
}
