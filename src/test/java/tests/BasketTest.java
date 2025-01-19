package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.Listeners.TestListeners;

@Listeners({ TestListeners.class })
@Epic("LCW Tests")
@Feature("Basket Functionality Tests")
public class BasketTest extends BaseTest {

    // Declare page objects
    LoginPage loginPage;
    HeaderPage headerPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;
    ProductPage productPage;

    @Description("Test Description: Sepete ürün ekleme ve doğrulama")
    @Test(priority = 1, description = "Sepete ürün ekleme ve sepetteki bilgileri doğrulama")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Sepete ürün ekleme ve sepetteki ürünlerin doğru olduğunu doğrulama")
    public void testAddProductToBasket() throws InterruptedException {
        // Initialize the pages
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        ProductPage productPage = new ProductPage(driver);
        // login
        driver.navigate().to(baseURL);
        loginPage.hoverAndClickLogin();
        loginPage.enterCredentialsAndLogin("rektest1234@gmail.com", "rektest!123");
        Thread.sleep(1000);
        driver.navigate().to(baseURL);
        Thread.sleep(1000);
        // üst menü alt menü ve content tıklaması ve filtreleme işlemleri
        headerPage.hoverOnMenu("ÇOCUK & BEBEK","KIZ ÇOCUK");
        Thread.sleep(1000);
        headerPage.clickOnContent("Mont ve Kaban");
        Thread.sleep(500);
        headerPage.clickrejectcookies();
        Thread.sleep(800);
        productPage.ageFilterChoice("4-6 YAŞ");
        Thread.sleep(700);
        productPage.ageFilterChoice("5-6 YAŞ");
        Thread.sleep(700);
        productPage.ageFilterChoice("6 YAŞ");
        Thread.sleep(700);
        productPage.renkFilterChoice("Bej");
        Thread.sleep(500);
        // Sıralama seçeneğini uygula
        productPage.chooseSortingOptions("En çok satanlar");
        Thread.sleep(2000);
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
        Thread.sleep(3000);

        // Sepetteki ürün detaylarının kontrol edilmesi
        String basketProductType = basketPage.getBasketProductType();
        Thread.sleep(500);
        String basketProductColor = basketPage.getBasketProductColor();
        Thread.sleep(500);
        String basketPrice = basketPage.getBasketPrice();
        Thread.sleep(500);
        // Detayların karşılaştırılması
        Assert.assertTrue(
                productType.contains(basketProductType),
                "Ürün tipi eşleşmiyor: Beklenen '" + productType + "', Ancak Sepette '" + basketProductType + "' bulundu."
        );
        org.testng.Assert.assertEquals(basketProductColor, productColor, "Ürün rengi eşleşmiyor.");
        org.testng.Assert.assertEquals(basketPrice, productPrice, "Ürün fiyatı eşleşmiyor.");
        Thread.sleep(200);
        basketPage.addtoFavori();
        Thread.sleep(1500);
        headerPage.clickFavoriButton();
        Thread.sleep(500);
    }
}
/*
    @Description("Test Description: Sepetteki ürünün fiyat ve miktar bilgilerini doğrulama")
    @Test(priority = 2, description = "Sepetteki ürünün fiyat, renk ve miktar bilgilerini doğrulama")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sepetteki ürünün fiyat, renk ve miktar bilgilerini ürün sayfasındaki bilgilerle karşılaştırma")
    public void testBasketProductDetails() throws InterruptedException {
        // Navigate to basket
        headerPage.clickBasketButton();

        String basketProductType = basketPage.getBasketProductType();
        String basketProductColor = basketPage.getBasketProductColor();
        String basketProductCount = basketPage.getBasketProductCount();
        String basketPrice = basketPage.getBasketPrice();

        String expectedProductType = System.getProperty("productTypeValue");
        String expectedProductColor = System.getProperty("productColorValue");
        String expectedProductPrice = System.getProperty("productPriceValue");

        // Assertions
        assert basketProductType.equals(expectedProductType) : "Product type mismatch!";
        assert basketProductColor.equals(expectedProductColor) : "Product color mismatch!";
        assert basketPrice.equals(expectedProductPrice) : "Product price mismatch!";
    }

 */

