package test;

import endpoints.ProductsEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payload.Product;
import utilities.DataProviders;

public class DataDrivenTest {
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostProducts(long id, String title, String description, double price, double discountPercentage, double rating, int stock, String brand, String category, String thumbnail, String[] images){
        Product productPayload = new Product();
        productPayload.setId(id);
        productPayload.setTitle(title);
        productPayload.setDescription(description);
        productPayload.setPrice(price);
        productPayload.setDiscountPercentage(discountPercentage);
        productPayload.setRating(rating);
        productPayload.setStock(stock);
        productPayload.setBrand(brand);
        productPayload.setCategory(category);
        productPayload.setThumbnail(thumbnail);
        productPayload.setImages(images);

        Response response = ProductsEndPoints.createProduct(productPayload);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2, dataProvider = "Ids", dataProviderClass = DataProviders.class)
    public void testGetProductDetailsById(long id){
        Response response = ProductsEndPoints.deleteProduct(id);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 3, dataProvider = "Ids", dataProviderClass = DataProvider.class)
    public void testDeleteProductById(long id){
        Response response = ProductsEndPoints.deleteProduct(id);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
