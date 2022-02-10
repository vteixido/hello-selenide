package com.gft.cucumber;

import com.codeborne.selenide.Condition;
import com.gft.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class RobobarStepDefinitions {
    CartPage cartPage = new CartPage();

    @Given("user opens robobar website")
    public void userOpensRobobarWebsite() {
        open("http://localhost:3000");
    }

    @When("user adds a cola")
    public void userAddsACola() {
        cartPage.addCola();
    }

    @Then("total should be €{double}")
    public void totalShouldBe€(Double total) {
        cartPage.total().shouldBe(Condition.exactText("€" + String.format("%.2f", total)));
    }
}


