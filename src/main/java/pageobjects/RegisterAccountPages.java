package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import utils.DataUtils;

public class RegisterAccountPages extends BasePage{

    DataUtils dataUtils = new DataUtils();

    //region
    private By header = By.xpath("//*[@class=\"col-sm-9\"]/h1[contains(., 'Your Account Has Been Created!')]");

    private By firstNameField = By.id("input-firstname");

    private By lastNameField = By.id("input-lastname");

    private By emailField = By.id("input-email");

    private By telephoneField = By.id("input-telephone");

    private By passwordField = By.id("input-password");

    private By passwordConfirmField = By.id("input-confirm");

    private By subcriberadio = By.cssSelector("div.col-sm-10 > label:nth-child(1) > input[type=radio]");

    private By agreePrivacyPolicyCheckbox = By.xpath("//*[@class='pull-right']/input[@type='checkbox']");

    private By submitButtonContinue = By.cssSelector("div.buttons > div.pull-right > input.btn.btn-primary");

    //end region

    public void clickOnSubscribeRadio(){
        driver.findElement(subcriberadio).click();
    }
    public void clickOnAgreePrivacyPolicy(){
        driver.findElement(agreePrivacyPolicyCheckbox).click();
    }

    public void clickSubmitButtonContinue(){
        driver.findElement(submitButtonContinue).submit();
    }

    public RegisterAccountPages(WebDriver _driver){
        super(_driver);
    }

    public void enterEmail() throws WebDriverException{
        String email = dataUtils.getRandomEmail();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterFirstName(String firstName) throws WebDriverException{
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterTelephone(String telephone){
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void enterPassword(String password)throws WebDriverException{
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String passwordConfirm) throws WebDriverException
    {
        driver.findElement(passwordConfirmField).sendKeys(passwordConfirm);
    }

    public boolean isAccountCreatedVisible(){
        WebElement content = driver.findElement(By.xpath("//*[@class='col-sm-9']/h1[contains(., 'Your Account Has Been Created!')]"));
        return content.isDisplayed();
    }

    public void registerUser(String _firstName, String _lastName,String _telephone, String _password, String _passwordConfirm){
        this.enterFirstName(_firstName);
        this.enterLastName(_lastName);
        this.enterEmail();
        this.enterTelephone(_telephone);
        this.enterPassword(_password);
        this.enterConfirmPassword(_passwordConfirm);
    }
}
