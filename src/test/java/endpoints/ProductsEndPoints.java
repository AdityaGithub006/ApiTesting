package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Product;

import static io.restassured.RestAssured.*;

public class ProductsEndPoints {

    public static Response createProduct(Product payload) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postProductUrl);

        return response;
    }

    public static Response getProduct(long id) {
        Response response = given()
                .pathParam("id", id)
                .when()
                .get(Routes.getProductUrl);

        return response;
    }

    public static Response updateProduct(long id, Product payload) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(payload)
                .when()
                .put(Routes.updateProductUrl);

        return response;
    }
    public static Response deleteProduct(long id) {
        Response response = given()
                .pathParam("id", id)
                .when()
                .delete(Routes.deleteProductUrl);

        return response;
    }
}
