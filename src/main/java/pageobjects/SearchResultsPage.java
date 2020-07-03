package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{

    private static final String ERROR_WHEN_THERE_IS_NO_RESULTS = "There is no product that matches the search criteria.";

    private By resultThumbs = By.cssSelector(".product-thumb");

    private By addtoCart = By.cssSelector("div.button-group > button:nth-child(1) > span");

    private By alertSuccessAddtoCart = By.xpath("//*[@id='product-search']/div[contains(., 'Success: You have added')]");

    private By totalshoppingCart = By.xpath("//*[@id='cart']/button");

    public By getAddtoCart() {
        return addtoCart;
    }

    public By getAlertSuccessAddtoCart() {
        return alertSuccessAddtoCart;
    }

    public By getTotalshoppingCart() {
        return totalshoppingCart;
    }

    public By getCheckoutlink() {
        return checkoutlink;
    }

    private By checkoutlink = By.xpath("//p[@class='text-right']//a[contains(., 'Checkout')]");

    private By alertCheckOut = By.cssSelector("div.alert.alert-danger.alert-dismissible");

    public void clickAddtoCart()
    {
        driver.findElement(addtoCart).click();
    }

    public SearchResultsPage(WebDriver _driver){
        super(_driver);
    }

    public int getThumbsCount(){
        return driver.findElements(resultThumbs).size();
    }

    public boolean isNoResultsVisible(){
        WebElement contentElement = driver.findElement(By.id("content"));
        return contentElement.getAttribute("innerHTML").contains(ERROR_WHEN_THERE_IS_NO_RESULTS);
    }

    public Boolean isSuccessAlertAddtoCard(String text){
        return driver.findElement(alertSuccessAddtoCart)
                .getText()
                .contains(text);
    }

    public Boolean isVisibleTotalCart(){
        return driver.findElement(totalshoppingCart)
                .isEnabled();
    }

    public Boolean isSuccessCheckOut(){
        return driver.findElement(alertCheckOut)
                .getText()
                .contains("Products marked with *** are not available");
    }
}
