package com.pokemon.action.move;

import com.pokemon.action.move.attempt.AttemptInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.type.MoveCategory;
import com.pokemon.pokemon.type.Type;
import com.pokemon.pokemon.type.TypeChart;

public class Move implements MoveInterface {

    private String name;
    private Type type;
    private int power;
    private int pp; //power points
    private int precision;
    private AttemptInterface attempt;

    public AttemptInterface getAttempt() {
        return attempt;
    }

    public void setAttempt(AttemptInterface attempt) {
        this.attempt = attempt;
    }

    public boolean isPhysical() {
        return TypeChart.getCategoryOf(this.type) == MoveCategory.PHYSICAL;
    }

    public boolean isSpecial() {
        return TypeChart.getCategoryOf(this.type) == MoveCategory.SPECIAL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void execute(Battle battle) {

    }
}
