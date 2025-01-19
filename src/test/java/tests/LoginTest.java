package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Description("Test Description: Geçerli kullanıcı adı ve şifre ile Login test.")
    @Test(priority = 1, description = "Geçerli kayıt ile Login test.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Geçerli kayıt ile Login test")
    public void loginTest() throws InterruptedException {
        driver.navigate().to(baseURL);
        loginPage = new LoginPage(driver);
        loginPage.hoverAndClickLogin();
        String email = "rektest1234@gmail.com";
        String password = "rektest!123";
        loginPage.enterCredentialsAndLogin(email, password);
        Thread.sleep(500);
        String expectedUrl = "https://www.lcw.com"; //after successful login
        String actualUrl = driver.getCurrentUrl();
        org.testng.Assert.assertEquals(actualUrl, expectedUrl, "LOGİN İŞLEMİ BAŞARISIZ");
    }

    @Description("Test Description: Geçersiz şifre ile Login test.")
    @Test(priority = 2, description = "Geçersiz kayıt ile Login test.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Geçersiz kayıt ile Login test")
    public void invalidloginTest() throws InterruptedException {
        driver.navigate().to(baseURL);
        loginPage = new LoginPage(driver);
        loginPage.hoverAndClickLogin();
        String email = "rektest1234@gmail.com";
        String password = "password";
        loginPage.enterCredentialsAndLogin(email, password);
        Thread.sleep(500);
        String expectedUrl = "https://www.lcw.com/giris"; //after successful login
        String actualUrl = driver.getCurrentUrl();
        org.testng.Assert.assertEquals(actualUrl, expectedUrl, "LOGİN İŞLEMİ BAŞARISIZ");
    }

    @Description("Test Description: Boş kullanıcı adı ve şifre ile Login test.")
    @Test(priority = 3, description = "Boş kayıt ile Login test.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Boş kayıt ile Login test")
    public void emptyloginTest() throws InterruptedException {
        driver.navigate().to(baseURL);
        loginPage = new LoginPage(driver);
        loginPage.hoverAndClickLogin();
        String email = " ";
        String password = " ";
        loginPage.enterCredentialsAndLogin(email, password);
        Thread.sleep(500);
        String expectedUrl = "https://www.lcw.com/giris"; //after successful login
        String actualUrl = driver.getCurrentUrl();
        org.testng.Assert.assertEquals(actualUrl, expectedUrl, "LOGİN İŞLEMİ BAŞARISIZ");
    }



}
