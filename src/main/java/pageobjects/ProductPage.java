package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DataUtils;

public class ProductPage extends BasePage{

    private By productQuantityLocator = By.id("input-quantity");
    private By addToCartButtonLocator = By.id("button-cart");
    private By productPrice = By.cssSelector("li:nth-child(1) > h2");


    public ProductPage(WebDriver _driver){
        super(_driver);
    }

   public void setAmountToAdd(int amount){
       driver.findElement(productQuantityLocator).clear();
       driver.findElement(productQuantityLocator).sendKeys(String.valueOf(amount));
   }

   public void getUrl(int id){
       driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=" + id);
   }

   public WebElement getProductPrice(){
       return driver.findElement(productPrice);
   }

   public void clickAddToCart(){
        driver.findElement(addToCartButtonLocator).click();
   }

   public boolean comparePrice (String price){
       String pagePrice = DataUtils.getAmountFromCurrency(driver.findElement(productPrice).getText());
       System.out.print(pagePrice);
       return pagePrice.equals(price);

   }



}
