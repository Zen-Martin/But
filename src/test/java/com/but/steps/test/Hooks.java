package com.but.steps.test;

import com.but.pageObjects.Page;
import io.cucumber.java.After;

public class Hooks {
        @After()
        public void afterTakeScreenShot(){
            Page.saveScreenShotPNG();
    }
}
