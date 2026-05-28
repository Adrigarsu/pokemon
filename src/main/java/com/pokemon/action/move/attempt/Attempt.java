package com.pokemon.action.move.attempt;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.action.effect.MoveEffectInterface;
import com.pokemon.battle.Battle;

public class Attempt implements AttemptInterface {

    //private annimation
    private ConditionInterface<Battle> accuracy;
    private MoveEffectInterface onHit;
    private MoveEffectInterface onMiss;
    private MoveEffectInterface after;

    @Override
    public void execute(Battle battle) {

    }
}
