package com.pokemon.action.number;

import com.pokemon.battle.Battle;

import java.util.List;
import java.util.Random;

public class Weighted implements NumberInterface {

    private List<WeightedEntry> entries;
    private Random random = new Random();

    public Weighted(List<WeightedEntry> entries) {
        this.entries = entries;
    }

    @Override
    public double evaluate(Battle battle) {
        double roll = random.nextDouble(); // valor entre 0.0 y 1.0
        double cumulative = 0.0;

        for (WeightedEntry entry : entries) {
            cumulative += entry.getProbability();
            if (roll < cumulative) {
                return entry.getValue();
            }
        }

        // fallback: return the last of the probabilities do not add 1.0
        return entries.getLast().getValue();
    }
}
