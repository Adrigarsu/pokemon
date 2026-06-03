package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class ParalysisStatus implements StatusInterface {

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) {
        if (Math.random() < 0.25) {
            battle.log(pokemon.getNickname() + " is paralyzed! It can't move!", Battle.LogCategory.STATUS);
            return true;
        }
        return false;
    }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {}
}