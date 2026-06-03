package com.pokemon.ui.menu;

import com.pokemon.action.Action;
import com.pokemon.action.BackAction;
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
        if (option == -1) return BackAction.INSTANCE;
        return attacks.get(option);
    }

    private int printAttack(List<MoveInterface> attacks) {
        for (int i = 0; i < attacks.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + attacks.get(i).getMenuPrint());
        }
        System.out.println("  0. Back");
        System.out.print("  > ");
        int option = scanner.nextInt();
        while (option < 0 || option > attacks.size()) {
            System.out.print("  > ");
            option = scanner.nextInt();
        }
        return option == 0 ? -1 : option - 1;
    }


}
