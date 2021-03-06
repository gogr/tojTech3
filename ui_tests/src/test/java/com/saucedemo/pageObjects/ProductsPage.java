package com.saucedemo.pageObjects;

import com.saucedemo.BasePage;
import io.cucumber.java.en.And;

import static com.saucedemo.helpers.ElementsInteraction.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_BUTTON = "//a[.='%s']/../..//button[.='ADD TO CART']";
    private static final String REMOVE_BUTTON = "//a[.='%s']/../..//button[.='REMOVE']";
    public Header header;

    public ProductsPage() {
    }

    public ProductsPage(boolean takeScreenShot) {
        super(takeScreenShot);
        header = new Header(true);
    }

    public void isPageOpened() {
        getWait().until(titleIs("Swag Labs"));
        getWait().until(urlContains("inventory.html"));
    }

    @And("^I am on Products page$")
    public void verifyIsPageOpened() {
        waitForOpen();
    }

    @And("^I click 'ADD TO CART' button on '(.*)' product on Products page$")
    public void clickAddToCart(String productName) {
        click(getLocator(ADD_TO_CART_BUTTON, productName));
        getWait().until(visibilityOfElementLocated(getLocator(REMOVE_BUTTON, productName)));
    }

    @And("^I click 'REMOVE' button on '(.*)' product on Products page$")
    public void clickRemoveFromCart(String productName) {
        click(getLocator(REMOVE_BUTTON, productName));
        getWait().until(visibilityOfElementLocated(getLocator(ADD_TO_CART_BUTTON, productName)));
    }
}
