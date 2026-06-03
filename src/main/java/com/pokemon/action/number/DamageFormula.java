package com.pokemon.action.number;

import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;
import com.pokemon.pokemon.type.MoveCategory;
import com.pokemon.pokemon.type.Type;
import com.pokemon.pokemon.type.TypeChart;

public class DamageFormula implements NumberInterface {

    private final TargetInterface attacker;
    private final TargetInterface defender;
    private final double power;
    private final Type moveType;
    private final MoveCategory category;

    public DamageFormula(TargetInterface attacker, TargetInterface defender,
                         double power, Type moveType, MoveCategory category) {
        this.attacker = attacker;
        this.defender = defender;
        this.power = power;
        this.moveType = moveType;
        this.category = category;
    }

    // Gen 1 formula: floor(((2*L/5+2) * Power * A/D) / 50) + 2  (with stat stages)
    @Override
    public double evaluate(Battle battle) {
        Pokemon atk = attacker.resolve(battle).getActivePokemon();
        Pokemon def = defender.resolve(battle).getActivePokemon();

        double level   = atk.getLevel();
        double atkStat = category == MoveCategory.PHYSICAL ? atk.getAttack()      : atk.getBaseSpecial();
        double defStat = category == MoveCategory.PHYSICAL ? def.getDefense()     : def.getBaseSpecial();

        atkStat *= stageMultiplier(category == MoveCategory.PHYSICAL ? atk.getAttackStage()  : atk.getSpecialStage());
        defStat *= stageMultiplier(category == MoveCategory.PHYSICAL ? def.getDefenseStage() : def.getSpecialStage());

        double base = Math.floor((2 * level / 5 + 2) * power * atkStat / Math.max(1, defStat) / 50) + 2;

        if (atk.getTypes().contains(moveType)) {
            base = Math.floor(base * 1.5);  // STAB
        }

        double typeMultiplier = 1.0;
        for (Type defType : def.getTypes()) {
            typeMultiplier *= TypeChart.getMultiplier(moveType, defType);
        }

        return Math.floor(base * typeMultiplier);
    }

    // Gen 1: stage >= 0 → (2+stage)/2, stage < 0 → 2/(2−stage)
    private static double stageMultiplier(int stage) {
        return stage >= 0 ? (2.0 + stage) / 2.0 : 2.0 / (2.0 - stage);
    }
}