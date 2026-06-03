package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class SleepStatus implements StatusInterface {

    private int turnsLeft;

    public SleepStatus() {
        this.turnsLeft = 1 + (int) (Math.random() * 3); // 1-3 turns
    }

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) {
        if (turnsLeft > 0) {
            turnsLeft--;
            battle.log(pokemon.getNickname() + " is fast asleep!", Battle.LogCategory.STATUS);
            return true;
        }
        pokemon.removeStatusOfType(SleepStatus.class);
        battle.log(pokemon.getNickname() + " woke up!", Battle.LogCategory.STATUS);
        return false;
    }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {}
}