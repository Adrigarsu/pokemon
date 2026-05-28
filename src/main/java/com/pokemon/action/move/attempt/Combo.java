package com.pokemon.action.move.attempt;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.action.effect.MoveEffectInterface;
import com.pokemon.battle.Battle;

public class Combo implements AttemptInterface {

    //private animation
    private ConditionInterface<Battle> accuracy;
    private NumberInterface hits;
    private MoveEffectInterface effect;

    @Override
    public void execute(Battle battle) {

    }
}
