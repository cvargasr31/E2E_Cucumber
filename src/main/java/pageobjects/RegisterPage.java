package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private final WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputPhone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputPasswordConfirm;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement chkPrivacy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(className = "text-danger")
    private WebElement lblErrorGeneral;

    @FindBy(xpath = "//div[@class='text-danger' and contains(. ,'E-Mail Address does not appear to be valid')]")
    private WebElement lblErrorWrongEmail;

    @FindBy(xpath = "//div[@class='text-danger' and contains(. ,'Password confirmation does not match password!')]")
    private WebElement lblErrorMismatchPassword;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean lblErrorGeneralIsDisplayed() {
        return lblErrorGeneral.isDisplayed();
    }

    public boolean lblErrorWrongEmailIsDisplayed() {
        return lblErrorWrongEmail.isDisplayed();
    }

    public boolean lblErrorMismatchPasswordIsDisplayed() {
        return lblErrorMismatchPassword.isDisplayed();
    }

    @Step("Users fill form")
    public void fillForm(String firstName, String lastName, String email, String phone, String password, String passwordConfirm) {
        //Enter first name
        inputFirstName.clear();
        if(firstName != null){
            inputFirstName.sendKeys(firstName);
        }
        //Enter last name
        inputLastName.clear();
        if(lastName != null){
            inputLastName.sendKeys(lastName);
        }
        //Enter email
        inputEmail.clear();
        if(email != null){
            inputEmail.sendKeys(email);
        }
        //Enter telephone
        inputPhone.clear();
        if(phone != null){
            inputPhone.sendKeys(phone);
        }
        //Enter password
        inputPassword.clear();
        if(password != null){
            inputPassword.sendKeys(password);
        }
        //Enter confirm password
        inputPasswordConfirm.clear();
        if(passwordConfirm != null){
            inputPasswordConfirm.sendKeys(passwordConfirm);
        }
        //Check privacy and policy checkbox
        chkPrivacy.click();
        //Click on "Continue"
        btnContinue.click();
    }
}
