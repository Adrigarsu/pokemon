package com.pokemon.action.effect;

import com.pokemon.battle.Battle;

import java.util.List;

public class EffectInSequence implements MoveEffectInterface {

    private List<MoveEffectInterface> effects;

    public EffectInSequence(List<MoveEffectInterface> effects) {
        this.effects = effects;
    }

    public List<MoveEffectInterface> getEffects() {
        return effects;
    }

    public void setEffects(List<MoveEffectInterface> effects) {
        this.effects = effects;
    }

    @Override
    public void apply(Battle battle) {
        for (MoveEffectInterface effect : effects) {
            effect.apply(battle);
        }

    }
}
