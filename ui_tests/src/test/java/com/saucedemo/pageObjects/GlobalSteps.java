package com.saucedemo.pageObjects;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

import static com.saucedemo.CucumberHooks.getDriver;
import static com.saucedemo.TestsConfig.getConfig;

public class GlobalSteps {

    @Given("^I open start page$")
    public SignInPage openStartPage() {
        getDriver().get(getConfig().getBaseUrl());
        return new SignInPage(true);
    }


    public static String getFormattedItems(List<WebElement> rows) {
        List<String> formattedRows = rows.stream()
                .map(row -> (Objects.requireNonNull(row.getAttribute("innerText"))
                        .replaceAll("\t\n", "\t")
                        .replaceAll("\n", "\t")
                        .trim()))
                .collect(Collectors.toList());
        return String.join("\n", formattedRows);
    }
}
