package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.Base;
import org.junit.Assert;
import pageobjects.MainPage;
import pageobjects.RegisterPage;
import pageobjects.SuccessRegisterPage;
import utilities.StringMethods;

public class RegisterStepDefinitions extends Base {
    private RegisterPage registerPage;

    @Given("The users go to the register form")
    public void theUsersGoToTheRegisterForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnRegister();
    }

    @When("The user fills the form {string} {string} {string} {string} {string}")
    public void theUserFillsTheForm(String firstName, String lastName, String phone, String password,
                                    String passwordConfirm) {
        registerPage = new RegisterPage(driver);
        registerPage.fillForm(firstName, lastName,
                StringMethods.randomEmail(), phone, password, passwordConfirm);
    }

    @Then("The register success message is displayed")
    public void theRegisterSuccessMessageIsDisplayed() {
        SuccessRegisterPage successRegisterPage = new SuccessRegisterPage(driver);
        Assert.assertTrue(successRegisterPage.lblSuccessIsDisplayed());
        Assert.assertEquals(3, 4);
    }

    @Then("The error message is displayed")
    public void theErrorMessageIsDisplayed() {
        registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.lblErrorGeneralIsDisplayed());
    }

    @When("^The user fills the form with invalid data (.*) (.*) (.*) (.*) (.*) (.*)$")
    public void theUserFillsTheFormWithInvalidData(String firstName, String lastName, String email, String phone,
                                                   String password, String passwordConfirm) {
        registerPage = new RegisterPage(driver);
        registerPage.fillForm(firstName, lastName,
                email, phone, password, passwordConfirm);
    }
}
