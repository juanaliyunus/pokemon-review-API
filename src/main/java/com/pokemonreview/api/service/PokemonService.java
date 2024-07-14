package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.request.PokemonRequest;
import com.pokemonreview.api.dto.response.PokemonResponse;

import java.util.List;

public interface PokemonService {
    PokemonResponse createPokemon(PokemonRequest pokemonRequest);

    List<PokemonResponse> getAllPokemons();

    PokemonResponse getPokemonById(int id);

    PokemonResponse updatePokemon(PokemonRequest pokemonRequest, int id);

    void deletePokemon(int id);
}
