package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class BurnStatus implements StatusInterface {

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) { return false; }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {
        int dmg = Math.max(1, pokemon.getMaxHP() / 16);
        pokemon.setHP(Math.max(0, pokemon.getHP() - dmg));
        battle.log(pokemon.getNickname() + " is hurt by its burn! (-" + dmg + " HP)", Battle.LogCategory.DAMAGE);
        if (pokemon.getHP() == 0)
            battle.log(pokemon.getNickname() + " fainted from burn!", Battle.LogCategory.STATUS);
    }
}