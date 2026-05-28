package com.pokemon.pokemon.type;

/**
 * Move category in Generation I.
 * <p>
 * In Gen 1, whether a move is physical or special is determined entirely
 * by its type — not by the move itself. The split is as follows:
 * <p>
 * Physical: Normal, Fighting, PoisonStatus, Ground, Flying, Bug, Rock, Ghost
 * Special:  Fire, Water, Electric, Grass, Ice, Psychic, Dragon
 * <p>
 * This enum is used by DamageCalculator to decide whether to use
 * Attack/Defense or Special/Special when computing damage.
 */
public enum MoveCategory {
    PHYSICAL, SPECIAL
}