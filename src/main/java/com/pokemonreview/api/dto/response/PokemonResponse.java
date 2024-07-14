package com.pokemonreview.api.dto.response;

import lombok.Data;

@Data
public class PokemonResponse {
    private int id;
    private String name;
    private String type;
}
