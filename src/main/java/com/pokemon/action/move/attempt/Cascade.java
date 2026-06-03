package com.pokemon.action.move.attempt;

import com.pokemon.battle.Battle;

import java.util.List;

public class Cascade implements AttemptInterface{

    private List<AttemptInterface> attempts;

    @Override
    public void execute(Battle battle) {
        for (AttemptInterface attempt : attempts){
            attempt.execute(battle);
        }

    }
}
