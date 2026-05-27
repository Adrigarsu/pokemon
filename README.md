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
│   ├── battle/       # Battle orchestration and Battler entity
│   ├── move/         # Move hierarchy: Tackle, Cascade, Combo...
│   ├── condition/    # Preconditions: Logical, Probabilistic, Battler, Number
│   ├── effect/       # Effects applied on success: Damage, Status, StatChange
│   └── number/       # Abstract numeric values: Fixed, Random, Combined
└── test/java/com/pokemon/
    └── ...           # mirrors main structure
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