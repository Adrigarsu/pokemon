package com.pokemon.action.number;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;

public class MaxHP implements NumberInterface {

    private TargetInterface target;

    public MaxHP(TargetInterface target) {
        this.target = target;
    }

    @Override
    public double evaluate(Battle battle) {
        return target.resolve(battle).getActivePokemon().getMaxHP();
    }

    public TargetInterface getTarget() {
        return target;
    }

    public void setTarget(TargetInterface target) {
        this.target = target;
    }
}
