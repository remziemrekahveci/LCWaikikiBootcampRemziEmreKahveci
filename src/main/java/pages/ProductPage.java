package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductPage extends BasePage {



    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ageFilterChoice(String ageText) throws InterruptedException {
        Actions actions = new Actions(driver);
        // Yaş seçeneklerini içeren tüm öğeleri buluyoruz
        List<WebElement> ageList = driver.findElements(By.cssSelector("div.filter-option"));

        // Yaşları döngüye sokarak verilen metinle karşılaştırıyoruz
        for (WebElement ageElement : ageList) {
            WebElement ageTextElement = ageElement.findElement(By.cssSelector(".filter-option__text"));

            // Yaş metni ile karşılaştırıyoruz
            if (ageTextElement.getText().equalsIgnoreCase(ageText)) {
                // Yaş metnini bulduğumuzda, checkbox'ı tıklıyoruz
                WebElement checkbox = ageElement.findElement(By.cssSelector(".lcw-checkbox__checkbox"));
                actions.moveToElement(ageTextElement).perform();
                System.out.println("Yaş filtresi seçildi: " + ageTextElement.getText());
                checkbox.click();
                break;
            }

        }
        Thread.sleep(2000);
    }


    public void renkFilterChoice(String renkText) throws InterruptedException {
        // Renk seçeneklerini içeren tüm öğeler
        List<WebElement> renkList = driver.findElements(By.cssSelector("span.color-filter-option__text"));


        // Renk listesi üzerinde gezin
        Actions actions = new Actions(driver);
        for (WebElement renkElement : renkList) {
            if (renkElement.getText().equalsIgnoreCase(renkText)) {
                // İlgili rengi görünür hale getirmek için üzerine hareket et
                actions.moveToElement(renkElement).perform();
                Thread.sleep(1000); // Kısa bir bekleme eklenebilir
                System.out.println("Renk Filtresi seçildi: " + renkElement.getText());

                // Rengi tıklayarak seç
                renkElement.click();
                break; // İlgili rengi seçtikten sonra döngüden çık
            }
        }
        Thread.sleep(3000);
    }

    public void chooseSortingOptions(String sortingOption) throws InterruptedException {
        By dropdownButtonLocator = By.xpath("//button[@class='dropdown-button__button']");
        WebElement dropdownButton = driver.findElement(dropdownButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", dropdownButton);
        dropdownButton.click();
       // hata fix için koydum
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input-field__search-input']"));
        Actions actions = new Actions(driver);
        searchInput.click(); // debugging
        dropdownButton.click();
        WebElement encoksatan = driver.findElement(By.cssSelector("div[class='container-fluid desktop-list-options-bar'] a:nth-child(5)"));
        encoksatan.click();
        Thread.sleep(500);

    }
    public void selectNthProduct(int productIndex) throws InterruptedException {
        // Ürün card bul ve product list ata
        List<WebElement> productList = driver.findElements(By.cssSelector("div.product-card"));

        // Seçilen ürün indeksi kontrolü
        if (productIndex > 0 && productIndex <= productList.size()) {
            WebElement selectedProduct = productList.get(productIndex - 1); // Listeler sıfırdan başladığı için -1  böylelikle verilen numaradaki ürüne tıklayacak
            Actions actions = new Actions(driver);


            // Ürüne scroll yap ve tıkla
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedProduct);
            Thread.sleep(1000); // Görünür hale geldikten sonra kısa bir bekleme
            actions.moveToElement(selectedProduct).perform();

            selectedProduct.click();
            System.out.println("Seçilen ürün: " + productIndex);
        } else {
            System.out.println("Geçersiz ürün indeksi: " + productIndex);
        }
    }



}

