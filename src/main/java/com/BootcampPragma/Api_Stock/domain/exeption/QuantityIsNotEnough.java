package com.BootcampPragma.Api_Stock.domain.exeption;

public class QuantityIsNotEnough extends RuntimeException{
    public QuantityIsNotEnough(String response) {
        super(response);
    }

}
