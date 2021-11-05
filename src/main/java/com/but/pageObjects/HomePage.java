package com.but.pageObjects;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    @FindBy(id = "footer_tc_privacy_button")
    private WebElement cookieOption1;

    @FindBy(id = "popin_tc_privacy_button")
    private WebElement cookieOption2;

    @FindBy(linkText = "Inscrivez-vous")
    private WebElement subscribe;

    @FindBy(css = "li.menu-02 > span")
    private WebElement sofaList;

    @FindBy(css = "#tab-26433-0 > div:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement sofaChoice;

    @FindBy(css = "#hp > section.zone.contacts.hp_alerte > a > img")
    private WebElement recallProd;

    private static int cookieStatut = 0;

    private int pdfNumberOfPages = 0;

    private String pdfContent = "none";

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
            shortUntil(visibilityOf(cookieOption1));
            clickOn(cookieOption1);
        }catch (Exception a){
            try {
                shortUntil(visibilityOf(cookieOption2));
                clickOn(cookieOption2);

            } catch (Exception b){}
        }
    }

    public void navigateToHomePage() {
        get(config.getEnvironment());
        if(cookieStatut==0){
            handleCookie();
            overPassAds();
            cookieStatut+= 1;
        }

    }

    public void scrollToNewsLetter(){
        shortUntil(visibilityOf(subscribe));
        scroll(subscribe.getLocation().getY());
    }

    public void goToNewsLetterPage() {
        clickOn(subscribe);
        waitForLoadingPage();
    }

    private void switchOnTab(int tabNumber){
        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(Tab.get(tabNumber));
    }

    public void goToRappelProd(){
        shortUntil(visibilityOf(recallProd));
        scroll(recallProd.getLocation().getY());
        js.executeScript("arguments[0].click()", recallProd);
        switchOnTab(1);
        waitForLoadingPage();
    }

    public void goToSofaPage() {
        action.moveToElement(sofaList)
                .click()
                .build().perform();

        shortUntil(visibilityOf(sofaChoice));
        clickOn(sofaChoice);
        waitForLoadingPage();

    }

    public boolean verifyContentInPDf() {
        try {
            pdfContent = readPdfContent(driver.getCurrentUrl());
        } catch (Exception e){

        }
        switchOnTab(0);
        return !pdfContent.contains("none");
    }

    private String readPdfContent(String url) throws IOException {

        URL pdfUrl = new URL(url);
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);
        PDDocument doc = PDDocument.load(bf);
        pdfNumberOfPages = getPageCount(doc);
        String content = new PDFTextStripper().getText(doc);
        doc.close();

        return content;
    }

    private int getPageCount(PDDocument doc) {
        int pageCount = doc.getNumberOfPages();
        return pageCount;
    }

}
