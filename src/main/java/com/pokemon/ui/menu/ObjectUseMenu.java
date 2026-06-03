package com.pokemon.ui.menu;

import com.pokemon.action.Action;
import com.pokemon.action.BackAction;
import com.pokemon.battle.Battle;
import com.pokemon.battle.inventory.Inventory;
import com.pokemon.battle.inventory.Item;
import com.pokemon.pokemon.Pokemon;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ObjectUseMenu implements MenuInterface {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Action selectSubmenuAction(Battle battle) {
        Inventory inv = battle.getAttacker().getInventory();

        if (inv == null || inv.isEmpty()) {
            System.out.println("  No items available.");
            return BackAction.INSTANCE;
        }

        Item selected = pickItem(inv);
        if (selected == null) return BackAction.INSTANCE;

        if (selected.requiresTarget()) {
            return handleRevive(battle, inv, selected);
        }

        return inv.use(selected);
    }

    private Item pickItem(Inventory inv) {
        List<Item> items = inv.getAvailableItems();
        System.out.println("  ITEMS");
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            System.out.printf("  %d. %-18s x%-3d  %s%n",
                    i + 1, it.getName(), it.getQuantity(), it.getDescription());
        }
        System.out.println("  0. Back");
        System.out.print("  > ");

        int choice = readInt(0, items.size());
        if (choice == 0) return null;
        return items.get(choice - 1);
    }

    private Action handleRevive(Battle battle, Inventory inv, Item item) {
        List<Pokemon> fainted = battle.getAttacker().getPokemons().stream()
                .filter(p -> p.getHP() == 0)
                .collect(Collectors.toList());

        if (fainted.isEmpty()) {
            System.out.println("  No fainted Pokémon to revive!");
            return BackAction.INSTANCE;
        }

        System.out.println("  Choose a Pokémon to revive:");
        for (int i = 0; i < fainted.size(); i++) {
            System.out.printf("  %d. %s%n", i + 1, fainted.get(i).getNickname());
        }
        System.out.print("  > ");

        int choice = readInt(1, fainted.size());
        return inv.use(item, fainted.get(choice - 1));
    }

    private int readInt(int min, int max) {
        int v = scanner.nextInt();
        while (v < min || v > max) {
            System.out.print("  > ");
            v = scanner.nextInt();
        }
        return v;
    }
}