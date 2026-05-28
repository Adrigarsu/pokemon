package com.pokemon;

import com.pokemon.battle.Battle;
import com.pokemon.ui.BattleUI;
import com.pokemon.battle.Battler;

public class Main {

    private Battler player;
    private Battler opponent;

    public static void main(String[] args) {

        Battle battle = new Battle(player, opponent);
        new BattleUI(battle).run();
    }
}