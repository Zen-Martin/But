package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.PlanSitePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class PlanSiteStep implements En {

    public PlanSiteStep(
            PlanSitePage planSitePage,
            ScenarioContext scenario
    ){

        When("Go to But plan site", () -> {
            planSitePage.gotoPlanSitePage();
        });

        When("Click on the differents links", () -> {
            planSitePage.getlink();
        });

        Then("A *404-error* page is displayed", () -> {
            Assert.assertEquals(planSitePage.verifyValidRedirection(),true);
        });

    }

}
