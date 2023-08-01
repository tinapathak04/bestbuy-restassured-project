package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

//    1. Extract the limit
    @Test
    public void test01(){
        int limit =  response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit );
        System.out.println("------------------End of Test---------------------------");
    }

//    2. Extract the total
    @Test
    public void test02(){
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total );
        System.out.println("------------------End of Test---------------------------");
    }

//    3. Extract the name of 5th store
    @Test
    public void test03(){
        String storeName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of storeName is : " + storeName  );
        System.out.println("------------------End of Test---------------------------");
    }

//    4. Extract the names of all the store
    @Test
    public void test04(){
    List<String>allStoreName = response.extract().path("data.name");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of allStore Name are : " + allStoreName  );
    System.out.println("------------------End of Test---------------------------");
}

//    5. Extract the storeId of all the store
    @Test
    public void test05() {

    List<Integer>listsOfIds = response.extract().path("data.id");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("List of Ids are : " + listsOfIds);
    System.out.println("------------------End of Test---------------------------");

}

//    6. Print the size of the data list
    @Test
    public void test06(){
        List<String>dataList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of data are : " + dataList);
        System.out.println("------------------End of Test---------------------------");

    }

//    7. Get all the value of the store where store name = St Cloud
    @Test
    public void test07(){
        List<HashMap<String,?>> allValueOfSTCloud = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of value : " + allValueOfSTCloud);
        System.out.println("------------------End of Test---------------------------");

    }

//    8. Get the address of the store where store name = Rochester
    @Test
    public void test08(){
        String address = response.extract().path("data[8].address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of address are : " + address);
        System.out.println("------------------End of Test---------------------------");

    }

//    9. Get all the services of 8th store
    @Test
    public void test09(){
        List<HashMap<String,?>> allServices = response.extract().path("data.findAll{it.name=='Oakdale'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of service are : " + allServices);
        System.out.println("------------------End of Test---------------------------");

    }

//    10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test10(){
        List<HashMap<String,?>> services = response.extract().path("data.findAll{it.name == 'Windows Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store services are : " + services);
        System.out.println("------------------End of Test---------------------------");


    }

//    11. Get all the storeId of all the store
    @Test
    public void test11(){
        List<HashMap<String,?>> storeId = response.extract().path("data.findAll{it.name =='storeId'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Store Ids are : " + storeId);
        System.out.println("------------------End of Test---------------------------");

    }

//    12. Get id of all the store
    @Test
    public void test12(){
        List<HashMap<String,?>> Id = response.extract().path("data.findAll{it.id}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids for all store are : " + Id);
        System.out.println("------------------End of Test---------------------------");

    }

//    13. Find the store names Where state = ND
    @Test
    public void test13(){
        String storeName = response.extract().path("data[7].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("store name is  : " + storeName);
        System.out.println("------------------End of Test---------------------------");


    }

//    14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14(){
        List<String> totalNumber = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services is  : " + totalNumber);
        System.out.println("------------------End of Test---------------------------");

    }

//    15. Find the createdAt for all services whose name = "Windows Store”
    @Test
    public void test15(){
        List<HashMap<String,?>> createdAtServices = response.extract().path("data.findAll{it.createdAt == 'Windows Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("createAt services of  : " + createdAtServices);
        System.out.println("------------------End of Test---------------------------");

    }

//    16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16(){
        List<HashMap<String,?>> storeServices = response.extract().path("data.findAll{it.name == 'Fargo'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store services are : " + storeServices);
        System.out.println("------------------End of Test---------------------------");

    }

//    17. Find the zip of all the store
    @Test
    public void test17(){
        List<String> zipForAll = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of zip are : " + zipForAll);
        System.out.println("------------------End of Test---------------------------");
    }

//    18. Find the zip of store name = Roseville
    @Test
    public void test18(){
        String zipOfRoseville = response.extract().path("data[2].zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Roseville of zip : " + zipOfRoseville);
        System.out.println("------------------End of Test---------------------------");


    }

//    19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19(){
        List<HashMap<String,?>> servicesOfMagnoliaHomeTheater = response.extract().path("data.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Magnolia Home Theater of storeServices : " + servicesOfMagnoliaHomeTheater);
        System.out.println("------------------End of Test---------------------------");

    }

//    20. Find the lat of all the stores
    @Test
    public void test20(){
        List<String> latForAll = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of lat are : " + latForAll);
        System.out.println("------------------End of Test---------------------------");
    }

}
