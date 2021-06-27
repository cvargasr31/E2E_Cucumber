package opencart;

import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobjects.MainPage;

import java.io.IOException;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Base {
    public static WebDriver driver;
    private final String browser = System.getProperty("browser");
    private String browserVersion;

    public void initializeDriver(){
        driver = buildDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void teardown(){
        if(driver!=null){
            if(browserVersion == null){
                browserVersion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
                setEnvVariables();
            }
            driver.quit();
        }
    }

    private WebDriver buildDriver(){
        switch (browser){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                System.out.println("Bad driver name");
                return null;
        }
    }

    public void setEnvVariables(){
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", browser)
                        .put("Browser Version", browserVersion)
                        .put("Platform", "Windows")
                        .put("URL", MainPage.getUrl())
                        .build());
    }

    @Attachment(value = "Screenshot failure", type = "image/png")
    public byte[] getScreenshot(WebDriver driver) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
