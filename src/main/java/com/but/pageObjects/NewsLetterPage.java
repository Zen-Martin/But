package com.but.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class NewsLetterPage extends Page{

    @FindBy(id = "blog")
    private WebElement blog;

    @FindBy(id = "menu_footer")
    private WebElement footerMenu;

    @FindBy(id = "email-newsletter")
    private WebElement emailField;

    @FindBy(id = "aside-to-top")
    private WebElement pageGoUp;

    public NewsLetterPage(){

    }

    public void scrollDown(){
        scroll(footerMenu.getLocation().getY()+200);
        shortUntil(visibilityOf(pageGoUp));
        clickOn(pageGoUp);
    }

    private void userPerformActions() throws InterruptedException {
        emailField.sendKeys(config.getEmail());
        action.moveToElement(blog)
                .build()
                .perform();
        Thread.sleep(1500);
    }

    public boolean verifyPageUpDisplay() throws InterruptedException {
        userPerformActions();
        return !pageGoUp.isDisplayed();
    }


}
