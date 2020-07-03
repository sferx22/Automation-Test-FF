package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(WebDriver _driver){
        super(_driver);
    }

    private static final String ERROR_WHEN_THERE_IS_NO_RESULTS = "There is no product that matches the search criteria.";

    //region Locators
    private By resultThumbs = By.cssSelector(".product-thumb");
    private By addToCart = By.cssSelector("div.button-group > button:nth-child(1) > span");
    private By alertSuccessAddToCart = By.xpath("//*[@id='product-search']/div[contains(., 'Success: You have added')]");
    private By totalShoppingCart = By.xpath("//*[@id='cart']/button");
    private By checkoutLink = By.xpath("//p[@class='text-right']//a[contains(., 'Checkout')]");
    private By alertCheckOut = By.cssSelector("div.alert.alert-danger.alert-dismissible");
    //endregion

    //region Getters
    public By getAddtoCart() {
        return addToCart;
    }

    public By getTotalshoppingCart() {
        return totalShoppingCart;
    }
    //endregion

    //region Actions
    public void clickAddtoCart()
    {
        driver.findElement(addToCart).click();
    }

    public int getThumbsCount(){
        return driver.findElements(resultThumbs).size();
    }

    public boolean isNoResultsVisible(){
        WebElement contentElement = driver.findElement(By.id("content"));
        return contentElement.getAttribute("innerHTML").contains(ERROR_WHEN_THERE_IS_NO_RESULTS);
    }

    public Boolean isSuccessAlertAddtoCard(String text){
        return driver.findElement(alertSuccessAddToCart)
                .getText()
                .contains(text);
    }

    public Boolean isSuccessCheckOut(){
        return driver.findElement(alertCheckOut)
                .getText()
                .contains("Products marked with *** are not available");
    }
    //endregion
}
