package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.SofaArticlePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class SofaArticleStep implements En {

    public SofaArticleStep(
            SofaArticlePage sofaArticlePage,
            ScenarioContext scenario
    ){

        When("Click on an article", () -> {
            sofaArticlePage.clickOnSofaItem();
        });

        When("Click on *imprimer* located under the link *ajouter à mes envies*", () -> {
            sofaArticlePage.clickOnPrint();
        });

        Then("No reaction, the button is not functional", () -> {
            Assert.assertEquals(sofaArticlePage.verifyPrint(),true);
        });



    }
}
