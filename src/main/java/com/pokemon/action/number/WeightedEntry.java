package com.pokemon.action.number;

public class WeightedEntry {

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
}
