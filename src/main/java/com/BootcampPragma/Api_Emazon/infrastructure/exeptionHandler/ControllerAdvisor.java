package com.BootcampPragma.Api_Emazon.infrastructure.exeptionHandler;

import com.BootcampPragma.Api_Emazon.domain.exeption.DescripcionIsTooLongException;
import com.BootcampPragma.Api_Emazon.domain.exeption.NameIsTooLongException;
import com.BootcampPragma.Api_Emazon.infrastructure.exeption.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(CategoriaAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoriaAlreadyExistsException(
            CategoriaAlreadyExistsException categoriaAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORIA_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(MarcaAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleMarcaAlreadyExistsException(
            MarcaAlreadyExistsException marcaAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.MARCA_ALREADY_EXIST.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(DescripcionNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleDescripcionNotFoundException(
            DescripcionNotFoundException categoriaNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPCION_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTypeNotFoundException(
            CategoriaNotFoundException typeNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORIA_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(DescripcionIsTooLongException.class)
    public ResponseEntity<Map<String, String>> handleDescriptionIsTooLongExeption(
            DescripcionIsTooLongException descriptionIsTooLongExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DESCRIPCION_IS_TOO_LONG.getMessage()));
    }
    @ExceptionHandler(NameIsTooLongException.class)
    public ResponseEntity<Map<String, String>> handleNameIsTooLongExeption(
            NameIsTooLongException nameIsTooLongExeption) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NAME_IS_TOO_LONG.getMessage()));
    }
}
