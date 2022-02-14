package com.gft;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class CartSuiteTest {
    CartPage cartPage =  new CartPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://robobar.sinensia.pw");
    }

    @Test
    public void colaTest() {
        cartPage.btnCheck().shouldBe(disabled);
        cartPage.addCola();
        cartPage.total().shouldBe(text("€1.25"));
        cartPage.addCola();
        cartPage.total().shouldBe(text("€2.50"));
        cartPage.btnCheck().shouldBe(enabled);

    }

    @Test
    public void beerTest() {
        cartPage.btnCheck().shouldBe(disabled);
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€2.00"));
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€4.00"));
        cartPage.btnCheck().shouldBe(enabled);
    }

    @Test
    public void wineTest() {
        cartPage.btnCheck().shouldBe(disabled);
        cartPage.addWine();
        cartPage.total().shouldBe(text("€3.00"));
        cartPage.addWine();
        cartPage.total().shouldBe(text("€6.00"));
        cartPage.btnCheck().shouldBe(enabled);

    }

    @Test
    public void oneColaOneBeerOneWine() {
        cartPage.btnCheck().shouldBe(disabled);
        cartPage.addCola();
        cartPage.addWine();
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€6.25"));
        cartPage.btnCheck().shouldBe(enabled);

    }

    @Test
    public void oneColaOneBeer(){
        cartPage.btnCheck().shouldBe(disabled);
        cartPage.addCola();
        cartPage.addBeer();
        cartPage.total().shouldBe(text("€3.25"));
        cartPage.btnCheck().shouldBe(enabled);

    }

}
