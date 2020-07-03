package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DataUtils;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver _driver)
    {
        super(_driver);
    }

    //region Locators
    private By productQuantityLocator = By.id("input-quantity");
    private By addToCartButtonLocator = By.id("button-cart");
    private By productPrice = By.cssSelector("li:nth-child(1) > h2");
    //endregion


    //region Getters and setters
    public WebElement getProductPrice()
    {
        return driver.findElement(productPrice);
    }
    //endregion

    //region Actions
    public void setAmountToAdd(int amount)
    {
       driver.findElement(productQuantityLocator).clear();
       driver.findElement(productQuantityLocator).sendKeys(String.valueOf(amount));
    }

    public void getUrl(int id)
    {
       driver.get("https://demo.opencart.com/index.php?route=product/product&product_id=" + id);
    }

    public void clickAddToCart()
    {
        driver.findElement(addToCartButtonLocator).click();
    }

    public boolean comparePrice (String price)
    {
       String pagePrice = DataUtils.getAmountFromCurrency(driver.findElement(productPrice).getText());
       System.out.print(pagePrice);
       return pagePrice.equals(price);
    }
    //endregion
}
