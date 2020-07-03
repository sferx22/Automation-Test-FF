package selenium;

import dataproviders.SearchProvider;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

public class SearchTests extends BaseClass {

    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    @Parameters({"searchCriteria","expectedResults"})
    public void SearchTest(SearchData testSearchData){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        headerPage().search(testSearchData.getSearchCriteria());

        if (testSearchData.getExpectedResults() > 0) {

            int results = searchResultsPage().getThumbsCount();
            Assert.assertEquals(results, testSearchData.getExpectedResults(),
                    String.format("Was expecting %s, but got %s.", testSearchData.getExpectedResults(), results));
        }
        else
            Assert.assertTrue(searchResultsPage().isNoResultsVisible(), "Error message was not displayed");

        wait.until(ExpectedConditions.elementToBeClickable(searchResultsPage().getAddtoCart()));
        searchResultsPage().clickAddtoCart();

        Assert.assertTrue(searchResultsPage().isSuccessAlertAddtoCard("Success"));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultsPage().getTotalshoppingCart()));

        wait.until(ExpectedConditions.elementToBeClickable(headerPage().getShoppingCart()));
        headerPage().clickOnShoppingCart();
        Assert.assertTrue(searchResultsPage().isSuccessCheckOut());

    }
}