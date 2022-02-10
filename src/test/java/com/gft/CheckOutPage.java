package com.gft;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

// http://localhost:3000/#!/review
public class CheckOutPage {

    public SelenideElement btnCheckOutOrder = $(".btn-success");

    public SelenideElement ageInput = $("#ageInput" );


    public OrderPage order(){
        btnCheckOutOrder.click();
        return page(OrderPage.class);
    }

    public void setAge(String value){
        ageInput.sendKeys(value);
    }

    public SelenideElement ageInput (){
        return ageInput;
    }




}