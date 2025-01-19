package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HeaderPage extends BasePage {



    private final By searchBoxLocator = By.id("search-form__input-field__search-input"); //belki lazım olur diye ekledim.
    private final By basketTotalNumberLocator = By.className("badge-circle");
    private final By FavoriLocator = By.xpath("//span[normalize-space()='Favorilerim']");
    private final By basketButtonLocator = By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@id='header__container']/header[@class='header header--high']/div[@class='header__middle']/div[@class='header__middle__right']/div[@class='header-section']/div[2]/a[1]//*[name()='svg']");
    private final By cookiesrejectLocator = By.xpath("//*[@id=\"cookieseal-banner-reject\"]");
    public HeaderPage(WebDriver driver) {
        super();
        BasePage.driver = driver;

    }
    public void search() {
        //spesifik olarak arama yapmaması için statik değil dinamik yapıda oluşturuldu.
        driver.findElement(searchBoxLocator).click();

    }
    public void searchfromword(String word) {
        //spesifik olarak arama yapmaması için statik değil dinamik yapıda oluşturuldu.
        driver.findElement(searchBoxLocator).sendKeys(word);

    }
    public String getBasketTotalNumber() {
        //string ifadesi döndürür methodu çağıran fonksiyona Number string olarak döner.
        return driver.findElement(basketTotalNumberLocator).getText().trim();
    }
    public void clickrejectcookies() {
        driver.findElement(cookiesrejectLocator).click();
    }

    // Üst menü elemanlarını tıklayan bir metot
    public void clickUstMenuItem(String hedefMetin) {
        // Üst menüdeki tüm elemanları listeye al
        List<WebElement> ustMenu = driver.findElements(By.cssSelector("ul.menu-nav__lists > li.menu-header-item"));

        // Döngüyle her bir elemanı kontrol et
        for (WebElement element : ustMenu) {
            // Elemanın görünen metni ile hedef metni karşılaştır
            if (element.getText().equalsIgnoreCase(hedefMetin)) {
                // Elemanı tıkla
                element.click();
                System.out.println("Eleman tıklandı: " + element.getText());
                break; // Eleman tıklandığında döngüyü sonlandır
            }
        }
    }
    // sepetim butonuna tıklar. sepetim sayfasına gider.
    public void clickBasketButton() {
        driver.findElement(basketButtonLocator).click();
    }
    public void clickFavoriButton() {
        driver.findElement(FavoriLocator).click();
    }


    // Üst menü ve alt menü elemanlarının üzerine hover yapan metot
    public void hoverOverSubMenuItem(String ustMenuMetni, String altMenuMetni) {
        // Üst menüdeki tüm elemanları listeye al
        List<WebElement> ustMenu = driver.findElements(By.cssSelector("ul.menu-nav__lists > li.menu-header-item"));

        // Actions sınıfını başlat
        Actions actions = new Actions(driver);

        // Üst menüdeki hedef elemanın üzerine hover yap
        for (WebElement ustMenuElement : ustMenu) {
            if (ustMenuElement.getText().equalsIgnoreCase(ustMenuMetni)) { // Üst menüdeki hedef metni bul
                actions.moveToElement(ustMenuElement).perform();
                System.out.println("Hover işlemi yapıldı: " + ustMenuElement.getText());

                // Açılan dropdown menüdeki alt menü elemanlarını bul
                List<WebElement> altMenu = ustMenuElement.findElements(By.cssSelector("div.mega-menu.mega-menu--hovered .tab-header__text"));

                // Alt menüdeki hedef elemanın üzerine hover yap
                for (WebElement altMenuElement : altMenu) {
                    if (altMenuElement.getText().equalsIgnoreCase(altMenuMetni)) { // Alt menüdeki hedef metni bul
                        actions.moveToElement(altMenuElement).perform();
                        System.out.println("Alt menü hover işlemi yapıldı: " + altMenuElement.getText());
                        break; // İşlem tamamlanınca döngüyü sonlandır
                    }
                }
                break; // Üst menüde hedef eleman bulunduğunda döngüyü sonlandır
            }
        }
    }
    public void hoverOnMenu(String ustMenuMetni, String altMenuMetni) {
        Actions actions = new Actions(driver);

        // Üst menüdeki tüm elemanları bul
        List<WebElement> ustMenu = driver.findElements(By.cssSelector("ul.menu-nav__lists > li.menu-header-item"));

        for (WebElement ustMenuElement : ustMenu) {
            if (ustMenuElement.getText().equalsIgnoreCase(ustMenuMetni)) { // Üst menüdeki hedef metni bul
                actions.moveToElement(ustMenuElement).perform();
                System.out.println("Üst menü Hover işlemi yapıldı: " + ustMenuElement.getText());

                // Açılan dropdown menüdeki alt menü elemanlarını bul
                List<WebElement> altMenu = ustMenuElement.findElements(By.cssSelector("div.mega-menu.mega-menu--hovered .tab-header__text")); // 3 parça

                // Alt menüdeki hedef elemanın üzerine hover yap
                for (WebElement altMenuElement : altMenu) {
                    if (altMenuElement.getText().equalsIgnoreCase(altMenuMetni)) { // Alt menüdeki hedef metni bul
                        actions.moveToElement(altMenuElement).perform();
                        System.out.println("Alt menü hover işlemi yapıldı: " + altMenuElement.getText());
                        break; // İşlem tamamlanınca döngüyü sonlandır
                    }
                }
                break; // Üst menüde hedef eleman bulunduğunda döngüyü sonlandır
            }
        }
    }
    public void clickOnContent(String contentMetni) {
        Actions actions = new Actions(driver);
        List<WebElement> contentMenu = driver.findElements(By.cssSelector("div.mega-menu.mega-menu--hovered .zone-item__anchor"));

        for (WebElement contentMenuElement : contentMenu) {
            if (contentMenuElement.getText().equalsIgnoreCase(contentMetni)) {
                actions.moveToElement(contentMenuElement).perform();
                System.out.println("Content click işlemi yapıldı: " + contentMenuElement.getText());
                contentMenuElement.click();
                break;

            }

        }

    }



}

