package com.pokemon.battle.inventory;

public class Item {

    private final String name;
    private final String description;
    private final Consumible effect;
    private int quantity;
    private final boolean requiresTarget;

    public Item(String name, String description, Consumible effect, int quantity, boolean requiresTarget) {
        this.name           = name;
        this.description    = description;
        this.effect         = effect;
        this.quantity       = quantity;
        this.requiresTarget = requiresTarget;
    }

    public String    getName()        { return name; }
    public String    getDescription() { return description; }
    public Consumible getEffect()     { return effect; }
    public int       getQuantity()    { return quantity; }
    public boolean   requiresTarget() { return requiresTarget; }
    public boolean   isAvailable()    { return quantity > 0; }

    public void use() { if (quantity > 0) quantity--; }
}