package com.pokemon.action.move.attempt;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.action.effect.MoveEffectInterface;
import com.pokemon.action.number.NumberInterface;
import com.pokemon.battle.Battle;

public class Combo implements AttemptInterface {

    private ConditionInterface<Battle> accuracy;
    private NumberInterface hits;
    private MoveEffectInterface effect;

    public Combo(ConditionInterface<Battle> accuracy, NumberInterface hits, MoveEffectInterface effect) {
        this.accuracy = accuracy;
        this.hits = hits;
        this.effect = effect;
    }

    @Override
    public void execute(Battle battle) {
        if (accuracy.check(battle)) {
            int numHits = (int) hits.evaluate(battle);
            for (int i = 0; i < numHits; i++) {
                effect.apply(battle);
            }
        }
    }
}
