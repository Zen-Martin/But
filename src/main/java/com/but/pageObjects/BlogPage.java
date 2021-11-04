package com.but.pageObjects;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BlogPage extends Page{

    @FindBy(css = ".sbi_photo img")
    private List<WebElement> ideaImg;

    @FindBy(id = "sbi_images")
    private WebElement ideaImgFrame;

    private final String blogURL = "https://blog.but.fr/";

    private int iBrokenImageCount = 0;

    public BlogPage(){}

    public void goToBlogPage(){
        get(blogURL);
    }

    public void scrollToIdeaBut(){
        shortUntil(visibilityOf(ideaImgFrame));
        scroll(ideaImgFrame.getLocation().getY()+100);
    }

    private void findBrokenImg(){

        try
        {
            for (WebElement img : ideaImg)
            {
                if (img != null)
                {
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(img.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    if (response.getStatusLine().getStatusCode() != 200)
                    {
                        System.out.println(img.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean verifyBrokenImg(){
        findBrokenImg();
        return iBrokenImageCount==0;
    }

}
