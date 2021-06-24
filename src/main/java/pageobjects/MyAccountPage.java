package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private final WebDriver driver;

    @FindBy(linkText = "Your Store")
    private WebElement lblYourStore;

    @FindBy(linkText = "Edit your account information")
    private WebElement linkEditAccount;

    @FindBy(linkText = "Change your password")
    private WebElement linkChangePassword;

    @FindBy(linkText = "Modify your address book entries")
    private WebElement linkModifyAddressBook;

    @FindBy(linkText = "Modify your wish list")
    private WebElement linkModifyWishlist;

    @FindBy(linkText = "View your order history")
    private WebElement linkOrderHistory;

    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    private WebElement linkNewsletter;

    @FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(text(), 'Success: Your account has been successfully updated.')]")
    private WebElement lblSuccessEdit;

    @FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(text(), 'Success: Your newsletter subscription has been successfully updated!')]")
    private WebElement lblSuccessNewsLetter;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("The user clicks on wishlist")
    public void clickOnWishlist() {
        linkModifyWishlist.click();
    }

    @Step("The user clicks on order history")
    public void clickOnOrderHistory() {
        linkOrderHistory.click();
    }

    @Step("The user clicks on newsletter")
    public void clickOnNewsletter() {
        linkNewsletter.click();
    }

    @Step("The user clicks on edit information")
    public void clickOnEditInformation() {
        linkEditAccount.click();
    }

    @Step("Verifying if your store label is displayed")
    public boolean lblYourStoreIsDisplayed(){
        return lblYourStore.isDisplayed();
    }

    @Step("Verifying if the link edit account is displayed")
    public boolean linkEditAccountIsDisplayed(){
        return linkEditAccount.isDisplayed();
    }

    @Step("Verifying if change password link is displayed")
    public boolean linkChangePasswordIsDisplayed(){
        return linkChangePassword.isDisplayed();
    }

    @Step("Verifying if modify your address book link is displayed")
    public boolean linkModifyAddressBookIsDisplayed(){
        return linkModifyAddressBook.isDisplayed();
    }

    @Step("Verifying if modify wishlist is displayed")
    public boolean linkModifyWishlistIsDisplayed(){
        return linkModifyWishlist.isDisplayed();
    }

    @Step("Verifying if success edit label is displayed")
    public boolean lblSuccessEditIsDisplayed() {
        return lblSuccessEdit.isDisplayed();
    }

    @Step("Verifying if success newsletter label is displayed")
    public boolean lblSuccessNewsLetterIsDisplayed() {
        return lblSuccessNewsLetter.isDisplayed();
    }
}
