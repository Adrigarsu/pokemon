package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public interface StatusInterface {
    boolean blocksMove(Pokemon pokemon, Battle battle);
    void onEndOfTurn(Pokemon pokemon, Battle battle);
    default boolean isPrimary() { return true; }
}