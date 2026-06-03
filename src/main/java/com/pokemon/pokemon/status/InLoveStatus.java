package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class InLoveStatus implements StatusInterface {

    @Override
    public boolean isPrimary() { return false; }

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) { return false; }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {}
}