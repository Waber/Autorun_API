package tests;

import core.config.TestBase;
import core.pojos.Items;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GetItem extends TestBase {
    private Integer itemId;
    private Items item;
    private Integer departmentId = 3;
    private boolean verified = true;
    private String name = "item1";
    private List<String> locale = Stream.of("en","de").collect(Collectors.toList());

    @BeforeClass(alwaysRun = true)
    public void initializeItem() {
        itemId = itemsService.createItem("createItem.json");
    }

    @Test(groups = {"items"})
    public void getItem(){
        item = itemsService.getItem(itemId,200);
        assertThat(item.getId()).isEqualTo(itemId);
        assertThat(item.getDepartmentId()).isEqualTo(departmentId);
        assertThat(item.getIsVerified()).isEqualTo(verified);
        assertThat(item.getName()).isEqualTo(name);
        assertThat(item.getLocale()).hasSameElementsAs(locale);
    }

    @Test(groups = {"items"}, priority = 1)
    public void getItemThatDoesntExist(){
        itemsService.getItem(itemId, 404);
    }

    @AfterTest(alwaysRun = true)
    public void cleanup() {
        itemsService.deleteItem(itemId);
    }


}
