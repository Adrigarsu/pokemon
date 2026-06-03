package com.pokemon.pokemon.status;

import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class ConfusionStatus implements StatusInterface {

    private int turnsLeft;

    public ConfusionStatus() {
        this.turnsLeft = 2 + (int) (Math.random() * 4); // 2-5 turns
    }

    @Override
    public boolean isPrimary() { return false; }

    @Override
    public boolean blocksMove(Pokemon pokemon, Battle battle) {
        turnsLeft--;
        if (turnsLeft <= 0) {
            pokemon.removeStatusOfType(ConfusionStatus.class);
            battle.log(pokemon.getNickname() + " snapped out of confusion!", Battle.LogCategory.STATUS);
            return false;
        }
        battle.log(pokemon.getNickname() + " is confused!", Battle.LogCategory.STATUS);
        if (Math.random() < 0.5) {
            int lv  = pokemon.getLevel();
            int atk = pokemon.getAttack();
            int def = Math.max(1, pokemon.getDefense());
            int dmg = (int) Math.floor((2.0 * lv / 5 + 2) * 40 * atk / def / 50) + 2;
            pokemon.setHP(Math.max(0, pokemon.getHP() - dmg));
            battle.log(pokemon.getNickname() + " hurt itself in confusion! (-" + dmg + " HP)", Battle.LogCategory.DAMAGE);
            return true;
        }
        return false;
    }

    @Override
    public void onEndOfTurn(Pokemon pokemon, Battle battle) {}
}