package com.pokemon.ui.menu;

import com.pokemon.action.Action;
import com.pokemon.action.ObjectUse;
import com.pokemon.action.PokemonChange;
import com.pokemon.battle.Battle;
import com.pokemon.battle.inventory.Potion;
import com.pokemon.pokemon.Pokemon;

public class ObjectUseMenu implements MenuInterface{
    @Override
    public Action selectSubmenuAction(Battle battle) {
        //TODO
        return battle.getAttacker().getInventory().use(new Potion(5));
    }
}
