package com.BootcampPragma.Api_Emazon.infrastructure.exeptionHandler;


public enum ExceptionResponse {
    NAME_IS_TOO_LONG("The description is too long for this request"),
    DESCRIPCION_IS_TOO_LONG("The description is too long for this request"),
    CATEGORIA_ALREADY_EXISTS("There is already a categoria with that name"),
    CATEGORIA_NOT_FOUND("No Categoria was found with that number"),
    DESCRIPCION_NOT_FOUND("No descripcion was found for a pokemon"),
    NO_DATA_FOUND("No data found for the requested petition"),
    MARCA_ALREADY_EXIST("There is already a marca with that name");


    private String message;

    ExceptionResponse(String message) {
            this.message = message;
        }
        public String getMessage() {
            return this.message;
        }

}
