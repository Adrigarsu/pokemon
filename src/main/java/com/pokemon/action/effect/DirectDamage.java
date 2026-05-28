package com.pokemon.action.effect;

import com.pokemon.action.number.NumberInterface;
import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class DirectDamage implements MoveEffectInterface {

    private TargetInterface target;
    private NumberInterface number;

    public DirectDamage(TargetInterface target, NumberInterface number) {
        this.number = number;
        this.target = target;
    }

    @Override
    public void apply(Battle battle) {
        Pokemon pokemon = target.resolve(battle).getActivePokemon();
        int newHP = pokemon.getHP() - (int) number.evaluate(battle);
        pokemon.setHP(newHP);
    }
}
