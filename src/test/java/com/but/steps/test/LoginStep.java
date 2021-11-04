package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.LoginPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class LoginStep implements En {

    public LoginStep(
            LoginPage loginPage,
            ScenarioContext scenario
    ){

        Given("I connect to my account", () -> {
            loginPage.accountConnexion();
        });

        Then("Click on the link *Accueil BUT* located in Ariadne's thread", () -> {
            loginPage.clickOnAcceuilBut();
        });

        Then("No redirection is made, the customer area page remains displayed", () -> {
            Assert.assertEquals(loginPage.verifyRedirection(),true);
        });

        When("Click on *Se connecter* in the navigation bar", () -> {
            loginPage.clickOnLogin();
        });

        When("Click on the button to the right of the checkbox *Rester connecté\\(e)*", () -> {
            loginPage.clickOnSessionInfo();
        });

        Then("No reaction", () -> {
            Assert.assertEquals(loginPage.verifyInfoSession(),true);
        });


    }
}
