package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class FreezeStatus implements StatusInterface {

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) {
        if (Math.random() < 0.20) {
            pokemon.removeStatusOfType(FreezeStatus.class);
            battle.log(pokemon.getNickname() + " thawed out!", Battle.LogCategory.STATUS);
            return false;
        }
        battle.log(pokemon.getNickname() + " is frozen solid!", Battle.LogCategory.STATUS);
        return true;
    }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {}
}