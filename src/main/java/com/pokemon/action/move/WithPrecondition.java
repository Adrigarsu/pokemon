package com.pokemon.action.move;

import com.pokemon.battle.Battle;

public class WithPrecondition implements MoveInterface{

    private ConditionInterface condition;
    private MoveInterface move;

    @Override
    public void execute(Battle battle) {

    }
}
