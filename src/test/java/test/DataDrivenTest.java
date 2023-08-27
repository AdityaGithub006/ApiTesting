package test;

import com.github.javafaker.Faker;
import endpoints.ProductsEndPoints;
import io.restassured.response.Response;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payload.Product;
import utilities.DataProviders;

import java.net.ConnectException;

public class DataDrivenTest {
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostProducts(String id, String title, String description, String price, String discountPercentage, String rating, String stock, String brand, String category, String thumbnail, String[] images) {
        Product productPayload = new Product();
        productPayload.setId(Long.parseLong(id));
        productPayload.setTitle(title);
        productPayload.setDescription(description);
        productPayload.setPrice(Double.parseDouble(price));
        productPayload.setDiscountPercentage(Double.parseDouble(discountPercentage));
        productPayload.setRating(Double.parseDouble(rating));
        productPayload.setStock(Integer.parseInt(stock));
        productPayload.setBrand(brand);
        productPayload.setCategory(category);
        productPayload.setThumbnail(thumbnail);
        productPayload.setImages(images);

        Response response = ProductsEndPoints.createProduct(productPayload);

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 2, dataProvider = "Ids", dataProviderClass = DataProviders.class)
    public void testGetProductDetailsById(String id) {
        Response response = ProductsEndPoints.getProduct(Long.parseLong(id));
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3, dataProvider = "Ids", dataProviderClass = DataProviders.class)
    public void testDeleteProductById(String id) throws InterruptedException {
        int retry = 0;
        int maxRetry = 3;
        while (retry<maxRetry){
            try {
                Response response = ProductsEndPoints.deleteProduct(Long.parseLong(id));
                Assert.assertEquals(response.getStatusCode(), 200);
                break;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                retry++;
                Thread.sleep(1000);
            }
            if (retry>=maxRetry){
                System.err.println("Unable to delete product after multiple retries");
            }
        }
    }
}
