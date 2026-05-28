package com.pokemon.action.number;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;

public class CurrentHP implements NumberInterface {

    private TargetInterface target;

    public CurrentHP(TargetInterface target) {
        this.target = target;
    }

    public TargetInterface getTarget() {
        return target;
    }

    public void setTarget(TargetInterface target) {
        this.target = target;
    }

    @Override
    public double evaluate(Battle battle) {
        return target.resolve(battle).getActivePokemon().getHP();
    }
}
