package com.pokemon.action.number;

import com.pokemon.battle.Battle;

public class WeightedEntry implements NumberInterface {

    private double probability;
    private double value;

    public WeightedEntry(double value, double probability) {
        this.probability = probability;
        this.value = value;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Battle battle) {
        return 0;
    }
}
