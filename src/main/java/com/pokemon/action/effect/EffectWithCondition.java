package com.pokemon.action.effect;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.battle.Battle;

public class EffectWithCondition implements MoveEffectInterface {

    private ConditionInterface<Battle> condition;
    private MoveEffectInterface onPass;
    private MoveEffectInterface onFail;

    public EffectWithCondition(ConditionInterface<Battle> condition, MoveEffectInterface onFail,
                               MoveEffectInterface onPass) {
        this.condition = condition;
        this.onFail = onFail;
        this.onPass = onPass;
    }

    public ConditionInterface<Battle> getCondition() {
        return condition;
    }

    public void setCondition(ConditionInterface<Battle> condition) {
        this.condition = condition;
    }

    public MoveEffectInterface getOnFail() {
        return onFail;
    }

    public void setOnFail(MoveEffectInterface onFail) {
        this.onFail = onFail;
    }

    public MoveEffectInterface getOnPass() {
        return onPass;
    }

    public void setOnPass(MoveEffectInterface onPass) {
        this.onPass = onPass;
    }

    @Override
    public void apply(Battle battle) {
        if (condition.check(battle)) {
            onPass.apply(battle);
        }
        else {
            onFail.apply(battle);
        }
    }
}
