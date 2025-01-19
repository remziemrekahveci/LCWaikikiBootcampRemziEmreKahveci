package tests;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

@Epic("LCW Tests")
@Feature("LCW Test")
public class ProductTest extends BaseTest {

    ProductPage productPage;
    HeaderPage headerPage;

    @Description("Test Description: Kız çocuk dış giyim filtreleme ve ürün seçme testi.")
    @Test(priority = 1, description="Kız çocuk dış giyim kategorisinde yaş ve renk filtreleme ve sıralama işlemi.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Yaş ve renk filtreleri ile ürünleri sıralama ve ürün seçme testi")
    public void applyFiltersAndSelectProduct() throws InterruptedException {
        driver.get("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productPage = new ProductPage(driver);
        headerPage = new HeaderPage(driver);

        // Filtreleri uygula
        headerPage.clickrejectcookies();
        productPage.ageFilterChoice("4-6 YAŞ");
        Thread.sleep(500);
        productPage.ageFilterChoice("5-6 YAŞ");
        Thread.sleep(500);
        productPage.ageFilterChoice("6 YAŞ");
        Thread.sleep(500);
        productPage.renkFilterChoice("Bej");
        Thread.sleep(500);

        // Sıralama seçeneğini uygula
        productPage.chooseSortingOptions("En çok satanlar");
        Thread.sleep(2000);

        // 4. ürünü seç
        productPage.selectNthProduct(4);
    }

    @Description("Test Description: Filtreleme ve sıralama işlemleri sonrası sepete ürün ekleme testi.")
    @Test(priority = 2, description="Filtreleme ve sıralama sonrası ürün seçimi ve sepete ekleme testi.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Filtreleme ve sıralama sonrası seçilen ürünü sepete ekleme testi")
    public void selectProductAndAddToCart() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);

        // Ürün detaylarını al ve sepete ekle
        productDetailPage.selectAvailableSize();
        Thread.sleep(500);
        productDetailPage.addtoCartButton();
        Thread.sleep(500);

        // Ürün özelliklerini al
        String productTypeValue = productDetailPage.getProductType();
        Thread.sleep(500);
        String productColorValue = productDetailPage.getProductColor();
        Thread.sleep(600);
        String productPriceValue = productDetailPage.getProductPrice();
        Thread.sleep(500);
        // Sepet kontrolü
        headerPage.clickBasketButton();
        Thread.sleep(1000);

        // Ürün bilgilerini sakla
        System.setProperty("productTypeValue", productTypeValue);
        System.setProperty("productColorValue", productColorValue);
        System.setProperty("productPriceValue", productPriceValue);
    }
}
