package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends LocatorStrings {

    protected WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null && result.isSuccess()) {
            driver.quit();
        }
    }
}
