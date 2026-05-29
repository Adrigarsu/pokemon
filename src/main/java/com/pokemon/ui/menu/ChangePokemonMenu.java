package com.pokemon.ui.menu;


import com.pokemon.action.Action;
import com.pokemon.action.PokemonChange;
import com.pokemon.action.move.MoveInterface;
import com.pokemon.battle.Battle;
import com.pokemon.battle.Battler;
import com.pokemon.pokemon.Pokemon;

import java.util.List;
import java.util.Scanner;

public class ChangePokemonMenu implements MenuInterface {

    private final Scanner scanner = new Scanner(System.in);
    private Battle battle;

    @Override
    public Action selectSubmenuAction(Battle battle) {
        this.battle = battle;

        List<Pokemon> pokemons = battle.getAttacker().getPokemons();
        int option = printPokemons(pokemons);
        return new PokemonChange(pokemons.get(option));

    }

    private int printPokemons(List<Pokemon> pokemons) {
        for (int i = 0; i<pokemons.size()-1; i++ ){
            int orderNumber = i+1;
            System.out.println(orderNumber + " - " + pokemons.get(i).getMenuPrint());
        }
        int option = scanner.nextInt();
        while (option < 0 || option >= pokemons.size() || isNotActivePokemon(pokemons.get(option)
                , battle.getAttacker().getActivePokemon())){
            option = scanner.nextInt();
        }
        return option;
    }

    private boolean isNotActivePokemon(Pokemon pokemon, Pokemon activePokemon) {
        return !activePokemon.getNickname().equals(pokemon.getNickname());
    }


}
