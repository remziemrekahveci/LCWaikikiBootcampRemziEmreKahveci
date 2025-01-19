package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    private final By loginHoverButtonLocator = By.id("user_1_"); // Hover // üstüne mause getirilip alt sekmedeki giriş yap butonu açılacak
    private final By loginButtonLocator = By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']"); // Tıklanacak giriş yap butonu
    private final By emailFieldLocator = By.name("emailAndPhone"); // E-posta veya telefon alanı
    private final By continueButtonLocator = By.xpath("//button[@class='login-form__button login-form__button--bg-blue']"); // Devam butonu
    private final By submitLocator = By.xpath("//button[@type='submit']"); // şifre girildikten sonraki giriş yap butonu
    private final By passwordFieldLocator = By.name("password"); // Şifre alanı

    public LoginPage (WebDriver driver) {
        this.driver = driver; // Constructor ile WebDriver atanır
    }

    public void hoverAndClickLogin() {
        // Hover ve tıklama işlemleri için Actions sınıfı kullanılır
        Actions actions = new Actions(driver);
        // Hover yapılacak olan login butonu
        WebElement hoverButton = driver.findElement(loginHoverButtonLocator);
        // Fareyi butonun üzerine sürükle
        actions.moveToElement(hoverButton).perform();
        // 1 saniye bekle
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Çıkan 'Giriş Yap' butonuna tıkla
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    // Giriş bilgilerini doldurma
    public void enterCredentialsAndLogin(String email, String password) throws InterruptedException {
        // E-posta gir
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.click();
        emailField.sendKeys(email);
        // Devam butonuna tıkla
        WebElement continueButton = driver.findElement(continueButtonLocator);
        continueButton.click();
        // Şifreyi gir
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.click();
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        //giriş yap butonuna tıklanabilir olana kadar bekle ve sonra tıklama 10sn üstünde timeout ver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = driver.findElement(submitLocator);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)); // Buton tıklanabilir olana kadar bekle
        submitButton.click();
    }


}
