package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.HomePage;
import io.cucumber.java8.En;

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
    }

}
