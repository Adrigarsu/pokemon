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


        Battler player1 = new Battler(args[0]);
        ArrayList<Pokemon> pokemons1 = new ArrayList<>();
        pokemons1.add(PokemonFactory.newRaichu("Raichu"));
        pokemons1.add(PokemonFactory.newJigglypuff("Jiggly"));
        pokemons1.add(PokemonFactory.newGengar("Gengar"));
        pokemons1.add(PokemonFactory.newMuk("Muk"));
        pokemons1.add(PokemonFactory.newArcanine("Arcanine"));
        pokemons1.add(PokemonFactory.newArticuno("Articuno"));
        player1.setPokemons(pokemons1);

        Inventory inv1 = new Inventory();
        inv1.add(ItemFactory.paralyzHeal(2));
        inv1.add(ItemFactory.awakening(2));
        inv1.add(ItemFactory.fullHeal(2));
        inv1.add(ItemFactory.revive(1));
        player1.setInventory(inv1);


        Battler player2 = new Battler(args[1]);
        ArrayList<Pokemon> pokemons2 = new ArrayList<>();
        pokemons2.add(PokemonFactory.newChansey("Chansey"));
        pokemons2.add(PokemonFactory.newSnorlax("Snorlax"));
        pokemons2.add(PokemonFactory.newLapras("Lapras"));
        player2.setPokemons(pokemons2);

        Inventory inv2 = new Inventory();
        inv2.add(ItemFactory.fullRestore(2));
        inv2.add(ItemFactory.antidote(2));
        inv2.add(ItemFactory.burnHeal(2));
        inv2.add(ItemFactory.iceHeal(2));
        inv2.add(ItemFactory.revive(1));
        player2.setInventory(inv2);

        Battle battle = new Battle(player1, player2);

        new BattleUI(battle).run();
    }
}