package com.pokemon.battle;


import com.pokemon.pokemon.Pokemon;

import java.util.function.BiConsumer;

public class Battle {

    public enum LogCategory { INFO, DAMAGE, STATUS, STAT, ITEM, SWAP, ESCAPE, DEV }

    public static boolean DEV_MODE = true;

    private Battler attacker;
    private Battler defender;

    private EndCondition endCondition;
    private int turn = 1;

    private BiConsumer<String, LogCategory> logger = (s, c) -> {};

    public Battle(Battler attacker, Battler defender) {
        this.attacker = attacker;
        this.defender = defender;
        this.endCondition = new EndCondition();
    }

    public boolean isOver() {
        return endCondition.isOver(attacker, defender);
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

    public void processEndOfTurnStatuses() {
        attacker.getActivePokemon().applyEndOfTurn(this);
        defender.getActivePokemon().applyEndOfTurn(this);
    }

    public void log(String message) { logger.accept(message, LogCategory.INFO); }

    public void log(String message, LogCategory category) { logger.accept(message, category); }

    public void setLogger(BiConsumer<String, LogCategory> logger) { this.logger = logger; }

    public int getTurn() { return turn; }

    public void nextTurn() { turn++; }

    public void swapTurns() {
        Battler temp = attacker;
        attacker = defender;
        defender = temp;
    }

    public String battleStatusPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("-------------------------------------------------\n");
        sb.append("POKEMONS of ").append(attacker.getName()).append("\n");
        for (Pokemon pokemon : attacker.getPokemons()){
            sb.append(pokemon.getMenuPrint());
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("POKEMONS of ").append(defender.getName()).append("\n");
        for (Pokemon pokemon : defender.getPokemons()){
            sb.append(pokemon.getMenuPrint());
            sb.append("\n");
        }
        sb.append("-------------------------------------------------\n");

        return sb.toString();
    }


    public String battlerInfoPrint(Battler battler){
        StringBuilder sb = new StringBuilder();

        sb.append("Opponent :").append(battler.getName().toUpperCase()).append("\n");
        //Name
        sb.append(battler.getActivePokemon().getNickname().toUpperCase()).append(" ");
        //Type
        sb.append(battler.getActivePokemon().getTypesPrint()).append(" ");
        //HP
        sb.append(battler.getActivePokemon().getHPPrint()).append("\n");

        return sb.toString();
    }
}
