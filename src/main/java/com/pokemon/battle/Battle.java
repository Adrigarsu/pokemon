package com.pokemon.battle;


public class Battle {

    private Battler attacker;
    private Battler defender;

    private EndCondition endCondition;


    public boolean isOver() {
        return endCondition.isOver(attacker, defender);
    }


    public void checkStartStatus() {
        //TODO
        // cehck paralysis -> can move ?
        // check confusion -> hit himself
    }


    public Battler getWinner() {
        return endCondition.getWinner(attacker, defender);

    }

    public Battler getAttacker() {
        return attacker;
    }

    public void setAttacker(Battler attacker) {
        this.attacker = attacker;
    }

    public Battler getDefender() {
        return defender;
    }

    public void setDefender(Battler defender) {
        this.defender = defender;
    }

    public EndCondition getEndCondition() {
        return endCondition;
    }

    public void setEndCondition(EndCondition endCondition) {
        this.endCondition = endCondition;
    }

    public void surrender(){
        endCondition.surrender(this.attacker);
    }
}
