package com.pokemonreview.api.controller;

import com.pokemonreview.api.dto.request.PokemonRequest;
import com.pokemonreview.api.dto.response.PokemonResponse;
import com.pokemonreview.api.model.Pokemon;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonResponse>> getAllPokemons() {
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonResponse> getPokemonById(@PathVariable int id) {
    return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonResponse> createPokemon(@RequestBody PokemonRequest pokemonRequest) {
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonRequest), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonResponse> updatePokemon(@RequestBody PokemonRequest pokemonRequest,@PathVariable("id") int pokemonId) {
        PokemonResponse pokemonResponse = pokemonService.updatePokemon(pokemonRequest, pokemonId);
        return new ResponseEntity<>(pokemonResponse, HttpStatus.OK);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){
        pokemonService.deletePokemon(pokemonId);
        return  new ResponseEntity<>("Pokemon deleted successfully", HttpStatus.OK);
    }
}
