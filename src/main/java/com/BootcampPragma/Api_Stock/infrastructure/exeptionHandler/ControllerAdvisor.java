package com.BootcampPragma.Api_Stock.infrastructure.exeptionHandler;

import com.BootcampPragma.Api_Stock.domain.exeption.*;
import com.BootcampPragma.Api_Stock.infrastructure.Utils.InfraConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    //AlreadyExist
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistsException(
            CategoryAlreadyExistsException categoryAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.CATEGORY_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleMarcaAlreadyExistsException(
            BrandAlreadyExistsException brandAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.MARCA_ALREADY_EXIST.getMessage()));
    }
    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleItemAlreadyExistsException(
            ItemAlreadyExistsException itemAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.ITEM_ALREADY_EXIST.getMessage()));
    }
    @ExceptionHandler(CategoryListDuplicateExeption.class)
    public ResponseEntity<Map<String, String>> categoryListDuplicateExeption(
            CategoryListDuplicateExeption categoryListDuplicateExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.CATEGORY_LIST_DUPLICATE.getMessage()));
    }
    @ExceptionHandler(ActualizationItemExeption.class)
    public ResponseEntity<Map<String, String>> actualizationItemExeption(
            ActualizationItemExeption actualizationItemExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.ACTUALIZATION_ITEM.getMessage()));
    }

    //NotFound
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(DescriptionNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDescriptionNotFoundException(
            DescriptionNotFoundException descriptionNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.DESCRIPTION_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNameNotFoundException(
            NameNotFoundException nameNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.NAME_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.CATEGORY_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMarcaNotFoundException(
            BrandNotFoundException brandNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.MARCA_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleItemNotFoundException(
            ItemNotFoundException itemNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.ITEM_NOT_FOUND.getMessage()));
    }

    //TooLong
    @ExceptionHandler(DescriptionIsTooLongException.class)
    public ResponseEntity<Map<String, String>> handleDescriptionIsTooLongExeption(
            DescriptionIsTooLongException descriptionIsTooLongExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.DESCRIPTION_IS_TOO_LONG.getMessage()));
    }
    @ExceptionHandler(NameIsTooLongException.class)
    public ResponseEntity<Map<String, String>> handleNameIsTooLongExeption(
            NameIsTooLongException nameIsTooLongExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.NAME_IS_TOO_LONG.getMessage()));
    }
    @ExceptionHandler(CategoryListSizeException.class)
    public ResponseEntity<Map<String, String>> categoryListSizeException(
            CategoryListSizeException categoryListSizeException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.CATEGORY_SIZE_LIST.getMessage()));
    }
    @ExceptionHandler(QuantityIsNotEnough.class)
    public ResponseEntity<Map<String, String>> quantityIsNotEnough(
            QuantityIsNotEnough quantityIsNotEnough) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(InfraConstants.MESSAGE, ExceptionResponse.QUANTITY_IS_NOT_ENOUGH.getMessage()));
    }

}
