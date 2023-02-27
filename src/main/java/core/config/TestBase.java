package core.config;

import core.apiService.ItemsService;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public ItemsService itemsService;

    public TestBase(){
        itemsService = new ItemsService();
    }

    @BeforeSuite(alwaysRun = true)
    public void baseConfiguration(){
        RestAssuredConfiguration.baseSetup();
    }
}
