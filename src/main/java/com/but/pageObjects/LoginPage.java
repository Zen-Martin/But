package com.but.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page {

    @FindBy(id = "email-already")
    private WebElement emailField;

    @FindBy(id = "password-already")
    private WebElement passwordField;

    @FindBy(id = "valid-already")
    private WebElement submitField;

    @FindBy(linkText = "Calvin")
    private WebElement userLogged;

    @FindBy(linkText = "Espace client")
    private WebElement customerSpace;

    @FindBy(partialLinkText = "Accueil B")
    private WebElement acceuil;

    @FindBy(id = "user")
    private WebElement userAccount;

    @FindBy(css = "#already-client > div.session > div")
    private WebElement sessionInfo;

    @FindBy(css = " div.board-hover.account-customer > ul > li:nth-child(4) > a")
    private WebElement disconnect;

    private final String loginInfo = "#already-client > div.session > div";

    private String title = "";

    private String actionMethod = "";

    private static int logged = 0;


    public LoginPage(){

    }

    private void goToLoginPage(){
        shortUntil(visibilityOf(userAccount));
        clickOn(userAccount);
        waitForLoadingPage();
    }

    private void connexion(){
        shortUntil(visibilityOf(emailField));
        emailField.sendKeys(config.getEmail());
        passwordField.sendKeys(config.getPwd());
        clickOn(submitField);
        waitForLoadingPage();
        shortUntil(visibilityOf(userLogged));
    }

    public void accountConnexion(){
        if (logged == 0){
            goToLoginPage();
            connexion();
            logged += 1;
        }
    }

    public void clickOnAcceuilBut(){
        title = driver.getTitle();
        clickOn(acceuil);
        waitForLoadingPage();
    }

    public boolean verifyRedirection(){
        return !driver.getTitle().equals(title);
    }

    public void clickOnLogin(){
        goToLoginPage();
    }

    public void clickOnSessionInfo(){
        actionMethod = js.executeScript("return window.getComputedStyle(document.querySelector('"+loginInfo+"'),'::before').getPropertyValue('content')")
                .toString();
        clickOn(sessionInfo);
    }

    public boolean verifyInfoSession(){
       return !actionMethod.contains("none");
    }

}
