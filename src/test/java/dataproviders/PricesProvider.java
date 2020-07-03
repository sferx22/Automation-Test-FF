package dataproviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import pojo.PricesData;
import pojo.SearchData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class PricesProvider {
    @DataProvider(name = "getSearchData")
    private Object[][] getSearchData(){
        return new Object[][] {
                { new PricesData ("iPhone", 40, "123.20", "106.04", "92.93")},
                { new PricesData ("iMac", 41, "122.00", "105.01", "92.03")}
        };
    }

    @DataProvider(name = "getSearchDataFromJson")
    private Object[][] getSearchDataFromJson() throws FileNotFoundException {

        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/products.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<PricesData> testData = new Gson().fromJson(dataSet, new TypeToken<List<PricesData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
