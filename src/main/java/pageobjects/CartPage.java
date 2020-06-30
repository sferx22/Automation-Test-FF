package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Policy;

public class CartPage {

    private String productRowLocator = "//div[@id='content']//tr[contains(.,'<product>')]";
    private WebElement productRow;

    private By inputOnRowLocator = By.cssSelector("input");

    WebDriver driver;

    public CartPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void goTo(){
        MenuSuperior menu = new MenuSuperior(driver);
        menu.clickShoppingCart();
    }

    public boolean isProductOnCartByName(String name){
        productRow = driver.findElement(
                By.xpath(
                        productRowLocator.replace(
                                "<product>",
                                name)));
        return productRow.isDisplayed();
    }

    public int getAmountFromProductRow(){
        String sAmount = productRow.findElement(inputOnRowLocator).getAttribute("value");

        try {
            return Integer.parseInt(sAmount);
        }
        catch (NumberFormatException ex){
            System.out.println("Error al parsear el valor del campo");
            return 0;
        }
    }
}
