package stepdefinitions;

import commons.Account;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.Base;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pageobjects.EditAccountFormPage;
import pageobjects.MyAccountPage;
import pageobjects.WishListPage;
import utilities.StringMethods;

public class MyAccountStepDefinitions extends Base {
    private MyAccountPage myAccountPage;

    @Given("The user logs into the application with username {string} and password {string}")
    public void theUserLogsIntoTheApplicationWithUsernameAndPassword(String username, String password) {
        Account account = new Account(driver);
        account.login(username, password);
    }

    @When("The user goes to his wishlist option")
    public void theUserGoesToHisWishlistOption() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnWishlist();
    }

    @Then("Empty wishlist message should be displayed")
    public void emptyWishlistMessageShouldBeDisplayed() {
        WishListPage wishListPage = new WishListPage(driver);
        Assert.assertTrue(wishListPage.lblWishListEmptyIsDisplayed());
    }

    @When("The user goes to his edit information option")
    public void theUserGoesToHisEditInformationOption() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickOnEditInformation();
    }

    @And("Fills the information with random data")
    public void fillsTheInformationWithRandomData() {
        EditAccountFormPage editAccountFormPage = new EditAccountFormPage(driver);
        editAccountFormPage.fillForm(StringMethods.getRandomString(), StringMethods.getRandomString(),
                StringMethods.getRandomString());
    }

    @Then("The app should redirect to my account page")
    public void theAppShouldRedirectToMyAccountPage() {
        myAccountPage = new MyAccountPage(driver);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(myAccountPage.lblYourStoreIsDisplayed()).isTrue();
        softAssertions.assertThat(myAccountPage.linkEditAccountIsDisplayed()).isTrue();
        softAssertions.assertThat(myAccountPage.linkChangePasswordIsDisplayed()).isTrue();
        softAssertions.assertThat(myAccountPage.linkModifyAddressBookIsDisplayed()).isTrue();
        softAssertions.assertThat(myAccountPage.linkModifyWishlistIsDisplayed()).isTrue();
        softAssertions.assertAll();
    }

    @And("A success edit info message should appear")
    public void aSuccessEditInfoMessageShouldAppear() {
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.lblSuccessEditIsDisplayed());
    }
}
