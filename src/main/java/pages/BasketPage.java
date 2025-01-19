package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasketPage extends BasePage {
    private final By addtoFavoriLocator = By.xpath("//i[@class='fa fa-heart-o']");
    private final By basketProductTypeLocator = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.sellerProductArea.seller1 > div.seller-products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-8.col-xs-9.pr-0.text-left.d-flex > div.rd-cart-item-main-info.pl-15 > span.rd-cart-item-code");
    private final By basketProductColorLocator = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.sellerProductArea.seller1 > div.seller-products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-8.col-xs-9.pr-0.text-left.d-flex > div.rd-cart-item-main-info.pl-15 > div.rd-cart-item-bottom > span.rd-cart-item-color > strong");
     private final By basketProductCountLocator = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.sellerProductArea.seller1 > div.seller-products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-8.col-xs-9.pr-0.text-left.d-flex > div.rd-cart-item-main-info.pl-15 > div.rd-cart-item-quantity-area > div > input");
    private final By basketPriceLocator = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.sellerProductArea.seller1 > div.seller-products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-4.col-xs-3.text-right.sc-option-detail.pl-0 > span.rd-cart-item-price.mb-15");
    private final WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addtoFavori(){
        driver.findElement(addtoFavoriLocator).click();
    }

    public String getBasketProductType() {
        return driver.findElement(basketProductTypeLocator).getText().trim();
    }

    public String getBasketProductColor() {
        return driver.findElement(basketProductColorLocator).getText().trim();
    }
    public String getBasketPrice() {
        return driver.findElement(basketPriceLocator).getText().trim();
    }

    public String getBasketProductCount() {
        WebElement basketProductCountt = driver.findElement(basketProductCountLocator);
        return basketProductCountt.getAttribute("value");
    }



/*
    public String getCartProductType() {
        WebElement cartProductTypeElement = driver.findElement(By.cssSelector(".rd-cart-item-code"));
        return cartProductTypeElement.getText().trim();
    }

 */


}
