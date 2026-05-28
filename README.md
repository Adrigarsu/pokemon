# Pokemon Battle

A turn-based battle system modelled after the core mechanics of the Pokémon games,
built as an exercise in object-oriented design.

Inspired by [Rebuilding Pokémon with Object Oriented Programming](https://www.youtube.com/watch?v=CyRtTwKeulE)
by Christopher Okhravi.
 
---

## Project structure

```
src/
├── main/java/com/pokemon/
│   ├── action/               # Everything that can happen in a turn
│   │   ├── condition/        # Preconditions: Logical, Probabilistic, Battler, Number
│   │   ├── effect/           # Effects applied on success: Damage, Status, StatChange
│   │   ├── move/             # Move hierarchy: Tackle, Cascade, Combo...
│   │   ├── number/           # Abstract numeric values: Fixed, Random, Combined
│   │   └── Action.java       # Action supertype
│   ├── battle/               # Battle orchestration
│   │   ├── Battle.java       # Manages the battle flow
│   │   ├── Turn.java         # Represents a single turn
│   │   └── EndCondition.java # Determines when the battle ends
│   └── Main.java
└── test/java/com/pokemon/
    └── ...                   # mirrors main structure
```

## Requirements

- Java 17+
- Maven 3.8+
## Build and run

```bash
# Compile
mvn compile
 
# Run tests
mvn test
 
# Run a specific test class
mvn test -Dtest=BattleTest
```