package pages;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public  static WebDriverWait wait;
    final public String baseURL = "https://www.lcw.com/";

    public BasePage() {
    }

    @BeforeAll
    public static void initializeDriver() {
        ChromeOptions cop = new ChromeOptions();
        cop.addArguments("--remote-allow-origins=*");
        cop.addArguments("--disable-notifications");
        driver = new ChromeDriver(cop);
       // driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
