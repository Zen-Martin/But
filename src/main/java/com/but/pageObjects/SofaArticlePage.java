package com.but.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SofaArticlePage extends Page{

    @FindBy(css = "#printProductBtn")
    private WebElement print;

    @FindBy(css = "div:nth-child(1) > a > div > div:nth-child(2) > img")
    private WebElement sofaItem;

    @FindBy(css = "div > cr-button.cancel-button")
    private WebElement cancelBtn;

    private final String morePrint = "#printProductBtn";

    private String onClickAction = "";

    private String actionMethod = "";

    public SofaArticlePage(){
    }

    public void clickOnSofaItem(){
        shortUntil(visibilityOf(sofaItem));
        clickOn(sofaItem);
    }

    private void switchOnTab(int tabNumber){
        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(tabNumber));
    }

    public void clickOnPrint(){
        actionMethod = js.executeScript("return window.getComputedStyle(document.querySelector('"+morePrint+"'),'::before').getPropertyValue('content')")
                .toString();
        onClickAction = print.getAttribute("onclick");
        try{
            js.executeScript("arguments[0].click()", print);
        }catch (Exception e){}
    }

    public boolean verifyPrint(){
        return (!onClickAction.isEmpty() && !actionMethod.contains("none"));
    }

}
