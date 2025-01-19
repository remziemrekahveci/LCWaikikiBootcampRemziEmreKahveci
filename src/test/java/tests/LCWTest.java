package tests;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.Listeners.TestListeners;

import java.time.Duration;

@Listeners({ TestListeners.class })
@Epic("LCW Tests")
@Feature("LCW Senaryo 1 Test")
public class LCWTest extends BaseTest {
    LoginPage loginPage;
    HeaderPage headerPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;
    ProductPage productPage;

//   Burada başlıyor...
@Description("Test Description: geçerli kullanıcı ve şifre ile login test.")
@Test(priority = 1, description="geçerli kullanıcı ve şifre ile login test.")
@Severity(SeverityLevel.BLOCKER)
@Story("geçerli kullanıcı ve şifre ile login test")


// @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        // LC Waikiki ana sayfasına git
        String baseURL = "https://www.lcw.com";
        driver.navigate().to(baseURL);
        // TabBarPage sınıfından bir nesne oluştur
        LoginPage loginPage = new LoginPage(driver);
        // Login işlemini gerçekleştiren metodu çağır
        loginPage.hoverAndClickLogin();
        // Test doğrulama: Login sayfasına yönlendirme kontrol edilebilir
        //String expectedUrl = "https://www.lcw.com/giris";
        //String actualUrl = driver.getCurrentUrl();
        // Giriş bilgilerini doldurma ve giriş yapma
        String email = "rektest1234@gmail.com";
        String password = "rektest!123";
        loginPage.enterCredentialsAndLogin(email, password);
        Thread.sleep(500);



