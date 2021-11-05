package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(
            HomePage homePage,
            ScenarioContext scenario
    ){

        Given("I am on the homePage", () -> {
            homePage.navigateToHomePage();
        });

        When("Scroll down to the section newsletter", () -> {
            homePage.scrollToNewsLetter();
        });

        When("Click on the button *Inscrivez-vous*", () -> {
            homePage.goToNewsLetterPage();
        });

        When("Unroll the tab *canapé* and click on *canapé* in the list", () -> {
            homePage.goToSofaPage();
        });


        When("Scroll down to section *Rappel produits* then click", () -> {
            homePage.goToRappelProd();
        });

        Then("An XML code extract mentioning an access error is returned", () -> {
            Assert.assertEquals(homePage.verifyContentInPDf(),true);
        });


    }

}
