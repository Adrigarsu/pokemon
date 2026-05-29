package com.pokemon.ui.menu;

import com.pokemon.action.Action;
import com.pokemon.action.Escape;
import com.pokemon.battle.Battle;

import java.util.Locale;
import java.util.Scanner;

public class EscapeMenu implements MenuInterface{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Action selectSubmenuAction(Battle battle) {
        return new Escape(battle.getAttacker());

    }
}
