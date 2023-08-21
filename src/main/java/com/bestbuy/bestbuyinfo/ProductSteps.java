package com.bestbuy.bestbuyinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

/**
 * Author - Sarvat Shaikh
 * Project Name: bestbuy-serenity-cucumber-project
 */
public class ProductSteps {
    public ValidatableResponse createProduct(String name, String type, int price,
                                             int shipping, String upc, String description, String manufacturer, String model, String url, String image) {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(productPojo)
                .when()
                .post(EndPoints.CREATE_PRODUCT)
                .then().log().all();
    }

    public  ValidatableResponse getProductInfoById(int id){

        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Accept", "application/json")
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then().log().all();

    }

    public  ValidatableResponse getAllProductInfo(){

        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Accept", "application/json")
                .when()
                .get(EndPoints.GET_ALL_PRODUCT)
                .then().log().all();

    }

    public ValidatableResponse updateProduct(int id,String name, String type, int price,
                                             int shipping, String upc,String description,String manufacturer,String model,String url,String image) {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .header("Connection","keep-alive")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .pathParam("id",id)
                .body(productPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then().log().all();
    }

    public ValidatableResponse deleteProduct(int id){
        return SerenityRest.given().log().all()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }
}
