package com.pokemon.ui;

import com.pokemon.action.Action;
import com.pokemon.action.move.Move;
import com.pokemon.battle.Battle;
import com.pokemon.battle.Battler;

import java.util.Scanner;

public class BattleUI {

    private final Scanner scanner = new Scanner(System.in);
    private Battle battle;

    public BattleUI(Battle battle) {
        this.battle = battle;
    }

    public void run() {
        while (!battle.isOver()) {
            //TODO start status
            //battle.checkStartStatus();
            printStatus();
            Action chosen = askPlayerAction();
            chosen.execute(battle);
            printStatus();
            //TODO end status
            // ns
        }
        printWinner();
    }

    private void printStatus() {
        //TODO
        // muestra HP de ambos battlers y demas
    }

    private Move askPlayerAction() {
        //TODO
        // muestra opciones, lee input, devuelve el Move
        System.out.println("Choose an action:");

    }

    private void printWinner() {

        Battler winner;
        if (battle.isOver()) {
            winner = battle.getWinner();
        }
        //TODO pretty print
    }

}
