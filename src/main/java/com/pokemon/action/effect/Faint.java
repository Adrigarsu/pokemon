package com.pokemon.action.effect;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class Faint implements MoveEffectInterface {

    private TargetInterface target;

    @Override
    public void apply(Battle battle) {
        Pokemon pokemon = target.resolve(battle).getActivePokemon();
        pokemon.setHP(0);
        pokemon.setDeath(true);
    }
}
