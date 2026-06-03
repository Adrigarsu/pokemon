package com.pokemon;

import com.pokemon.battle.Battle;
import com.pokemon.battle.inventory.Inventory;
import com.pokemon.battle.inventory.ItemFactory;
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
        pokemons1.add(PokemonFactory.newEevee("eveeee"));
        pokemons1.add(PokemonFactory.newAbra("abrete"));
        player1.setPokemons(pokemons1);

        Battler player2 = new Battler(args[1]);
        ArrayList<Pokemon> pokemons2 = new ArrayList<Pokemon>();
        pokemons2.add(PokemonFactory.newBulbasaur("bulbasuuuuur"));
        pokemons2.add(PokemonFactory.newCharmander("charmi"));
        player2.setPokemons(pokemons2);

        Inventory inv1 = new Inventory();
        inv1.add(ItemFactory.potion(3));
        inv1.add(ItemFactory.superPotion(1));
        inv1.add(ItemFactory.paralyzHeal(2));
        inv1.add(ItemFactory.revive(1));
        inv1.add(ItemFactory.xAttack(1));
        player1.setInventory(inv1);

        Inventory inv2 = new Inventory();
        inv2.add(ItemFactory.potion(3));
        inv2.add(ItemFactory.fullRestore(1));
        inv2.add(ItemFactory.revive(1));
        player2.setInventory(inv2);

        Battle battle = new Battle(player1, player2);

        new BattleUI(battle).run();
    }
}