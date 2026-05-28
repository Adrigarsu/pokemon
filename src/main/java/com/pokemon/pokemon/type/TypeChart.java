package com.pokemon.pokemon.type;

import java.util.EnumMap;
import java.util.Map;

/**
 * Type effectiveness chart for Generation I.
 * <p>
 * Only non-neutral (non-1.0) matchups are stored.
 * Any matchup not explicitly registered defaults to 1.0 (neutral).
 * <p>
 * Gen 1 specific quirks included:
 * - PoisonStatus is super effective against Bug (reversed in later generations)
 * - Ghost does NO damage to Psychic (game bug — should be 2x)
 * - Ice is neutral against Fire (not resisted as in later generations)
 */
public class TypeChart {

    private static final Map<Type, Map<Type, Double>> chart = new EnumMap<>(Type.class);

    static {
        // NORMAL
        set(Type.NORMAL, Type.ROCK, 0.5);
        set(Type.NORMAL, Type.GHOST, 0.0);

        // FIRE
        set(Type.FIRE, Type.FIRE, 0.5);
        set(Type.FIRE, Type.WATER, 0.5);
        set(Type.FIRE, Type.GRASS, 2.0);
        set(Type.FIRE, Type.ICE, 2.0);
        set(Type.FIRE, Type.BUG, 2.0);
        set(Type.FIRE, Type.ROCK, 0.5);
        set(Type.FIRE, Type.DRAGON, 0.5);

        // WATER
        set(Type.WATER, Type.FIRE, 2.0);
        set(Type.WATER, Type.WATER, 0.5);
        set(Type.WATER, Type.GRASS, 0.5);
        set(Type.WATER, Type.GROUND, 2.0);
        set(Type.WATER, Type.ROCK, 2.0);
        set(Type.WATER, Type.DRAGON, 0.5);

        // ELECTRIC
        set(Type.ELECTRIC, Type.WATER, 2.0);
        set(Type.ELECTRIC, Type.ELECTRIC, 0.5);
        set(Type.ELECTRIC, Type.GRASS, 0.5);
        set(Type.ELECTRIC, Type.GROUND, 0.0);
        set(Type.ELECTRIC, Type.FLYING, 2.0);
        set(Type.ELECTRIC, Type.DRAGON, 0.5);

        // GRASS
        set(Type.GRASS, Type.FIRE, 0.5);
        set(Type.GRASS, Type.WATER, 2.0);
        set(Type.GRASS, Type.GRASS, 0.5);
        set(Type.GRASS, Type.POISON, 0.5);
        set(Type.GRASS, Type.GROUND, 2.0);
        set(Type.GRASS, Type.FLYING, 0.5);
        set(Type.GRASS, Type.BUG, 0.5);
        set(Type.GRASS, Type.ROCK, 2.0);
        set(Type.GRASS, Type.DRAGON, 0.5);

        // ICE
        set(Type.ICE, Type.WATER, 0.5);
        set(Type.ICE, Type.GRASS, 2.0);
        set(Type.ICE, Type.ICE, 0.5);
        set(Type.ICE, Type.GROUND, 2.0);
        set(Type.ICE, Type.FLYING, 2.0);
        set(Type.ICE, Type.DRAGON, 2.0);

        // FIGHTING
        set(Type.FIGHTING, Type.NORMAL, 2.0);
        set(Type.FIGHTING, Type.ICE, 2.0);
        set(Type.FIGHTING, Type.POISON, 0.5);
        set(Type.FIGHTING, Type.FLYING, 0.5);
        set(Type.FIGHTING, Type.PSYCHIC, 0.5);
        set(Type.FIGHTING, Type.BUG, 0.5);
        set(Type.FIGHTING, Type.ROCK, 2.0);
        set(Type.FIGHTING, Type.GHOST, 0.0);

        // POISON
        set(Type.POISON, Type.GRASS, 2.0);
        set(Type.POISON, Type.POISON, 0.5);
        set(Type.POISON, Type.GROUND, 0.5);
        set(Type.POISON, Type.BUG, 2.0); // Gen 1 quirk: reversed in Gen 2+
        set(Type.POISON, Type.ROCK, 0.5);
        set(Type.POISON, Type.GHOST, 0.5);

        // GROUND
        set(Type.GROUND, Type.FIRE, 2.0);
        set(Type.GROUND, Type.ELECTRIC, 2.0);
        set(Type.GROUND, Type.GRASS, 0.5);
        set(Type.GROUND, Type.POISON, 2.0);
        set(Type.GROUND, Type.FLYING, 0.0);
        set(Type.GROUND, Type.BUG, 0.5);
        set(Type.GROUND, Type.ROCK, 2.0);

        // FLYING
        set(Type.FLYING, Type.ELECTRIC, 0.5);
        set(Type.FLYING, Type.GRASS, 2.0);
        set(Type.FLYING, Type.FIGHTING, 2.0);
        set(Type.FLYING, Type.BUG, 2.0);
        set(Type.FLYING, Type.ROCK, 0.5);

        // PSYCHIC
        set(Type.PSYCHIC, Type.FIGHTING, 2.0);
        set(Type.PSYCHIC, Type.POISON, 2.0);
        set(Type.PSYCHIC, Type.PSYCHIC, 0.5);
        set(Type.PSYCHIC, Type.GHOST, 2.0);

        // BUG
        set(Type.BUG, Type.FIRE, 0.5);
        set(Type.BUG, Type.GRASS, 2.0);
        set(Type.BUG, Type.FIGHTING, 0.5);
        set(Type.BUG, Type.FLYING, 0.5);
        set(Type.BUG, Type.PSYCHIC, 2.0);
        set(Type.BUG, Type.GHOST, 0.5);

        // ROCK
        set(Type.ROCK, Type.FIRE, 2.0);
        set(Type.ROCK, Type.ICE, 2.0);
        set(Type.ROCK, Type.FIGHTING, 0.5);
        set(Type.ROCK, Type.GROUND, 0.5);
        set(Type.ROCK, Type.FLYING, 2.0);
        set(Type.ROCK, Type.BUG, 2.0);

        // GHOST
        set(Type.GHOST, Type.NORMAL, 0.0);
        set(Type.GHOST, Type.PSYCHIC, 2.0);
        set(Type.GHOST, Type.GHOST, 2.0);

        // DRAGON
        set(Type.DRAGON, Type.DRAGON, 2.0);
    }

