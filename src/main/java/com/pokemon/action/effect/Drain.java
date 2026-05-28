package com.pokemon.action.effect;

import com.pokemon.action.number.NumberInterface;
import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class Drain implements MoveEffectInterface {

    private TargetInterface drainFrom;
    private TargetInterface drainTo;
    private NumberInterface number;

    @Override
    public void apply(Battle battle) {
        int value = (int) number.evaluate(battle);
        Pokemon from = drainFrom.resolve(battle).getActivePokemon();
        Pokemon to = drainTo.resolve(battle).getActivePokemon();

        from.setHP(from.getHP() - value);
        to.setHP(to.getHP() + value);
    }
}
