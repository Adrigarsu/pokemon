package com.pokemon.action.move.attempt;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.action.effect.MoveEffectInterface;
import com.pokemon.battle.Battle;

public class Attempt implements AttemptInterface {

    private ConditionInterface<Battle> accuracy;
    private MoveEffectInterface onHit;
    private MoveEffectInterface onMiss;
    private MoveEffectInterface after;

    public Attempt(ConditionInterface<Battle> accuracy, MoveEffectInterface onHit,
                   MoveEffectInterface onMiss, MoveEffectInterface after) {
        this.accuracy = accuracy;
        this.onHit = onHit;
        this.onMiss = onMiss;
        this.after = after;
    }

    @Override
    public void execute(Battle battle) {
        if(accuracy.check(battle)){
            onHit.apply(battle);
        }
        else{
            onMiss.apply(battle);
        }
        after.apply(battle);
    }
}
