package com.but.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(id = "footer_tc_privacy_button")
    private WebElement cookieOption;

    @FindBy(linkText = "Inscrivez-vous")
    private WebElement subscribe;

    public HomePage() {
    }

    private void overPassAds(){
        driver.switchTo().defaultContent();
        action.moveByOffset(0,0)
                .click()
                .build().perform();
    }

    private void handleCookie(){
        try{
            shortUntil(visibilityOf(cookieOption));
            clickOn(cookieOption);
        }catch (Exception e){}
    }

    public void navigateToHomePage(){
        get(config.getEnvironment());
        handleCookie();
        overPassAds();
    }

    public void scrollToNewsLetter(){
        shortUntil(visibilityOf(subscribe));
        scroll(subscribe.getLocation().getY());
    }

    public void goToNewsLetterPage(){
        clickOn(subscribe);
        waitForLoadingPage();
    }

}
