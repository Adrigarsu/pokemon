package com.pokemon.action;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class PokemonChange implements Action{

    private Pokemon newPokemon;

    public PokemonChange(Pokemon pokemon) {
        this.newPokemon = pokemon;
    }

    @Override
    public void execute(Battle battle) {
        battle.log(battle.getAttacker().getName() + " sent out " + newPokemon.getNickname() + "!", Battle.LogCategory.SWAP);
        battle.getAttacker().setActivePokemon(newPokemon);
    }

}
