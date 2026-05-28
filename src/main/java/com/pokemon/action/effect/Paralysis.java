package com.pokemon.action.effect;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.status.ParalysisStatus;

public class Paralysis implements MoveEffectInterface {

    private TargetInterface target;

    @Override
    public void apply(Battle battle) {
        target.resolve(battle).getActivePokemon().addStatus(new ParalysisStatus());
    }
}
