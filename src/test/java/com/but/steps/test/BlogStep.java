package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.BlogPage;
import io.cucumber.java8.En;

public class BlogStep implements En {

    public BlogStep(
            BlogPage blogPage,
            ScenarioContext scenario
    ){

        When("Go to But Blog Page", () -> {
            blogPage.goToBlogPage();
        });

        When("Scroll down to the section #LesIdéesBut", () -> {
            blogPage.scrollToIdeaBut();
        });

        Then("The images are not loaded", () -> {
            blogPage.verifyBrokenImg();
        });


    }

}
