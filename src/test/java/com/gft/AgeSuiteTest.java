package com.gft;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


public class AgeSuiteTest {
    CartPage cartPage = new CartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:3000/");
    }

    @Test
    public void underageCola() {
        cartPage.addCola();
        CheckOutPage checkOutPage = cartPage.CheckOutPage();
        // Comprobar que no hay el input age.
        checkOutPage.ageInput.shouldBe(hidden);
        //checkOutPage.ageInput.shouldBe(visible);
        OrderPage orderPage = checkOutPage.order();
        orderPage.alertDiv.shouldBe(hidden);


//
//
//        // ...check other conditions
//        OrderPage orderPage = checkoutPage.order();
//        assertTrue(orderPage.confirmationMessage.isDisplayed());
//        assertThat(orderPage.confirmationMessage.getText(),
//                containsString("Coming right up")
//        );
    }

    /*@Test
    public void underageBeer() {
        cartPage.addBeerButton.click();
        CheckoutPage checkoutPage = cartPage.checkout();
        assertTrue(checkoutPage.ageInput.isDisplayed());
        checkoutPage.ageInput.sendKeys("17");
        OrderPage orderPage = checkoutPage.order();
        assertTrue(orderPage.alertDiv.isDisplayed());
    }

    @Test
    public void adultBeer() {
        cartPage.addBeerButton.click();
        CheckoutPage checkoutPage = cartPage.checkout();
        assertTrue(checkoutPage.ageInput.isDisplayed());
        checkoutPage.ageInput.sendKeys("19");
        OrderPage orderPage = checkoutPage.order();
        assertThat(orderPage.confirmationMessage.getText(),
                containsString("Coming right up")
        );
    }*/


}
