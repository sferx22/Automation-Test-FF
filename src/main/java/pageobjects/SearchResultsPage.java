package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchResultsPage extends BasePage{

    private static final String ERROR_WHEN_THERE_IS_NO_RESULTS = "There is no product that matches the search criteria.";

    private By resultThumbs = By.cssSelector(".product-thumb");

    private By addtoCart = By.cssSelector("div.button-group > button:nth-child(1) > span");

    private By alertSuccessAddtoCart = By.xpath("//*[@id='product-search']/div[contains(., 'Success: You have added')]");

    private By totalshoppingCart = By.xpath("//*[@id='cart']/button");

    private By checkoutlink = By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(2)");

    private By alertCheckOut = By.cssSelector("#checkout-cart > div.alert.alert-danger.alert-dismissible");

    public void clickAddtoCart()
    {
        driver.findElement(addtoCart).click();
    }

    public void clickTotalShoppigCart() {
        driver.findElement(totalshoppingCart).click();
    }

    public void clickCheckouttoCart() {
        driver.findElement(checkoutlink).click();
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
                .contains("Products marked with *** are not available in the desired quantity or not in stock!");
    }





}
