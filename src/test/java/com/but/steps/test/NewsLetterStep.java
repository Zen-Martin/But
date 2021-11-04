package com.but.steps.test;

import com.but.context.ScenarioContext;
import com.but.pageObjects.NewsLetterPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class NewsLetterStep implements En {

    public NewsLetterStep(
            NewsLetterPage newsLetterPage,
            ScenarioContext scenario
    ){

        When("Scroll down, click on the aside-to-top icon to page go up", () -> {
            newsLetterPage.scrollDown();
        });

        Then("The aside-to-top icon remains visible even though it is already on top", () -> {
            Assert.assertEquals(newsLetterPage.verifyPageUpDisplay(),true);
        });

    }

}
