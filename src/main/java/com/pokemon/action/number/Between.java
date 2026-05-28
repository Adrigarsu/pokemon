package com.pokemon.action.number;

import com.pokemon.battle.Battle;

public class Between implements NumberInterface {

    private double minValue;
    private double maxValue;


    public Between(double minValue, double maxValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;

    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    @Override
    public double evaluate(Battle battle) {
        return minValue + (maxValue - minValue) * Math.random();
    }
}
