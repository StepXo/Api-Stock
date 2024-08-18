package com.BootcampPragma.Api_Emazon.infrastructure.exeptionHandler;


public enum ExceptionResponse {
    CATEGORY_ALREADY_EXISTS("There is already a category with that name"),
    MARCA_ALREADY_EXIST("There is already a marca with that name"),

    CATEGORY_NOT_FOUND("No category was found with that name"),
    MARCA_NOT_FOUND("No marca was found with that name"),
    ARTICLE_NOT_FOUND("No article was found with that name"),
    DESCRIPTION_NOT_FOUND("No description was found"),
    NO_DATA_FOUND("No data found for the requested petition"),

    NAME_IS_TOO_LONG("The description is too long for this request"),
    DESCRIPTION_IS_TOO_LONG("The description is too long for this request"),

    ;


    private String message;

    ExceptionResponse(String message) {
            this.message = message;
        }
        public String getMessage() {
            return this.message;
        }

}
