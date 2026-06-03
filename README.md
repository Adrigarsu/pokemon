# Pokemon Battle

A turn-based Gen 1 battle system built as an exercise in object-oriented design.

Inspired by [Rebuilding Pokémon with Object Oriented Programming](https://www.youtube.com/watch?v=CyRtTwKeulE)
by Christopher Okhravi.

---

## Features

- **151 Pokémon** — full Gen 1 Pokédex via `PokemonFactory`, each with correct base stats and a Gen 1-accurate starting moveset
- **72 moves** — damaging, stat-changing, multi-hit, and status moves via `MoveFactory`
- **Gen 1 damage formula** — `floor(((2L/5+2) × Power × A/D) / 50) + 2` with STAB and type effectiveness
- **Stat stages** — attack, defense, and special stages (−6 to +6) applied during damage calculation
- **7 status conditions** — paralysis, sleep, freeze, poison, badly poisoned, burn, confusion; each with correct Gen 1 mechanics
- **Battle items** — 17 Gen 1 items (potions, status cures, revives, X-items) via `ItemFactory`
- **Color-coded console UI** — damage in red, status in cyan, items in green, swaps in yellow, escape in purple
- **Dev mode** — `Battle.DEV_MODE = true` prints why a status application was rejected

---

## Requirements

- Java 17+
- Maven 3.8+

---

## Build and run

```bash
mvn compile
mvn exec:java -Dexec.mainClass=com.pokemon.Main -Dexec.args="Player1 Player2"
```

Or build a jar and run directly:

```bash
mvn package -DskipTests
java -cp target/classes com.pokemon.Main Player1 Player2
```

---

## Project structure

```
src/main/java/com/pokemon/
├── Main.java                        # Entry point — set up teams and start battle
├── action/
│   ├── condition/battleCond/        # HitsTarget (accuracy roll)
│   ├── effect/                      # DirectDamage, StatChange, ApplyStatus, HealEffect
│   ├── move/                        # Move, MoveFactory (72 moves), Attempt, Combo
│   ├── number/                      # DamageFormula, Between, Fixed
│   └── target/                      # Attacker / Defender resolvers
├── battle/
│   ├── Battle.java                  # Turn loop state, logger, status processing
│   ├── Battler.java                 # Player: team + active Pokémon + inventory
│   ├── EndCondition.java            # Win/lose logic
│   └── inventory/                   # Inventory, Item, ItemFactory, Consumible
├── pokemon/
│   ├── Pokemon.java                 # Stats, status list, stage fields
│   ├── PokemonFactory.java          # 151 named factory methods
│   ├── status/                      # 7 status classes + StatusInterface
│   └── type/                        # Type enum, TypeChart (Gen 1), MoveCategory
└── ui/
    ├── BattleUI.java                # Turn rendering, color logger, HP bars
    └── menu/                        # MoveMenu, ChangePokemonMenu, ObjectUseMenu, EscapeMenu
```

---
