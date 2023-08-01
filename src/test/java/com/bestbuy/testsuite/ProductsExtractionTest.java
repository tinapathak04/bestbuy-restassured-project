package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

//    21. Extract the limit
    @Test
    public void test21(){
        int limit =  response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit );
        System.out.println("------------------End of Test---------------------------");
    }

//    22. Extract the total
    @Test
    public void test22(){
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total );
        System.out.println("------------------End of Test---------------------------");
    }

//    23. Extract the name of 5th product
    @Test
    public void test23(){
        String nameOfProduct = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of product is : " + nameOfProduct );
        System.out.println("------------------End of Test---------------------------");

    }

//    24. Extract the names of all the products
    @Test
    public void test24(){
        List<String> nameOfProducts = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all product are : " + nameOfProducts );
        System.out.println("------------------End of Test---------------------------");
    }

//    25. Extract the productId of all the products
    @Test
    public void test25(){
        List<String> idOfProducts = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all product are : " + idOfProducts );
        System.out.println("------------------End of Test---------------------------");
    }

//    26. Print the size of the data list
    @Test
    public void test26(){
        List<String> listOfData = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of all data are : " + listOfData );
        System.out.println("------------------End of Test---------------------------");
    }

//    27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test27(){
        List<HashMap<String,?>> productValue = response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product value is : " + productValue);
        System.out.println("------------------End of Test---------------------------");

    }

//    28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test28(){
        String productModel = response.extract().path("data[8].model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The model of product is : " + productModel);
        System.out.println("------------------End of Test---------------------------");

    }

//    29. Get all the categories of 8th products
    @Test
    public void test29(){
        List<String> allCategories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of product is : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }

//    30. Get categories of the store where product id = 150115
    @Test
    public void test30(){
        List<String> categoriesOfProduct = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of product is : " + categoriesOfProduct );
        System.out.println("------------------End of Test---------------------------");
    }

//    31. Get all the descriptions of all the products
    @Test
    public void test31(){
        List<String>descriptionsOfAllProduct = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all product are : " +descriptionsOfAllProduct);
        System.out.println("------------------End of Test---------------------------");

    }

//    32. Get id of all the all categories of all the products
    @Test
    public void test32(){
        List<String>idOfAllProduct = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Theid of all categories of all product are : " + idOfAllProduct);
        System.out.println("------------------End of Test---------------------------");
    }

//    33. Find the product names Where type = HardGood
    @Test
    public void test33(){
        List<HashMap<String,?>> productNamesOfType = response.extract().path("data.findAll{it.type =='HardGood'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product type is : " +productNamesOfType);
        System.out.println("------------------End of Test---------------------------");

    }

//    34. Find the Total number of categories for the product where product name = Duracell - AA1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test34(){
        List<String> totalNumberOfCategories = response.extract().path("data[1].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number is : " +totalNumberOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }

//    35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test35(){
        List<String>price = response.extract().path("data.findAll{it.price < 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createAt of all products price are: " + price);
        System.out.println("------------------End of Test---------------------------");
    }

//    36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test36(){
        List<String> nameOfCategories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name of categories are : " +nameOfCategories);
        System.out.println("------------------End of Test---------------------------");

    }

//    37. Find the manufacturer of all the products
    @Test
    public void test37(){
        List<String>manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all products are: " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }


//    38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test38(){
        List<HashMap<String, ?>>productImage =response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of product whose manufacturer 'Energizer' is : " + productImage);
        System.out.println("------------------End of Test---------------------------");

    }

//    39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test39(){
        List<String>priceOfProduct = response.extract().path("data.findAll{it.price > 5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createAt of all products price are: " + priceOfProduct);
        System.out.println("------------------End of Test---------------------------");
    }

//    40. Find the uri of all the products
    @Test
    public void test40(){
        List<String>uri = response.extract().path("data.uri");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The uri of all products are: " + uri);
        System.out.println("------------------End of Test---------------------------");
    }
}
