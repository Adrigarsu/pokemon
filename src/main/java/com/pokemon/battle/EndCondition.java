package com.pokemon.battle;

import com.pokemon.exception.NoWinnerException;

import java.util.Optional;

public class EndCondition {

    private boolean surrender;
    private Battler surrenderer;

    //TODO check it
    public Battler getWinner(Battler player, Battler opponent) {
        if (player.hasLost()) {
            return opponent;
        }
        return player;

    }

    public boolean isOver(Battler player, Battler opponent) {
        return player.hasLost() || opponent.hasLost() || surrender;
    }

    public void surrender(Battler battler){
        this.surrender = true;
        this.surrenderer = battler;
    }
}
