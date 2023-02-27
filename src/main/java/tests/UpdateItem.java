package tests;

import core.config.TestBase;
import core.pojos.Items;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class UpdateItem extends TestBase {
    private Integer itemId;
    private Items item;
    private String updatedName = "updatedName";

    @BeforeClass(alwaysRun = true)
    public void initializeItem() {
        itemId = itemsService.createItem("createItem.json");
    }

    @Test(groups = {"items"})
    public void updateItem() {
        item = itemsService.updateItem(itemId, "updateItemBody.json", 200);
        assertThat(item.getName()).isEqualTo(updatedName);
        item = itemsService.getItem(itemId,200);
        assertThat(item.getName()).isEqualTo(updatedName);
    }

    @Test(groups = {"items"}, priority = 1)
    public void shouldNotUpdateItemThatDoesNotExist() {
        itemsService.updateItem(itemId, "updateItemBody.json", 404);
    }

    @AfterTest(alwaysRun = true)
    public void cleanup() {
        itemsService.deleteItem(itemId);
    }


}
