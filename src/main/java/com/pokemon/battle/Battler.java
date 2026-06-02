package com.pokemon.battle;

import com.pokemon.battle.inventory.Inventory;
import com.pokemon.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Battler {

    private String name;
    private List<Pokemon> pokemons = new ArrayList<Pokemon>(6);
    private Pokemon activePokemon;
    private Inventory inventory;
    private int LastDamageDealt;

    public Battler(String name) {
        this.name = name;
        pokemons.add(new Pokemon("Pikachu of " + name));
    }

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
        if (!pokemons.isEmpty()) {
            this.activePokemon = pokemons.get(0);
        }
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public String getName() {
        return name;
    }

    public boolean hasLost() {
        for (Pokemon pokemon : pokemons ){
            if (pokemon.getHP() > 0 )
                return false;
        }
        return true;
    }
}
