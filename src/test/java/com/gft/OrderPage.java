package com.gft;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/success
public class OrderPage {

    public SelenideElement textOrderFinished = $("p");

    public SelenideElement alertDiv = $(".alert-danger");

    public String getAlertText(){
        return alertDiv.getText();
    }

    public SelenideElement alertDiv(){
        return alertDiv;
    }
    public String getOrderFinishedText(){
        return textOrderFinished.getText();
    }

    public SelenideElement textOrderFinished(){
        return textOrderFinished;
    }


}