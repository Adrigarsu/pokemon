package com.pokemon.action.effect;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class HealEffect implements MoveEffectInterface {

    private final TargetInterface target;
    private final double fraction;

    public HealEffect(TargetInterface target, double fraction) {
        this.target   = target;
        this.fraction = fraction;
    }

    @Override
    public void apply(Battle battle) {
        Pokemon p     = target.resolve(battle).getActivePokemon();
        int amount    = (int) Math.ceil(p.getMaxHP() * fraction);
        int oldHP     = p.getHP();
        p.setHP(p.getHP() + amount);
        int restored  = p.getHP() - oldHP;
        battle.log(p.getNickname() + " recovered " + restored + " HP!", Battle.LogCategory.INFO);
    }
}