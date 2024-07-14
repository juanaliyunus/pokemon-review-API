package com.pokemonreview.api.exception;

public class PokemonNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PokemonNotFoundException(String massage){
        super(massage);
    }

}
