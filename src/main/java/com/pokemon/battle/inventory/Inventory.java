package com.pokemon.battle.inventory;

import com.pokemon.action.Action;
import com.pokemon.action.ObjectUse;

import java.util.List;

public class Inventory {

    private List<Consumible> consumibles;

    public Action use(Consumible consumible) {
        return new ObjectUse(consumible);
    }
}
