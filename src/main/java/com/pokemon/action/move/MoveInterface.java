package com.pokemon.action.move;

import com.pokemon.action.Action;
import com.pokemon.battle.Battle;

public interface MoveInterface extends Action {

    void execute(Battle battle);

    String getMenuPrint();
}
