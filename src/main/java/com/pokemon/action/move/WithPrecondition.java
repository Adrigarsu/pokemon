package com.pokemon.action.move;

import com.pokemon.action.condition.ConditionInterface;
import com.pokemon.battle.Battle;

public class WithPrecondition implements MoveInterface{

    private ConditionInterface<Battle> condition;
    private MoveInterface move;

    @Override
    public void execute(Battle battle) {

    }

    @Override
    public String getMenuPrint() {
        return move.toString();
    }
}
