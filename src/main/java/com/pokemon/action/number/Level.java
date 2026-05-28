package com.pokemon.action.number;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;

public class Level implements NumberInterface {

    private TargetInterface target;

    public Level(TargetInterface target) {
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
        return target.resolve(battle).getActivePokemon().getLevel();
    }
}
