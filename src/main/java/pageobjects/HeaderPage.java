package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage{

    public HeaderPage(WebDriver _driver){
        super(_driver);
    }

    //region Locators
    private By myAccountLinkLocator = By.xpath("//span[text()='My Account']");
    private By loginLocator = By.linkText("Login");
    private By logoutLocator = By.xpath("//a[text()='Logout']");
    private By searchField = By.name("search");
    private By registerLocator = By.linkText("Register");
    private By shoppingCart = By.xpath("//span[text()='Shopping Cart']");
    private By currencyButton = By.xpath("//span[contains(text(),'Currency')]");
    private By dolarCurrency = By.xpath("//button[contains(text(),'US Dollar')]");
    private By euroCurrency = By.xpath("//button[contains(text(),'€ Euro')]");
    private By libraCurrency = By.xpath("//button[contains(text(),'£ Pound Sterling')]");

    //endregion

    //region Getters
    public By getShoppingCart() {
        return shoppingCart;
    }
    //endregion

    //region Actions
    public void clickOnShoppingCart()
    {
        driver.findElement(shoppingCart).click();
    }

    public void clickOnCurrencyButton ()
    {
        driver.findElement(currencyButton).click();
    }

    public void selectCurrency(String currency)
    {
        if (currency == "Dollar"){
            driver.findElement(dolarCurrency).click();
        }
        else if (currency == "Euro"){
            driver.findElement(currencyButton).click();
            driver.findElement(euroCurrency).click();
        }
        else if (currency == "Libra"){
            driver.findElement(currencyButton).click();
            driver.findElement(libraCurrency).click();
        }
        else
        {
            driver.findElement(currencyButton).click();
            driver.findElement(dolarCurrency).click();
        }
    }

    public Boolean isVisibleUSDCurrency()
    {
        return driver.findElement(dolarCurrency).isEnabled();
    }


    public void clickOnMyAccount()
    {
        driver.findElement(myAccountLinkLocator).click();
    }

    public void clickOnLogin()
    {
        driver.findElement(loginLocator).click();
    }

    public void clickOnRegister()
    {
        driver.findElement(registerLocator).click();
    }

    public void goToLogin(){
        this.clickOnMyAccount();
        this.clickOnLogin();
    }

    public void goToRegister(){
        this.clickOnMyAccount();
        this.clickOnRegister();
    }

    public boolean isLogoutEnabled(){
        return driver.findElement(logoutLocator).isEnabled();
    }

    public WebElement logoutLink()
    {
        return driver.findElement(logoutLocator);
    }

    public void search(String searchCriteria)
    {
        WebElement searchBar = driver.findElement(searchField);

        searchBar.clear();
        searchBar.sendKeys(searchCriteria, Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(String.format("search=%s", searchCriteria)));
    }
    //endregion

}
