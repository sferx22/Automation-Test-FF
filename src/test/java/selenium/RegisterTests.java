package selenium;

import dataproviders.RegisterProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.RegisterAccount;


public class RegisterTests extends BaseClass {

    @Description("Test that register feature works fine")
    @Test(description = "Test Register Success", dataProvider = "getUserDataFromJson", dataProviderClass = RegisterProvider.class)
    public void Test_Login_Successful(RegisterAccount registerAccount){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // go to login page
        headerPage().goToRegister();

        // enter information
        registerAccountPages().registerUser(registerAccount.getFirstName(), registerAccount.getLastName(),registerAccount.getTelephone(), registerAccount.getPassword(), registerAccount.getPasswordConfirm());

        wait.until(ExpectedConditions.elementToBeClickable(registerAccountPages().getAgreePrivacyPolicyCheckbox()));
        registerAccountPages().clickOnAgreePrivacyPolicy();
        wait.until(ExpectedConditions.elementToBeClickable(registerAccountPages().getSubmitButtonContinue()));
        registerAccountPages().clickSubmitButtonContinue();

        try{

            Assert.assertTrue(registerAccountPages().isAccountCreatedVisible(), "Error when the system created the account");
        }
        catch(Exception e){
            System.out.print("Error when the system created the account ");
        }
    }

}
