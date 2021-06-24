package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    private final WebDriver driver;

    @FindBy(xpath = "//p[text()='Your wish list is empty.']")
    private WebElement lblWishListEmpty;

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement btnContinue;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verifying if the empty wishlist label is displayed")
    public boolean lblWishListEmptyIsDisplayed() {
        return lblWishListEmpty.isDisplayed();
    }
}