    // Giriş sonrası beklenen URL
        String expectedUrl = "https://www.lcw.com"; // Giriş sonrası URL
        String actualUrl = driver.getCurrentUrl();
        // Assert ile doğrulama
        org.testng.Assert.assertEquals(actualUrl, expectedUrl, "Login sayfasına yönlendirme başarısız!");
    }

    @Description("Test Description: kategorilere gitme.")
    @Test(priority = 2, description="çocuk ve bebek üst menüsünden kız çocuk alt menüsüne geçerek mont ve kaban content'ine gitme.")
    @Severity(SeverityLevel.CRITICAL)
    @Story("çocuk ve bebek üst menüsünden kız çocuk alt menüsüne geçerek mont ve kaban content'ine gitme")


    //@Test(priority = 2)
    public void menubebektest() throws InterruptedException {
        driver.get("https://www.lcw.com/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.hoverOnMenu("ÇOCUK & BEBEK","KIZ ÇOCUK");
        Thread.sleep(500);
        headerPage.clickOnContent("Mont ve Kaban");
        Thread.sleep(500);

        String expectedUrl = "https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010"; // Giriş sonrası URL
        String actualUrl = driver.getCurrentUrl();
        org.testng.Assert.assertEquals(actualUrl, expectedUrl, "İşlem Başarısız!");
    }

    @Description("Test Description: ürün filtreleme fonksiyonları ve sorting testi ile 4. ürünü seçme")
    @Test(priority = 3, description="ürün filtreleme fonksiyonları ve sorting testi ile 4. ürünü seçme")
    @Severity(SeverityLevel.CRITICAL)
    @Story("geçerli beden-renk filtreleri ile en çok satanlar kategorisinde listeleme ile 4. ürünü seçme")


    //@Test(priority = 3)
    public void SizeChoise() throws InterruptedException {
       // driver.get("https://www.lcw.com/kiz-cocuk-dis-giyim-t-1010");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ProductPage productPage = new ProductPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickrejectcookies();
        productPage.ageFilterChoice("4-6 YAŞ");
        Thread.sleep(400);
        productPage.ageFilterChoice("5-6 YAŞ");
        Thread.sleep(400);
        productPage.ageFilterChoice("6 YAŞ");
        Thread.sleep(400);
        productPage.renkFilterChoice("Bej");
        productPage.chooseSortingOptions("En çok satanlar");
        Thread.sleep(2000);
        productPage.selectNthProduct(4);  // 4. ürün indexdeki 3. yere gidiyor. 1. ürün indexde 0. ürüne gidiyor
    }

    @Description("Test Description: Ürünün özelliklerini alma ve ürünü sepete ekleme testi")
    @Test(priority = 4, description="Ürünün özelliklerini alma ve ürünü sepete ekleme testi")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Ürünün özelliklerini alma ve ürünü sepete ekleme testi")


    //@Test(priority = 4)
    public void SelectProduct() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
        // driver.get("https://www.lcw.com/kapusonlu-kiz-cocuk-mont-bej-o-4411831");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        // headerPage.search();
        productDetailPage.selectAvailableSize();
        productDetailPage.addtoCartButton();
        Thread.sleep(500);

        // Ürün tipi ve rengi alın
         String productTypeValue = productDetailPage.getProductType();
        String productColorValue = productDetailPage.getProductColor();
        Thread.sleep(300);
        String productPriceValue = productDetailPage.getProductPrice();


        headerPage.clickBasketButton();
        Thread.sleep(1000);

        // Değerleri  setproperty methodu ile test içinde saklanır
         System.setProperty("productTypeValue", productTypeValue);
        System.setProperty("productColorValue", productColorValue);
        System.setProperty("productPriceValue", productPriceValue);
    }

    @Description("Test Description: sepete eklenen ürünü onaylama ve favorilere ekleme testi")
    @Test(priority = 5, description="Sepete eklenen ürünü onaylama ve favorilere ekleme testi.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("sepetteki ürünün fiyat-renk-ürün adı'nı ürünün gerçek renk-fiyat-ürün adı ile karşılaştırma sonrasında favorilere ekleme")


    //@Test(priority = 5)
    public void basket() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BasketPage basketPage = new BasketPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        driver.navigate().refresh();

        String basketProductTypeValue = basketPage.getBasketProductType();
        String basketProductColorValue = basketPage.getBasketProductColor();
        Thread.sleep(200);
        String basketPriceValue = basketPage.getBasketPrice();
        Thread.sleep(200);
        String basketProductCountValue = basketPage.getBasketProductCount();
        Thread.sleep(1200);
        String basketTotalNumberValue = headerPage.getBasketTotalNumber();
        Thread.sleep(200);

        String productTypeValue = System.getProperty("productTypeValue");
        String productColorValue = System.getProperty("productColorValue");
        String productPriceValue = System.getProperty("productPriceValue");


        // Karşılaştırma
        if (productTypeValue.contains(basketProductTypeValue)) {
           System.out.println("Ürün tipi eşleşiyor: " + productTypeValue);
        } else {
           System.out.println("Ürün tipi eşleşmiyor. Sepette: " + basketProductTypeValue + ", Ürün sayfasında: " + productTypeValue);
       }


        if (basketProductColorValue.equals(productColorValue)) {
            System.out.println("Ürün rengi eşleşiyor: " + productColorValue);
        } else {
            System.out.println("Ürün rengi eşleşmiyor. Sepette: " + basketProductColorValue + ", Ürün sayfasında: " + productColorValue);
        }

        if (basketPriceValue.equals(productPriceValue)) {
            System.out.println("fiyat eşleşiyor: " + productPriceValue);
        } else {
            System.out.println("Fiyat eşleşmiyor. Sepette" + basketPriceValue + ", ürün sayfasında" + productPriceValue );
        }
        if (basketProductCountValue.equals(basketTotalNumberValue)) {
            System.out.println("adet eşleşiyor: " + basketProductCountValue);
        } else {
            System.out.println("adet eşleşmiyor " + basketTotalNumberValue + ", Sepette" + basketProductCountValue);
        }
        Thread.sleep(200);

        basketPage.addtoFavori();
        Thread.sleep(1100);
        headerPage.clickFavoriButton();
        Thread.sleep(500);


    }


}
