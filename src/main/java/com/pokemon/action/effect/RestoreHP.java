package com.pokemon.action.effect;

import com.pokemon.action.number.NumberInterface;
import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class RestoreHP implements MoveEffectInterface {

    private TargetInterface target;
    private NumberInterface number;

    @Override
    public void apply(Battle battle) {

        Pokemon pokemon = target.resolve(battle).getActivePokemon();
        int newHP = pokemon.getHP() + (int) number.evaluate(battle);
        if (newHP > pokemon.getMaxHP()) {
            pokemon.setHP(pokemon.getMaxHP());
        }
        else {
            pokemon.setHP(newHP);
        }

    }
}
