package test;

import com.github.javafaker.Faker;
import endpoints.ProductsEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.Product;

public class ProductTest {
    Faker faker;
    Product productPayload;

    @BeforeClass
    public Product setUp(){
        faker = new Faker();
        productPayload = new Product();
        productPayload.setId(faker.idNumber().hashCode());
        productPayload.setTitle(faker.commerce().productName());
        productPayload.setDescription(faker.lorem().sentence());
        productPayload.setPrice(faker.number().randomDouble(2, 10, 1000));
        productPayload.setDiscountPercentage(faker.number().randomDouble(2, 0, 50));
        productPayload.setRating(faker.number().randomDouble(1, 1, 5));
        productPayload.setStock(faker.number().numberBetween(10, 1000));
        productPayload.setBrand(faker.company().name());
        productPayload.setCategory(faker.commerce().department());
        productPayload.setThumbnail(faker.internet().image());
        int noOfElementsInImageArray = faker.number().numberBetween(1,5);
        String[] fakeArray = new String[noOfElementsInImageArray];

        for (int i = 0; i < noOfElementsInImageArray; i++) {
            fakeArray[i] = faker.internet().image();
        }
        productPayload.setImages(fakeArray);
        return productPayload;
    }

    @Test(priority = 1)
    public void testPostProduct(){

        Response response = ProductsEndPoints.createProduct(productPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
        System.out.println(productPayload.getId());
    }
    @Test(priority = 2)
    public void testGetProduct(){
        Response response = ProductsEndPoints.getProduct(this.productPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 3)
    public void testUpdateProduct(){
        //update data using payload
        productPayload.setTitle(faker.commerce().productName());
        productPayload.setDescription(faker.lorem().sentence());
        productPayload.setPrice(faker.number().randomDouble(2,100,1000));
        productPayload.setThumbnail(faker.internet().image());
        int no = faker.number().numberBetween(1,5);
        String [] fakeArray = new String[no];
        for (int i = 0; i < no; i++) {
            fakeArray[i] = faker.internet().image();
        }
        productPayload.setImages(fakeArray);
        Response response = ProductsEndPoints.updateProduct(this.productPayload.getId(), productPayload);
        response.then().log().all();

        System.out.println("The title is: "+(String) response.then().extract().path("title"));
        Assert.assertEquals(response.getStatusCode(), 200);

        /*
        verify the data get updated
        You can add more assertions here to verify updated values
        * */
        Response response1 = ProductsEndPoints.getProduct(this.productPayload.getId());
        Assert.assertEquals(productPayload.getTitle(), this.productPayload.getTitle());
    }
    @Test(priority = 4)
    public void testDeleteUser(){
        Response response = ProductsEndPoints.deleteProduct(this.productPayload.getId());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
