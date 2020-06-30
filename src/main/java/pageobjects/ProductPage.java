package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private By productQuantityLocator = By.id("input-quantity");
    private By addToCartButtonLocator = By.id("button-cart");

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

   public void setAmountToAdd(int amount){
       driver.findElement(productQuantityLocator).clear();
       driver.findElement(productQuantityLocator).sendKeys(String.valueOf(amount));
   }

   public void clickAddToCart(){
        driver.findElement(addToCartButtonLocator).click();
   }



}
