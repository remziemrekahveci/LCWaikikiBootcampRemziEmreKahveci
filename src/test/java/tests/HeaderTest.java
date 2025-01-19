package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HeaderTest extends BaseTest {

    HeaderPage headerPage;

    @Description("Test Description: Üst menüdeki 'Favorilerim' butonuna tıklama testi")
    @Test(priority = 1, description = "Üst menüdeki 'Favorilerim' butonuna tıklama testi")
    @Severity(SeverityLevel.NORMAL)
    @Story("Favorilerim butonunun doğru şekilde çalıştığının kontrolü")
    public void testClickFavoriButton() throws InterruptedException {
        headerPage = new HeaderPage(driver);
        driver.navigate().to("https://www.lcw.com");
        headerPage.clickFavoriButton();
        // Beklenen URL veya sayfa kontrolünü buraya ekleyebilirsiniz
        String expectedUrl = "https://www.lcw.com/favorilerim";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Favorilerim sayfasına yönlendirme başarısız!");
    }



    @Description("Test Description: 'Çocuk & Bebek' menüsündeki 'Kız Çocuk' alt menüsüne tıklama testi")
    @Test(priority = 2, description = "Çocuk & Bebek menüsündeki Kız Çocuk alt menüsüne tıklama")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Kız Çocuk alt menüsüne başarılı bir şekilde geçiş yapılabilmesi")
    public void testHoverOverSubMenuItem() throws InterruptedException {
        driver.get("https://www.lcw.com/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverOnMenu("ÇOCUK & BEBEK","KIZ ÇOCUK");
        Thread.sleep(1000);
        headerPage.clickOnContent("Mont ve Kaban");
        Thread.sleep(500);

        String expectedUrl = "https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010"; // Giriş sonrası URL
        String actualUrl = driver.getCurrentUrl();
        org.testng.Assert.assertEquals(actualUrl, expectedUrl, "İşlem Başarısız!");
    }

    @Description("Test Description: Arama kutusuna kelime yazma testi")
    @Test(priority = 3, description = "Arama kutusuna kelime yazma testi")
    @Severity(SeverityLevel.MINOR)
    @Story("Arama kutusuna kelime girip arama sonuçlarının getirilmesi")
    public void testSearchFromWord() throws InterruptedException {
        driver.get("https://www.lcw.com/");
        headerPage = new HeaderPage(driver);
        headerPage.searchfromword("Kazak");
        Thread.sleep(500);
    }

    @Description("Test Description: Çerez reddetme testi")
    @Test(priority = 4, description = "Çerez reddetme testi")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Çerez banner'ını reddetme ve işlem doğrulama")
    public void testClickRejectCookies() throws InterruptedException {
        headerPage = new HeaderPage(driver);
        driver.get("https://www.lcw.com/");
        headerPage.clickrejectcookies();
    }
    @Description("Test Description: Sepet numarasını alma ve doğru gösterildiğini doğrulama testi")
    @Test(priority = 5, description = "Sepet numarasını alma ve doğrulama")
    @Severity(SeverityLevel.NORMAL)
    @Story("Sepet sayısının doğru gösterildiğini doğrulama")
    public String testGetBasketTotalNumber() {
        headerPage = new HeaderPage(driver);
        return headerPage.getBasketTotalNumber();
    }

}
