package com.pokemon.ui;

import com.pokemon.action.Action;
import com.pokemon.action.move.Move;
import com.pokemon.battle.Battle;
import com.pokemon.battle.Battler;
import com.pokemon.ui.menu.*;

import java.util.Scanner;

public class BattleUI {

    private final Scanner scanner = new Scanner(System.in);
    private Battle battle;

    public BattleUI(Battle battle) {
        this.battle = battle;
    }

    public void run() {
        while (!battle.isOver()) {

            //print acutal game status
            printStatus();
            // select new action
            Action chosen = askPlayerAction();
            // apply action selected
            chosen.execute(battle);
            //TODO end status battle.checkEndStatus();
            // print end status after end effects
            printStatus();

        }
        printWinner();
    }

    private void printStatus() {
        System.out.println(battle.battleStatusPrint());
        System.out.println("=================================");
        System.out.println(battle.battlerInfoPrint(battle.getDefender()));
        System.out.println(battle.battlerInfoPrint(battle.getAttacker()));
        System.out.println("=================================");
    }

    private Action askPlayerAction() {

        int option = printAccionMenu();

        // by default a move
        MenuInterface  subMenu = new MoveMenu();

        switch (option){
            case 1 : break; // already assigned a move submenu
            case 2 : subMenu = new ObjectUseMenu(); break;
            case 3 : subMenu = new ChangePokemonMenu(); break;
            case 4 : subMenu = new EscapeMenu(); break;
        }

        return subMenu.selectSubmenuAction(battle);

    }

    private int printAccionMenu() {
        System.out.println("Choose an action: ");
        System.out.println("1. Attack");
        System.out.println("2. Inventory");
        System.out.println("3. Change pokemon");
        System.out.println("4. Escape");

        int choice = scanner.nextInt();
        while (choice < 1 || choice > 4){
            System.out.println("The selected option is not valid");
            choice = scanner.nextInt();
        }
        return choice;

    }


    private void printWinner() {

        Battler winner;
        if (battle.isOver()) {
            winner = battle.getWinner();

            System.out.println("----------------------------------------");
            System.out.println("The winner is " + winner.getName().toUpperCase());
            System.out.println("----------------------------------------");
        }
        throw new RuntimeException("No winner in printWinner()");


    }

}
