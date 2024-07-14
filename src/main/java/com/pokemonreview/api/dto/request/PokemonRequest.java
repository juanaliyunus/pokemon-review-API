package com.pokemonreview.api.dto.request;

import lombok.Data;

@Data
public class PokemonRequest {
    private int id;
    private String name;
    private String type;
}
