package com.pokemon.battle;

import com.pokemon.battle.inventory.Inventory;
import com.pokemon.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Battler {

    private List<Pokemon> pokemons = new ArrayList<Pokemon>(6);
    private Pokemon activePokemon;
    private Inventory inventory;
    private int LastDamageDealt;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getLastDamageDealt() {
        return LastDamageDealt;
    }

    public void setLastDamageDealt(int lastDamageDealt) {
        LastDamageDealt = lastDamageDealt;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }
}
