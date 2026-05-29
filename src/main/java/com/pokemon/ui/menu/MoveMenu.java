package com.pokemon.ui.menu;

import com.pokemon.action.Action;
import com.pokemon.action.move.MoveInterface;
import com.pokemon.battle.Battle;

import java.util.List;
import java.util.Scanner;

public class MoveMenu implements MenuInterface{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Action selectSubmenuAction(Battle battle) {
        List<MoveInterface> attacks = battle.getAttacker().getActivePokemon().getAttacks();
        int option = printAttack(attacks);
        return attacks.get(option);

    }

    private int printAttack(List<MoveInterface> attacks) {

        for (int i = 0; i<attacks.size()-1; i++ ){
            int orderNumber = i+1;
            System.out.println(orderNumber + " - " + attacks.get(i).getMenuPrint());
        }
        int option = scanner.nextInt();
        while (option < 0 || option >= attacks.size()){
            option = scanner.nextInt();
        }
        return option;
    }


}
