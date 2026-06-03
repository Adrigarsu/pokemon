package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class BadlyPoisonedStatus implements StatusInterface {

    private int counter = 1;

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) { return false; }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {
        int dmg = Math.max(1, pokemon.getMaxHP() * counter / 16);
        pokemon.setHP(Math.max(0, pokemon.getHP() - dmg));
        battle.log(pokemon.getNickname() + " is badly poisoned! (-" + dmg + " HP)", Battle.LogCategory.DAMAGE);
        counter++;
        if (pokemon.getHP() == 0)
            battle.log(pokemon.getNickname() + " fainted from bad poison!", Battle.LogCategory.STATUS);
    }
}