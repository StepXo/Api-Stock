package com.BootcampPragma.Api_Emazon.infrastructure.exeptionHandler;


public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("There is already a category with that name"),
    MARCA_ALREADY_EXIST("There is already a marca with that name"),
    ITEM_ALREADY_EXIST("There is already a item with that name"),
    CATEGORY_LIST_DUPLICATE("Category list has duplicate elements"),

    CATEGORY_NOT_FOUND("No category was found with that name"),
    MARCA_NOT_FOUND("No brand was found with that name"),
    ITEM_NOT_FOUND("No item was found with that name"),
    DESCRIPTION_NOT_FOUND("No description was found"),
    NO_DATA_FOUND("No data found for the requested petition"),

    NAME_IS_TOO_LONG("The description is too long for this request"),
    DESCRIPTION_IS_TOO_LONG("The description is too long for this request"),
    CATEGORY_SIZE_LIST("The article must have 1 to 3 categories"),
    ;


    private String message;

    ExceptionResponse(String message) {
            this.message = message;
        }
        public String getMessage() {
            return this.message;
        }

}
