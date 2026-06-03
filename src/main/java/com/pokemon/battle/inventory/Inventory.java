package com.pokemon.battle.inventory;

import com.pokemon.action.Action;
import com.pokemon.action.ObjectUse;
import com.pokemon.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private final List<Item> items = new ArrayList<>();

    public void add(Item item) { items.add(item); }

    public List<Item> getAvailableItems() {
        return items.stream().filter(Item::isAvailable).collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return getAvailableItems().isEmpty();
    }

    // Normal item: target is already baked into the item's Consumible
    public Action use(Item item) {
        return new ObjectUse(item, null);
    }

    // Revive: menu provides the specific fainted pokemon as a target override
    public Action use(Item item, Pokemon targetOverride) {
        return new ObjectUse(item, targetOverride);
    }
}