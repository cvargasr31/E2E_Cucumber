package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountFormPage {
    private final WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputPhone;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//a[text()='Back']")
    private WebElement btnBack;

    @FindBy(xpath = "//div[@class='text-danger' and contains(text(), 'E-Mail Address does not appear to be valid')]")
    private WebElement lblErrorWrongEmail;

    public EditAccountFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("The user fills the edit account form")
    public void fillForm(String firstName, String lastName, String Phone) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        inputPhone.clear();
        inputPhone.sendKeys(Phone);
        clickOnContinue();
    }

    @Step("The user changes the email")
    public void changeEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        clickOnContinue();
    }

    @Step("Verifying if the error email message is displayed")
    public boolean lblErrorWrongEmailIsDisplayed() {
        return lblErrorWrongEmail.isDisplayed();
    }

    public void clickOnContinue() {
        btnContinue.click();
    }
}
