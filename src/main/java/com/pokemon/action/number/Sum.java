package com.pokemon.action.number;

import com.pokemon.battle.Battle;

public class Sum implements NumberInterface {

    private NumberInterface number1;
    private NumberInterface number2;

    public Sum(NumberInterface number1, NumberInterface number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public NumberInterface getNumber1() {
        return number1;
    }

    public void setNumber1(NumberInterface number1) {
        this.number1 = number1;
    }

    public NumberInterface getNumber2() {
        return number2;
    }

    public void setNumber2(NumberInterface number2) {
        this.number2 = number2;
    }

    @Override
    public double evaluate(Battle battle) {
        return number1.evaluate(battle) + number2.evaluate(battle);
    }
}
