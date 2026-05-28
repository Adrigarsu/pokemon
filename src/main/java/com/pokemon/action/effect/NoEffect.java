package com.pokemon.action.effect;

import com.pokemon.battle.Battle;

public class NoEffect implements MoveEffectInterface {

    @Override
    public void apply(Battle battle) {
        //No status
    }
}
