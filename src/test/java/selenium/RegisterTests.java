package selenium;

import dataproviders.RegisterProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.RegisterAccount;


public class RegisterTests extends BaseClass {

    @Description("Test that register feature works fine")
    @Test(description = "Test Register Success", dataProvider = "getUserDataFromJson", dataProviderClass = RegisterProvider.class)
    public void Test_Login_Successful(RegisterAccount registerAccount){

        // go to login page
        headerPage().goToRegister();

        // enter information
        registerAccountPages().registerUser(registerAccount.getFirstName(), registerAccount.getLastName(),registerAccount.getTelephone(), registerAccount.getPassword(), registerAccount.getPasswordConfirm());

        registerAccountPages().clickOnAgreePrivacyPolicy();
        registerAccountPages().clickSubmitButtonContinue();

        try{

            Assert.assertTrue(registerAccountPages().isAccountCreatedVisible(), "Error when the system created the account");
        }
        catch(Exception e){
            System.out.print("Error when the system created the account ");
        }
    }

}