    private static void set(Type attacker, Type defender, double multiplier) {
        chart.computeIfAbsent(attacker, k -> new EnumMap<>(Type.class)).put(defender, multiplier);
    }

    /**
     * Returns the damage multiplier for a move of {@code attackerType}
     * hitting a Pokémon of {@code defenderType}.
     * Defaults to 1.0 (neutral) if the matchup is not explicitly registered.
     */
    public static double getMultiplier(Type attackerType, Type defenderType) {
        return chart.getOrDefault(attackerType, Map.of()).getOrDefault(defenderType, 1.0);
    }

    /**
     * Returns the category (PHYSICAL or SPECIAL) of a move based on its type.
     * In Gen 1, this is determined entirely by the move's type.
     * <p>
     * Physical: Normal, Fighting, Poison, Ground, Flying, Bug, Rock, Ghost
     * Special:  Fire, Water, Electric, Grass, Ice, Psychic, Dragon
     */
    public static MoveCategory getCategoryOf(Type moveType) {
        return switch (moveType) {
            case NORMAL, FIGHTING, POISON, GROUND, FLYING, BUG, ROCK, GHOST ->
                    MoveCategory.PHYSICAL;
            case FIRE, WATER, ELECTRIC, GRASS, ICE, PSYCHIC, DRAGON -> MoveCategory.SPECIAL;
        };
    }
}