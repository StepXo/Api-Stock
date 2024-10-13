package com.BootcampPragma.Api_Stock.infrastructure.Utils;

public class InfraConstants {
    public static final String ZERO = "0 ";
    public static final String TEN = "10 ";
    public static final int SEVEN = 7;

    public static final String SPRING = "Spring";
    public static final String BEARER = "Bearer ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String MESSAGE = "Message";
    public static final String ARTICLE_CATEGORY = "article_category";
    public static final String ITEM_ID = "item_id";
    public static final String CATEGORY_ID = "category_id";
    public static final String BRAND_NAME = "brand";

    public static final String USER_API = "Api-User";
    public static final String ID = "/{id}";
    public static final String GET_ID = "/cart/{id}";
    public static final String BRAND = "/brand";
    public static final String CATEGORY = "/category";
    public static final String ITEM = "/item";
    public static final String ORDER = "/{order}";
    public static final String TYPE_ORDER = "/{order}/{variable}";
    public static final String SUPPLY = "/increase";
    public static final String CART = "/cart";

    public static final String HAS_WAREHOUSE_AUX_OR_ROLE_ADMIN = "hasRole('WAREHOUSE_AUX') or hasRole('ADMIN')";
    public static final String HAS_USER_OR_ROLE_ADMIN = "hasRole('USER') or hasRole('ADMIN')";
    public static final String HAS_ROLE_ADMIN = "hasRole('ADMIN')";

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_WAREHOUSE_AUX = "WAREHOUSE_AUX";
    public static final String BUY = "/buy" ;


    public static String getPath(String basePath, String path) {
        return basePath + path;
    }




    public InfraConstants() {
        throw new UnsupportedOperationException("This is a constants class and cannot be instantiated.");
    }
}
