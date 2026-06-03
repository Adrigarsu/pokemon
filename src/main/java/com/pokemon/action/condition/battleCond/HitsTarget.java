package com.pokemon.action.condition.battleCond;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.battle.Battle;

public class HitsTarget implements ConditionInterface<Battle> {

    private final int precision;

    public HitsTarget(int precision) {
        this.precision = precision;
    }

    @Override
    public boolean check(Battle battle) {
        return Math.random() * 100 < precision;
    }
}