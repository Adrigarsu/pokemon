package com.pokemon.battle.inventory;

import com.pokemon.pokemon.Pokemon;

public class Potion implements Consumible{

    private int healthHP;

    public Potion(int healthHP) {
        this.healthHP = healthHP;
    }

    @Override
    public void consume(Pokemon pokemon) {

    }
}
