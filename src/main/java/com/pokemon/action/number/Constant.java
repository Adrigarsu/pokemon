package com.pokemon.action.number;

import com.pokemon.battle.Battle;

public class Constant implements NumberInterface {

    private double value;

    public Constant(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Battle battle) {
        return value;
    }
}
