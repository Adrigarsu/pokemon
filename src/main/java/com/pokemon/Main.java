package com.pokemon;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;
import com.pokemon.pokemon.PokemonFactory;
import com.pokemon.ui.BattleUI;
import com.pokemon.battle.Battler;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // set up user 1
        Battler player1 = new Battler(args[0]);
        ArrayList<Pokemon> pokemons1 = new ArrayList<Pokemon>();
        pokemons1.add(PokemonFactory.newPikachu("piki"));
        pokemons1.add(PokemonFactory.newPikachu("electri"));
        player1.setPokemons(pokemons1);

        Battler player2 = new Battler(args[1]);
        ArrayList<Pokemon> pokemons2 = new ArrayList<Pokemon>();
        pokemons2.add(PokemonFactory.newBulbasaur("bulbasuuuuur"));
        pokemons2.add(PokemonFactory.newCharmander("charmi"));
        player2.setPokemons(pokemons2);

        Battle battle = new Battle(player1, player2);

        new BattleUI(battle).run();
    }
}