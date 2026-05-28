package com.pokemon.pokemon.type;


import java.util.List;

public enum Type {
    NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG,
    ROCK, GHOST, DRAGON, NONE;

    public boolean matchesAny(List<Type> types) {
        return types.contains(this);
    }
}