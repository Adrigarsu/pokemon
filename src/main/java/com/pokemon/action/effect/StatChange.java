package com.pokemon.action.effect;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;

public class StatChange implements MoveEffectInterface {

    public enum Stat { ATTACK, DEFENSE, SPECIAL }

    private final TargetInterface target;
    private final Stat stat;
    private final int stages;

    public StatChange(TargetInterface target, Stat stat, int stages) {
        this.target = target;
        this.stat   = stat;
        this.stages = stages;
    }

    @Override
    public void apply(Battle battle) {
        Pokemon p = target.resolve(battle).getActivePokemon();
        switch (stat) {
            case ATTACK  -> p.setAttackStage (p.getAttackStage()  + stages);
            case DEFENSE -> p.setDefenseStage(p.getDefenseStage() + stages);
            case SPECIAL -> p.setSpecialStage(p.getSpecialStage() + stages);
        }
        String direction = stages > 0 ? "rose" : "fell";
        String statName  = stat.name().charAt(0) + stat.name().substring(1).toLowerCase();
        battle.log(p.getNickname() + "'s " + statName + " " + direction + "!", Battle.LogCategory.STAT);
    }
}