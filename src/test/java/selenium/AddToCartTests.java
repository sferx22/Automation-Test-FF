package selenium;

import dataproviders.PricesProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PricesData;


public class AddToCartTests extends BaseClass {

    @Description("Verify that add to cart works fine")
    @Test(description = "Add to Cart Test")
    public void testAddToCartSuccessful(){

         int testAmount = 2;

         String testProduct = homePage().selectFirstProductAndGetName();

         productPage().setAmountToAdd(testAmount);
         productPage().clickAddToCart();

         Assert.assertTrue(productPage().isSuccessMessageVisibleWithText(testProduct));

         cartPage().goTo();

        Assert.assertTrue(cartPage().isProductOnCartByName(testProduct));
        Assert.assertEquals(cartPage().getAmountFromProductRow(), testAmount);
    }

    @Description("Verify that prices on the shopping cart")
    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = PricesProvider.class)
    public void testVerifyPrices(PricesData pricesData){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        productPage().getUrl(pricesData.getId());
        Assert.assertTrue(headerPage().isVisibleUSDCurrency());
        headerPage().clickOnCurrencyButton();

        headerPage().selectCurrency("Dollar");
        wait.until(ExpectedConditions.textToBePresentInElement(productPage().getProductPrice(),"$"));
        Assert.assertTrue(productPage().comparePrice(pricesData.getUsd()));

        headerPage().selectCurrency("Euro");
        wait.until(ExpectedConditions.textToBePresentInElement(productPage().getProductPrice(),"€"));
        Assert.assertTrue(productPage().comparePrice(pricesData.getEur()));

        headerPage().selectCurrency("Libra");
        wait.until(ExpectedConditions.textToBePresentInElement(productPage().getProductPrice(),"£"));
        Assert.assertTrue(productPage().comparePrice(pricesData.getPnd()));

    }
}
