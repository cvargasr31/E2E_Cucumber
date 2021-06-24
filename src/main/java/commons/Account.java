package commons;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.MainPage;

public class Account {
    private MainPage mainPage;
    private LoginPage loginPage;
    private WebDriver driver;

    public Account(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    public void login(String username, String password){
        //go to the main page
        driver.get(mainPage.getUrl());
        //click on login
        mainPage.clickOnLogin();
        //we fill the user name and pwd
        loginPage.loginUser(username, password);
    }

    //test_user@test.com
    //1234
}
