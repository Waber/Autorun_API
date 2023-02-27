package core.apiService;

import core.config.Endpoints;
import core.constants.TestConstants;
import core.helpers.FileHelper;
import core.pojos.Items;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ItemsService {

    public Integer createItem(String bodyPath) {
        String body;
        body = FileHelper.readFile(TestConstants.JSONS_FOLDER + File.separator + bodyPath);
        Items items = given()
                .body(body)
                .when()
                .post(Endpoints.ITEMS)
                .then()
                .statusCode(201)
                .extract().as(Items.class);
        return items.getId();
    }

    public Items updateItem(int itemId, String bodyPath, int statusCode) {
        String body;
        body = FileHelper.readFile(TestConstants.JSONS_FOLDER + File.separator + bodyPath);
        return given()
                .pathParam("id", itemId)
                .body(body)
                .when()
                .put(Endpoints.ITEM)
                .then()
                .statusCode(statusCode)
                .extract().as(Items.class);
    }

    public Items getItem(int itemId, int statusCode) {
        return given()
                .pathParam("id", itemId)
                .when()
                .get(Endpoints.ITEM)
                .then()
                .statusCode(statusCode)
                .extract().as(Items.class);
    }

    public Integer deleteItem(int itemId) {
        return given()
                .pathParam("id", itemId)
                .when()
                .delete(Endpoints.ITEM)
                .then()
                .extract()
                .statusCode();
    }
}
