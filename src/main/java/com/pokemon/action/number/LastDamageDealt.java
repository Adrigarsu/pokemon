package com.pokemon.action.number;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;

public class LastDamageDealt implements NumberInterface {

    private TargetInterface target;

    @Override
    public double evaluate(Battle battle) {
        return target.resolve(battle).getLastDamageDealt();
    }
}
