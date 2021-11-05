package com.but.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SamsungWashPage extends Page{

    @FindBy(css = "div.availability.nomargin > a")
    private WebElement addItem;

    @FindBy(css = "#garanties_but > button > span.see-more")
    private WebElement seePack;

    private final String aboutPack = "#garanties_but > button > span.see-more";

    private boolean isClickable = false;

    private final String clothWash = config.getEnvironment()+"produits/8806090605376/Lave-linge-hublot-SAMSUNG-WW80T734DWH-8kg.html";

    public SamsungWashPage(){
    }

    public void goToSamsunWashPage(){
        get(clothWash);
    }

    public void clickOnAddItem() {
        shortUntil(visibilityOf(addItem));
        clickOn(addItem);
    }

    public void clickOnSeePack() {
        shortUntil(visibilityOf(seePack));
        try {
            clickOn(seePack);
            isClickable=true;
        }catch (Exception e){

        }
    }

    public boolean verifySeePack(){
        return isClickable;
    }


}
