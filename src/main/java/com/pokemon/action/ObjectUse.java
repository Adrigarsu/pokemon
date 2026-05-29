package com.pokemon.action;

import com.pokemon.battle.Battle;
import com.pokemon.battle.inventory.Consumible;
import com.pokemon.battle.inventory.Potion;

public class ObjectUse implements Action{

    private Consumible consumible;

    public ObjectUse(Consumible consumible) {
        this.consumible = consumible;
    }

    @Override
    public void execute(Battle battle) {

    }
}
