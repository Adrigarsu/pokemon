package com.pokemon.ui.menu;


import com.pokemon.action.Action;
import com.pokemon.action.BackAction;
import com.pokemon.action.PokemonChange;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

import java.util.List;
import java.util.Scanner;

public class ChangePokemonMenu implements MenuInterface {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Action selectSubmenuAction(Battle battle) {
        List<Pokemon> pokemons = battle.getAttacker().getPokemons();
        int option = printPokemons(pokemons, battle.getAttacker().getActivePokemon());
        if (option == -1) return BackAction.INSTANCE;
        return new PokemonChange(pokemons.get(option));
    }

    private int printPokemons(List<Pokemon> pokemons, Pokemon active) {
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon p = pokemons.get(i);
            String marker = p.getNickname().equals(active.getNickname()) ? " (active)" : "";
            System.out.println("  " + (i + 1) + ". " + p.getMenuPrint() + marker);
        }
        System.out.println("  0. Back");
        System.out.print("  > ");
        int option = scanner.nextInt();
        while (option < 0 || option > pokemons.size()
                || (option > 0 && isActivePokemon(pokemons.get(option - 1), active))) {
            System.out.print("  > ");
            option = scanner.nextInt();
        }
        return option == 0 ? -1 : option - 1;
    }

    private boolean isActivePokemon(Pokemon pokemon, Pokemon active) {
        return active.getNickname().equals(pokemon.getNickname());
    }


}
