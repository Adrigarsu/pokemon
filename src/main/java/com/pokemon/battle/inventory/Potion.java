package com.pokemon.battle.inventory;

import com.pokemon.action.target.Attacker;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class Potion implements Consumible {

    private final int healAmount;
    private final Attacker target = new Attacker();

    public Potion(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void consume(Battle battle) {
        Pokemon p = target.resolve(battle).getActivePokemon();
        int restored = Math.min(healAmount, p.getMaxHP() - p.getHP());
        p.setHP(p.getHP() + restored);
        battle.log(p.getNickname() + " restored " + restored + " HP!", Battle.LogCategory.ITEM);
    }
}