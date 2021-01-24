package booking.automationtask;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    @Parameters({ "browser", "URL" })
    public void openURL(@Optional("chrome") String WindowBrowser, @Optional("https://www.booking.com/") String URL) {

        final String userDirectory = System.getProperty("user.home");

        if (WindowBrowser.equalsIgnoreCase("firefox")) {
            final StringBuilder geckoDriverPath = new StringBuilder();
           // geckoDriverPath.append(userDirectory + File.separator + "resources");
            geckoDriverPath.append(userDirectory  + File.separator + "geckodriver.exe");

            System.setProperty("webdriver.gecko.driver", geckoDriverPath.toString());
            driver = new FirefoxDriver();
        } else if (WindowBrowser.equalsIgnoreCase("chrome")) {
            final StringBuilder chromeDriverPath = new StringBuilder();
            //chromeDriverPath.append(userDirectory + File.separator + "resources");
            chromeDriverPath.append(userDirectory  + File.separator + "chromedriver.exe");
            final StringBuilder geckoDriverPath = new StringBuilder();
            geckoDriverPath.append(userDirectory + File.separator + "resources");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath.toString());
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);

    }

    @AfterTest
    public void closebooking() {
        driver.quit();
    }
}
