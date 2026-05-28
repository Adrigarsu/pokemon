package com.pokemon.action.number;

import com.pokemon.battle.Battle;

public class Quotient implements NumberInterface {

    private NumberInterface dividend;
    private NumberInterface divisor;

    public Quotient(NumberInterface dividend, NumberInterface divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public NumberInterface getDividend() {
        return dividend;
    }

    public void setDividend(NumberInterface dividend) {
        this.dividend = dividend;
    }

    public NumberInterface getDivisor() {
        return divisor;
    }

    public void setDivisor(NumberInterface divisor) {
        this.divisor = divisor;
    }

    @Override
    public double evaluate(Battle battle) {
        double divisorValue = divisor.evaluate(battle);
        if (divisorValue == 0) {
            throw new ArithmeticException("Divisor cannot be zero in Quotient");
        }
        return dividend.evaluate(battle) / divisorValue;
    }
}
