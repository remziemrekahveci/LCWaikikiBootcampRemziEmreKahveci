package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Log;

public class BaseTest {
    public static WebDriver driver;
    static SoftAssert softAssert;
    String baseURL = "https://www.lcw.com";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions cop = new ChromeOptions();
        driver = new ChromeDriver(cop);
        cop.addArguments("--disable-popup-blocking"); // Pop-up engelleyici devre dışı
        cop.addArguments("--disable-notifications");
        Log.info("Test Başladı");

        // WebDriver driver = new ChromeDriver(options);
        //driverları kurmak için setUp klası oluşturuldu.
        // assertler içinde SoftAssert methodu girildi.
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // her testte işlemin timeout olması için 10 saniye bekliyoruz.
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown() {
        Log.info("Test Bitti");
        driver.quit();
        // bütün assertleri bildirmek için asserAll methodu girildi.
        softAssert.assertAll();

    }





}

