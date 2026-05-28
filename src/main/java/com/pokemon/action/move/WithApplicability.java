package com.pokemon.action.move;

import com.pokemon.battle.Battle;
import com.pokemon.battle.Battler;

public class WithApplicability implements MoveInterface{

    private ConditionInterface<Battler> condition;
    private MoveInterface move;

    @Override
    public void execute(Battle battle) {

    }
}
