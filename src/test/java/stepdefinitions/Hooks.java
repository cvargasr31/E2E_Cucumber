package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import opencart.Base;
import pageobjects.MainPage;

import java.io.IOException;

public class Hooks extends Base {

    @Before
    public void before(){
        initializeDriver();
        driver.get(MainPage.getUrl());
    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            try {
                getScreenshot(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        teardown();
    }
}
