package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Description;
import opencart.Base;

import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;

import java.io.IOException;

public class Hooks extends Base {
    public static WebDriver driver;

    @Before
    @Description("before hook")
    public void before(){
        driver = initializeDriver();
        driver.get(MainPage.getUrl());
    }

    @After
    @Description("after hook")
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
