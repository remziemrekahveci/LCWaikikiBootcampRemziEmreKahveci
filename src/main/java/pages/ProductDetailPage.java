package pages;

import org.openqa.selenium.*;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    private final WebDriver driver;
    private final By addtocardButtonLocator = By.xpath("//button[normalize-space()='SEPETE EKLE']");
    private final By productTypeLocator = By.cssSelector("#rightInfoBar > div:nth-child(1) > div > div.row.title-info > div.col-xs-7.col-sm-9 > h1");
    private final By productColorLocator = By.cssSelector("#rightInfoBar > div:nth-child(3) > div > div > a.color-option.active > label");
    private final By productPriceLocator = By.className("price-in-cart");



    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectAvailableSize() throws InterruptedException {
        // Tüm bedenleri içeren butonları bul
        List<WebElement> sizeButtons = driver.findElements(By.cssSelector("button.option-box"));

        for (WebElement button : sizeButtons) {
            // "out-of-stock" sınıfına sahip değilse bu beden kullanılabilir
            if (!button.getAttribute("class").contains("out-of-stock")) {
                System.out.println("Uygun beden seçildi: " + button.getText());
                // Stoktaki bedeni seçmek için tıkla
                button.click();
                Thread.sleep(2000); // Bekleme süresi
                return;
            }
        }

        System.out.println("No available sizes found.");
    }

    public void addtoCartButton() throws InterruptedException {
        driver.findElement(addtocardButtonLocator).click();

    }
    public String getProductType() {
        return driver.findElement(productTypeLocator).getText().trim();
    }

    public String getProductColor() {
        return driver.findElement(productColorLocator).getText().trim();
    }
    public String getProductPrice() {
        return driver.findElement(productPriceLocator).getText().trim();
    }
/*
    public String getProductType() {
        WebElement productTypeElement = driver.findElement(By.xpath("//b[text()='Ürün Tipi:']/following-sibling::p[1]"));
        return productTypeElement.getText().trim();
    }


 */




}
