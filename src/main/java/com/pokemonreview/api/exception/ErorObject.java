package com.pokemonreview.api.exception;

import lombok.Data;

import java.util.Date;

@Data
public class ErorObject {
    private Integer statusCode;
    private String massage;
    private Date timestamp;
}
