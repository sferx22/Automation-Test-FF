package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class LoginPage extends BasePage{

    private By firstNameField = By.id("input-firstname");
    private By emailFieldLocator = By.name("email");
    private By passwordFieldLocator = By.name("password");
    private By loginButton = By.cssSelector("[value='Login']");

    public LoginPage(WebDriver _driver){
        super(_driver);
    }

    public void enterEmail(String email) throws WebDriverException{
        driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public void enterFirstName(String firstName) throws WebDriverException{
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterPassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void loginWithCredentials(String _firstName, String _email, String _password){
        this.enterFirstName(_firstName);
        this.enterEmail(_email);
        this.enterPassword(_password);
        this.clickLogin();
    }

}
