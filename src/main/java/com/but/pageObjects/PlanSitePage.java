package com.but.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlanSitePage extends Page{

    @FindBy(css = "#sitemap > div > div > ul li a")
    private List<WebElement> siteMap;

    private int validRedirection = 0;


    public PlanSitePage(){

    }

    public void gotoPlanSitePage(){
        get(config.getEnvironment()+"plan-site");
    }

    private void clickOnNavBarItem(String elementNavigation) {
        WebElement button = siteMap
                .stream()
                .filter( elt -> elt.getText().equals(elementNavigation))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Not element Found !"));

        clickOn(button);
        waitForLoadingPage();
        checkAccess();
    }

    public void getlink(){
        clickOnNavBarItem("Glossaire");
        clickOnNavBarItem("Mes newsletters");
        clickOnNavBarItem("Mes commandes");
        clickOnNavBarItem("Mon profil");
        clickOnNavBarItem("Les Premiers Prix");
        clickOnNavBarItem("Cuisine équipée");
    }

    private void checkAccess(){
        if (!driver.getTitle().contains("www.but.fr") && !driver.getTitle().contains("Page indisponible")){
            validRedirection+=1;
        }
        driver.navigate().back();
        waitForLoadingPage();
    }

    public boolean verifyValidRedirection(){
        return validRedirection==6;
    }


}
