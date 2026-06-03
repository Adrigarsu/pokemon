package com.pokemon.action;

import com.pokemon.battle.Battle;
import com.pokemon.battle.inventory.Consumible;
import com.pokemon.battle.inventory.Item;
import com.pokemon.pokemon.Pokemon;

public class ObjectUse implements Action {

    private final Item item;
    private final Pokemon targetOverride; // non-null only for Revive / Max Revive

    public ObjectUse(Item item, Pokemon targetOverride) {
        this.item           = item;
        this.targetOverride = targetOverride;
    }

    @Override
    public void execute(Battle battle) {
        if (targetOverride != null) {
            // Revive: apply effect directly to the chosen fainted pokemon
            boolean isMaxRevive = item.getName().equals("Max Revive");
            int hp = isMaxRevive ? targetOverride.getMaxHP() : targetOverride.getMaxHP() / 2;
            targetOverride.setHP(hp);
            battle.log(targetOverride.getNickname() + " was revived with " + hp + " HP!",
                    Battle.LogCategory.ITEM);
        } else {
            item.getEffect().consume(battle);
        }
        item.use();
    }
}