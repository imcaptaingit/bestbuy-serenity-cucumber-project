package com.bestbuy.constants;

/**
 * Created by Jay
 */
public class EndPoints {
    /**
     * This is the Endpoints of best-buy product api
     */
    public static final String GET_ALL_PRODUCT = "/products";
    public static final String CREATE_PRODUCT = "/products";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "products/{id}";
    public static final String UPDATE_PRODUCT_BY_ID = "products/{id}";
    public static final String DELETE_PRODUCT_BY_ID = "products/{id}";
    /**
     * This is the Endpoints of best-buy store api
     */
    public static final String GET_ALL_STORES = "/stores";
    public static final String CREATE_STORES = "/stores";
    public static final String GET_SINGLE_STORES_BY_ID = "stores/{id}";
    public static final String UPDATE_STORES_BY_ID = "stores/{id}";
    public static final String DELETE_STORES_BY_ID = "stores/{id}";
}
