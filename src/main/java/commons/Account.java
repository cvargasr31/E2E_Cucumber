package commons;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.MainPage;

public class Account {
    private final MainPage mainPage;
    private final LoginPage loginPage;
    private final WebDriver driver;

    public Account(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    public void login(String username, String password){
        //go to the main page
        driver.get(MainPage.getUrl());
        //click on login
        mainPage.clickOnLogin();
        //we fill the user name and pwd
        loginPage.loginUser(username, password);
    }
    //test_user@test.com
    //1234
}
