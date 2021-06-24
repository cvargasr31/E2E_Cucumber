package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@title = 'My Account']")
    private WebElement btnMyAccount;

    @FindBy(xpath = "//a[contains(., 'Login')]")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[contains(., 'Register')]")
    private WebElement btnRegister;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown')]//a[contains(. , 'My Account')]")
    private WebElement btnMyAccountSub;

    @FindBy(xpath = "//a[contains(., 'Logout')]")
    private WebElement btnLogout;

    private final static String url = "https://demo.opencart.com/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return url;
    }

    @Step("User clicks on register")
    public void clickOnRegister() {
        //1. Click on "MY ACCOUNT"
        btnMyAccount.click();
        //2. Select Register
        btnRegister.click();
    }

    @Step("User clicks on login")
    public void clickOnLogin() {
        //1. Click on "MY ACCOUNT"
        btnMyAccount.click();
        //2. Select Login
        btnLogin.click();
    }

    @Step("User go to his account")
    public void goToMyAccount() {
        btnMyAccount.click();
        btnMyAccountSub.click();
    }

    @Step("User logs out")
    public void logout(){
        btnMyAccount.click();
        btnLogout.click();
    }

    public static String getUrl() {
        return url;
    }
}
