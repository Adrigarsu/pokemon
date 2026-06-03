package com.pokemon.action;

import com.pokemon.battle.Battle;
import com.pokemon.battle.Battler;

public class Escape implements Action {

    private Battler escaper;

    public Escape(Battler attacker) {
        this.escaper = attacker;
    }

    @Override
    public void execute(Battle battle) {
        battle.log(battle.getAttacker().getName() + " surrendered!", Battle.LogCategory.ESCAPE);
        battle.surrender();
    }

}
