package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{

    private static final String ERROR_WHEN_THERE_IS_NO_RESULTS = "There is no product that matches the search criteria.";

    private By resultThumbs = By.cssSelector(".product-thumb");

    private By addtoCart = By.cssSelector("div.button-group > button:nth-child(1) > span");

    private By totalshoppingCart = By.id("cart-total");

    public void clickAddtoCart() {
        driver.findElement(addtoCart).click();
    }

    public void clickTotalShoppigCart() {
        driver.findElement(totalshoppingCart).click();
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



}
