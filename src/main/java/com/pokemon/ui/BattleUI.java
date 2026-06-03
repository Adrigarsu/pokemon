package com.pokemon.ui;

import com.pokemon.action.Action;
import com.pokemon.action.BackAction;
import com.pokemon.battle.Battle;
import com.pokemon.battle.Battler;
import com.pokemon.pokemon.Pokemon;
import com.pokemon.ui.menu.*;

import java.util.Scanner;

public class BattleUI {

    private static final String LINE   = "────────────────────────────────────────────────────────────────────────────────────";
    private static final String DLINE  = "════════════════════════════════════════════════════════════════════════════════════";

    private static final String RED    = "[31m";
    private static final String GREEN  = "[32m";
    private static final String YELLOW = "[33m";
    private static final String PURPLE = "[35m";
    private static final String CYAN   = "[36m";
    private static final String RESET  = "[0m";

    private final Scanner scanner = new Scanner(System.in);
    private final Battle battle;

    public BattleUI(Battle battle) {
        this.battle = battle;
        battle.setLogger((msg, cat) -> {
            String color = switch (cat) {
                case DAMAGE -> RED;
                case ITEM   -> GREEN;
                case SWAP   -> YELLOW;
                case ESCAPE -> PURPLE;
                case STATUS -> CYAN;
                case STAT   -> CYAN;
                default     -> "";
            };
            System.out.println("  " + color + msg + (color.isEmpty() ? "" : RESET));
            pause(700);
        });
    }

    public void run() {
        printTeamOverview();
        while (!battle.isOver()) {
            printTurnHeader();
            Action chosen = askPlayerAction();
            chosen.execute(battle);
            printPostAction();
            battle.swapTurns();
            battle.nextTurn();
        }
        printWinner();
    }


    private void printTeamOverview() {
        System.out.println(DLINE);
        printTeamRow(battle.getAttacker());
        System.out.println();
        printTeamRow(battle.getDefender());
        System.out.println(DLINE);
        System.out.println();
    }

    private void printTeamRow(Battler battler) {
        String namePrefix  = String.format("  %-8s", battler.getName().toUpperCase());
        String blankPrefix = " ".repeat(namePrefix.length());
        StringBuilder sb = new StringBuilder(namePrefix);
        int i = 0;
        for (Pokemon p : battler.getPokemons()) {
            if (i > 0 && i % 2 == 0) {
                System.out.println(sb);
                sb = new StringBuilder(blankPrefix);
            }
            sb.append(String.format("   %-12s %d/%d", p.getNickname(), p.getHP(), p.getMaxHP()));
            i++;
        }
        System.out.println(sb);
    }


    private void printTurnHeader() {
        System.out.println(LINE);
        System.out.printf("  TURN %-3d  ·  %s's turn%n%n",
                battle.getTurn(), battle.getAttacker().getName().toUpperCase());
        pause(400);
        System.out.printf("  %-8s  »  %s%n", battle.getDefender().getName(), formatActive(battle.getDefender()));
        pause(300);
        System.out.printf("  %-8s  »  %s%n%n", battle.getAttacker().getName(), formatActive(battle.getAttacker()));
        pause(300);
    }

    private static void pause(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    private String formatActive(Battler battler) {
        Pokemon p = battler.getActivePokemon();
        return String.format("%-14s  %-16s  %s  %d/%d HP",
                p.getNickname().toUpperCase(),
                "[" + p.getTypesPrint() + "]",
                hpBar(p.getHP(), p.getMaxHP()),
                p.getHP(), p.getMaxHP());
    }

    private String hpBar(int current, int max) {
        int filled = max > 0 ? (current * 10) / max : 0;
        return "[" + "#".repeat(filled) + ".".repeat(10 - filled) + "]";
    }

    // ── Post-action summary ───────────────────────────────────────────────────

    private void printPostAction() {
        pause(500);
        System.out.println();
        printActiveSummary(battle.getDefender());
        printActiveSummary(battle.getAttacker());
        System.out.println();
        pause(800);
    }

    private void printActiveSummary(Battler battler) {
        Pokemon p = battler.getActivePokemon();
        System.out.printf("  %-8s  %s  %d/%d HP%n",
                p.getNickname().toUpperCase(),
                hpBar(p.getHP(), p.getMaxHP()),
                p.getHP(), p.getMaxHP());
    }


    private Action askPlayerAction() {
        while (true) {
            System.out.println("  1. Attack   "
                    + GREEN  + "2. Inventory"  + RESET + "   "
                    + YELLOW + "3. Change Pokemon" + RESET + "   "
                    + PURPLE + "4. Escape" + RESET);
            System.out.print("  > ");
            int option = scanner.nextInt();
            while (option < 1 || option > 4) {
                System.out.print("  > ");
                option = scanner.nextInt();
            }

            MenuInterface subMenu = switch (option) {
                case 2 -> new ObjectUseMenu();
                case 3 -> new ChangePokemonMenu();
                case 4 -> new EscapeMenu();
                default -> new MoveMenu();
            };

            Action result = subMenu.selectSubmenuAction(battle);
            if (!(result instanceof BackAction)) return result;
        }
    }

    private void printWinner() {
        if (battle.isOver()) {
            Battler winner = battle.getWinner();
            System.out.println(DLINE);
            System.out.println("  WINNER: " + winner.getName().toUpperCase());
            System.out.println(DLINE);
        } else {
            throw new RuntimeException("printWinner() called before battle is over");
        }
    }
}