package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.request.PokemonRequest;
import com.pokemonreview.api.dto.response.PokemonResponse;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.model.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {
    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonResponse createPokemon(PokemonRequest pokemonRequest) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonRequest.getName());
        pokemon.setType(pokemonRequest.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());
        return pokemonResponse;
    }

    @Override
    public List<PokemonResponse> getAllPokemons() {
        List<Pokemon> pokemon = pokemonRepository.findAll();
        return pokemon.stream().map(p ->mapToPokemonResponse(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonResponse getPokemonById(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()->new PokemonNotFoundException("Pokemon could not be found"));
        return mapToPokemonResponse(pokemon);
    }

    @Override
    public PokemonResponse updatePokemon(PokemonRequest pokemonRequest, int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()->new PokemonNotFoundException("Pokemon could not be updated"));
        pokemon.setName(pokemonRequest.getName());
        pokemon.setType(pokemonRequest.getType());
        Pokemon updatedPokemon = pokemonRepository.save(pokemon);
        return mapToPokemonResponse(updatedPokemon);
    }

    @Override
    public void deletePokemon(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()->new PokemonNotFoundException("Pokemon could not be delete"));
        pokemonRepository.delete(pokemon);
    }

    private PokemonResponse mapToPokemonResponse(Pokemon pokemon) {
        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse.setId(pokemon.getId());
        pokemonResponse.setName(pokemon.getName());
        pokemonResponse.setType(pokemon.getType());
        return pokemonResponse;
    }

    private Pokemon mapToPokemon(PokemonResponse pokemonResponse) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonResponse.getName());
        pokemon.setType(pokemonResponse.getType());
        return pokemon;
    }
}
