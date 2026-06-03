package com.pokemon.battle.inventory;

import com.pokemon.action.effect.StatChange;
import com.pokemon.action.target.Attacker;
import com.pokemon.action.target.TargetInterface;
import com.pokemon.battle.Battle;
import com.pokemon.pokemon.Pokemon;
import com.pokemon.pokemon.status.*;

public class ItemFactory {

    private static final TargetInterface USER = new Attacker();




    //  HP restore

    // +20 HP to active Pokémon
    public static Item potion(int qty) {
        return healHP("Potion", "Restore 20 HP", 20, qty);
    }

    // +50 HP to active Pokémon
    public static Item superPotion(int qty) {
        return healHP("Super Potion", "Restore 50 HP", 50, qty);
    }

    // +200 HP to active Pokémon
    public static Item hyperPotion(int qty) {
        return healHP("Hyper Potion", "Restore 200 HP", 200, qty);
    }

    // Full HP restore to active Pokémon
    public static Item maxPotion(int qty) {
        return healHP("Max Potion", "Restore full HP", Integer.MAX_VALUE, qty);
    }

    // Full HP + cure all statuses to active Pokémon
    public static Item fullRestore(int qty) {
        return new Item("Full Restore", "Full HP + cure status",
            battle -> {
                Pokemon p = USER.resolve(battle).getActivePokemon();
                int restored = p.getMaxHP() - p.getHP();
                p.setHP(p.getMaxHP());
                p.clearStatuses();
                battle.log(p.getNickname() + " was fully restored! (+" + restored + " HP)", Battle.LogCategory.ITEM);
            }, qty, false);
    }




    //  Status cure

    // Cures poison
    public static Item antidote(int qty) {
        return cureStatus("Antidote", "Cure poison", PoisonStatus.class, qty);
    }

    // Cures burn
    public static Item burnHeal(int qty) {
        return cureStatus("Burn Heal", "Cure burn", BurnStatus.class, qty);
    }

    // Cures paralysis
    public static Item paralyzHeal(int qty) {
        return cureStatus("Paralyze Heal", "Cure paralysis", ParalysisStatus.class, qty);
    }

    // Cures sleep
    public static Item awakening(int qty) {
        return cureStatus("Awakening", "Cure sleep", SleepStatus.class, qty);
    }

    // Cures freeze
    public static Item iceHeal(int qty) {
        return cureStatus("Ice Heal", "Cure freeze", FreezeStatus.class, qty);
    }

    // Cures any status condition
    public static Item fullHeal(int qty) {
        return new Item("Full Heal", "Cure any status",
            battle -> {
                Pokemon p = USER.resolve(battle).getActivePokemon();
                p.clearStatuses();
                battle.log(p.getNickname() + " was cured of all conditions!", Battle.LogCategory.ITEM);
            }, qty, false);
    }


    //  Revive

    // Revive a fainted Pokémon to half HP (menu picks target)
    public static Item revive(int qty) {
        return new Item("Revive", "Revive to half HP", battle -> {}, qty, true);
    }

    // Revive a fainted Pokémon to full HP (menu picks target)
    public static Item maxRevive(int qty) {
        return new Item("Max Revive", "Revive to full HP", battle -> {}, qty, true);
    }


    //  Battle stat boosters

    // Raises Attack by 1 stage for this battle
    public static Item xAttack(int qty) {
        return boostStat("X Attack", "Attack +1 stage", StatChange.Stat.ATTACK, 1, qty);
    }

    // Raises Defense by 1 stage for this battle
    public static Item xDefend(int qty) {
        return boostStat("X Defend", "Defense +1 stage", StatChange.Stat.DEFENSE, 1, qty);
    }

    // Raises Special by 1 stage for this battle
    public static Item xSpecial(int qty) {
        return boostStat("X Special", "Special +1 stage", StatChange.Stat.SPECIAL, 1, qty);
    }


    //  Private helpers

    private static Item healHP(String name, String desc, int amount, int qty) {
        return new Item(name, desc,
            battle -> {
                Pokemon p = USER.resolve(battle).getActivePokemon();
                int restored = Math.min(amount, p.getMaxHP() - p.getHP());
                p.setHP(p.getHP() + restored);
                battle.log(p.getNickname() + " restored " + restored + " HP!", Battle.LogCategory.ITEM);
            }, qty, false);
    }

    private static Item cureStatus(String name, String desc,
                                    Class<? extends StatusInterface> type, int qty) {
        return new Item(name, desc,
            battle -> {
                Pokemon p = USER.resolve(battle).getActivePokemon();
                boolean cured = p.removeStatusOfType(type);
                battle.log(cured
                    ? p.getNickname() + " was cured of " + type.getSimpleName().replace("Status", "") + "!"
                    : "It won't have any effect...",
                    Battle.LogCategory.ITEM);
            }, qty, false);
    }

    private static Item boostStat(String name, String desc,
                                   StatChange.Stat stat, int stages, int qty) {
        return new Item(name, desc,
            battle -> {
                Pokemon p = USER.resolve(battle).getActivePokemon();
                switch (stat) {
                    case ATTACK  -> p.setAttackStage (p.getAttackStage()  + stages);
                    case DEFENSE -> p.setDefenseStage(p.getDefenseStage() + stages);
                    case SPECIAL -> p.setSpecialStage(p.getSpecialStage() + stages);
                }
                battle.log(p.getNickname() + "'s "
                    + stat.name().charAt(0) + stat.name().substring(1).toLowerCase()
                    + " rose!", Battle.LogCategory.ITEM);
            }, qty, false);
    }
}