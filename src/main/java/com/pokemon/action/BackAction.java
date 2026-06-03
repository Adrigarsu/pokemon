package com.pokemon.action;

import com.pokemon.battle.Battle;

public class BackAction implements Action {

    public static final BackAction INSTANCE = new BackAction();

    private BackAction() {}

    @Override
    public void execute(Battle battle) {}
}