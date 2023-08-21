package endpoints;

public class Routes {

    public static String base_url = "http://localhost:3000";

    /*Products*/
    public static String postProductUrl = base_url+"/products";
    public static String getProductUrl = base_url+"/products/{id}";
    public static String updateProductUrl = base_url+"/products/{id}";
    public static String deleteProductUrl = base_url+"/products/{id}";

    /*Carts*/
    public static String postCartUrl = base_url+"/carts";
    public static String getCartUrl = base_url+"/carts/{id}";
    public static String updateCartUrl = base_url+"/carts/{id}";
    public static String deleteCartUrl = base_url+"/carts/{id}";

    /*Users*/
    public static String postUserUrl = base_url+"/users";
    public static String getUserUrl = base_url+"/users/{id}";
    public static String updateUserUrl = base_url+"/users/{id}";
    public static String deleteUserUrl = base_url+"/users/{id}";

    /*Posts*/
    public static String postPostUrl = base_url+"/posts";
    public static String getPostUrl = base_url+"/posts/{id}";
    public static String updatePostUrl = base_url+"/posts/{id}";
    public static String deletePostUrl = base_url+"/posts/{id}";
}
