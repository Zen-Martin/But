package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.SamsungWashPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class SamsungWashStep implements En {

    public SamsungWashStep(
            SamsungWashPage samsungWashPage,
            ScenarioContext scenario
    ){

        When("Go on specific article *Samsung Lave Linge*", () -> {
            samsungWashPage.goToSamsunWashPage();
        });

        When("Click on *Ajouter au panier*", () -> {
            samsungWashPage.clickOnAddItem();
        });

        When("Click on *Voir le pack*", () -> {
            samsungWashPage.clickOnSeePack();
        });

        Then("No reaction from the button", () -> {
            Assert.assertEquals(samsungWashPage.verifySeePack(), true);
        });



    }
}
