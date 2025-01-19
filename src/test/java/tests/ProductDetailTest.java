package tests;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.time.Duration;

@Epic("LCW Tests")
@Feature("Product Detail Page Tests")
public class ProductDetailTest extends BaseTest {
    ProductDetailPage productDetailPage;
    HeaderPage headerPage;
    ProductPage productPage;

    @Description("Test Description: Ürün detaylarını kontrol etme ve sepete ekleme")
    @Test(priority = 1, description = "Ürün detaylarını kontrol etme ve stokta olan bir bedeni seçerek sepete ekleme")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Ürün detaylarını kontrol etme ve stokta olan bedeni seçerek sepete ekleme")
    public void verifyProductDetailsAndAddToCart() throws InterruptedException {
        driver.get("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010?beden=5-6-yas,6-yas&renk=bej&siralama=en-cok-satanlar");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productPage = new ProductPage(driver);
        headerPage = new HeaderPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        headerPage = new HeaderPage(driver);
        headerPage.clickrejectcookies();
        /* //FİLTRELER
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

         */

        // 4. ürünü seç
        productPage.selectNthProduct(4);
        Thread.sleep(300);
        driver.navigate().refresh();
        Thread.sleep(500);


        // Ürün detaylarının alınması
        String productType = productDetailPage.getProductType();
        String productColor = productDetailPage.getProductColor();
        String productPrice = productDetailPage.getProductPrice();

        // Ürün detaylarının konsola yazdırılması
        System.out.println("Ürün Tipi: " + productType);
        System.out.println("Ürün Rengi: " + productColor);
        System.out.println("Ürün Fiyatı: " + productPrice);
        Thread.sleep(500);

        // Stokta olan bedenin seçilmesi
        productDetailPage.selectAvailableSize();
        Thread.sleep(800);

        // Ürünün sepete eklenmesi
        productDetailPage.addtoCartButton();
        Thread.sleep(1200);

        // Sepete giderek doğrulama
        headerPage.clickBasketButton();
        Thread.sleep(2000);

        // Sepetteki ürün detaylarının kontrol edilmesi
        BasketPage basketPage = new BasketPage(driver);
        String basketProductType = basketPage.getBasketProductType();
        Thread.sleep(500);
        String basketProductColor = basketPage.getBasketProductColor();
        Thread.sleep(500);
        String basketPrice = basketPage.getBasketPrice();
        Thread.sleep(500);
//productTypeValue.contains(basketProductTypeValue)
        // Detayların karşılaştırılması
        Assert.assertTrue(
                productType.contains(basketProductType),
                "Ürün tipi eşleşmiyor: Beklenen '" + productType + "', Ancak Sepette '" + basketProductType + "' bulundu."
        );
        org.testng.Assert.assertEquals(basketProductColor, productColor, "Ürün rengi eşleşmiyor.");
        org.testng.Assert.assertEquals(basketPrice, productPrice, "Ürün fiyatı eşleşmiyor.");
    }
}
