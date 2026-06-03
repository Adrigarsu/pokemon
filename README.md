<div align="center">

[![header](https://capsule-render.vercel.app/api?type=waving&color=0:CC0000,50:FF3333,100:FF6666&height=260&section=header&text=Pokemon%20Battle&fontSize=80&fontColor=ffffff&animation=fadeIn&fontAlignY=40&desc=Gen%201%20%E2%80%A2%20Turn-based%20%E2%80%A2%20151%20Pok%C3%A9mon&descSize=22&descAlignY=62&descAlign=50)](https://github.com/Adrigarsu/pokemon)

</div>

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

The two arguments are the player names shown in the UI. You can use any names you want.

---

## Customizing the battle (Main.java)

All team and inventory setup lives in `src/main/java/com/pokemon/Main.java`. Edit it to choose which Pokémon each player uses and which items they carry.

### Adding Pokémon to a team

```java
ArrayList<Pokemon> pokemons1 = new ArrayList<>();
pokemons1.add(PokemonFactory.newCharizard("Liz"));
pokemons1.add(PokemonFactory.newBlastoise("Blasto"));
pokemons1.add(PokemonFactory.newMewtwo("Mew2"));
player1.setPokemons(pokemons1);
```

Each `PokemonFactory` method takes a **nickname** as its argument. Teams can have up to 6 Pokémon.

### Adding items to a player's bag

```java
Inventory inv1 = new Inventory();
inv1.add(ItemFactory.superPotion(3));   // 3x Super Potion
inv1.add(ItemFactory.fullHeal(2));      // 2x Full Heal
inv1.add(ItemFactory.revive(1));        // 1x Revive
player1.setInventory(inv1);
```

### Enabling Dev mode

Set this flag before the battle starts to print rejected status application reasons to the console:

```java
Battle.DEV_MODE = true;
```

---

## Available Pokémon

All 151 Gen 1 Pokémon are available via `PokemonFactory`. Method names follow the pattern `new<Name>(String nickname)`.

| # | Method | # | Method | # | Method |
|---|--------|---|--------|---|--------|
| 001 | `newBulbasaur` | 002 | `newIvysaur` | 003 | `newVenusaur` |
| 004 | `newCharmander` | 005 | `newCharmeleon` | 006 | `newCharizard` |
| 007 | `newSquirtle` | 008 | `newWartortle` | 009 | `newBlastoise` |
| 010 | `newCaterpie` | 011 | `newMetapod` | 012 | `newButterfree` |
| 013 | `newWeedle` | 014 | `newKakuna` | 015 | `newBeedrill` |
| 016 | `newPidgey` | 017 | `newPidgeotto` | 018 | `newPidgeot` |
| 019 | `newRattata` | 020 | `newRaticate` | 021 | `newSpearow` |
| 022 | `newFearow` | 023 | `newEkans` | 024 | `newArbok` |
| 025 | `newPikachu` | 026 | `newRaichu` | 027 | `newSandshrew` |
| 028 | `newSandslash` | 029 | `newNidoranF` | 030 | `newNidorina` |
| 031 | `newNidoqueen` | 032 | `newNidoranM` | 033 | `newNidorino` |
| 034 | `newNidoking` | 035 | `newClefairy` | 036 | `newClefable` |
| 037 | `newVulpix` | 038 | `newNinetales` | 039 | `newJigglypuff` |
| 040 | `newWigglytuff` | 041 | `newZubat` | 042 | `newGolbat` |
| 043 | `newOddish` | 044 | `newGloom` | 045 | `newVileplume` |
| 046 | `newParas` | 047 | `newParasect` | 048 | `newVenonat` |
| 049 | `newVenomoth` | 050 | `newDiglett` | 051 | `newDugtrio` |
| 052 | `newMeowth` | 053 | `newPersian` | 054 | `newPsyduck` |
| 055 | `newGolduck` | 056 | `newMankey` | 057 | `newPrimeape` |
| 058 | `newGrowlithe` | 059 | `newArcanine` | 060 | `newPoliwag` |
| 061 | `newPoliwhirl` | 062 | `newPoliwrath` | 063 | `newAbra` |
| 064 | `newKadabra` | 065 | `newAlakazam` | 066 | `newMachop` |
| 067 | `newMachoke` | 068 | `newMachamp` | 069 | `newBellsprout` |
| 070 | `newWeepinbell` | 071 | `newVictreebel` | 072 | `newTentacool` |
| 073 | `newTentacruel` | 074 | `newGeodude` | 075 | `newGraveler` |
| 076 | `newGolem` | 077 | `newPonyta` | 078 | `newRapidash` |
| 079 | `newSlowpoke` | 080 | `newSlowbro` | 081 | `newMagnemite` |
| 082 | `newMagneton` | 083 | `newFarfetchd` | 084 | `newDoduo` |
| 085 | `newDodrio` | 086 | `newSeel` | 087 | `newDewgong` |
| 088 | `newGrimer` | 089 | `newMuk` | 090 | `newShellder` |
| 091 | `newCloyster` | 092 | `newGastly` | 093 | `newHaunter` |
| 094 | `newGengar` | 095 | `newOnix` | 096 | `newDrowzee` |
| 097 | `newHypno` | 098 | `newKrabby` | 099 | `newKingler` |
| 100 | `newVoltorb` | 101 | `newElectrode` | 102 | `newExeggcute` |
| 103 | `newExeggutor` | 104 | `newCubone` | 105 | `newMarowak` |
| 106 | `newHitmonlee` | 107 | `newHitmonchan` | 108 | `newLickitung` |
| 109 | `newKoffing` | 110 | `newWeezing` | 111 | `newRhyhorn` |
| 112 | `newRhydon` | 113 | `newChansey` | 114 | `newTangela` |
| 115 | `newKangaskhan` | 116 | `newHorsea` | 117 | `newSeadra` |
| 118 | `newGoldeen` | 119 | `newSeaking` | 120 | `newStaryu` |
| 121 | `newStarmie` | 122 | `newMrMime` | 123 | `newScyther` |
| 124 | `newJynx` | 125 | `newElectabuzz` | 126 | `newMagmar` |
| 127 | `newPinsir` | 128 | `newTauros` | 129 | `newMagikarp` |
| 130 | `newGyarados` | 131 | `newLapras` | 132 | `newDitto` |
| 133 | `newEevee` | 134 | `newVaporeon` | 135 | `newJolteon` |
| 136 | `newFlareon` | 137 | `newPorygon` | 138 | `newOmanyte` |
| 139 | `newOmastar` | 140 | `newKabuto` | 141 | `newKabutops` |
| 142 | `newAerodactyl` | 143 | `newSnorlax` | 144 | `newArticuno` |
| 145 | `newZapdos` | 146 | `newMoltres` | 147 | `newDratini` |
| 148 | `newDragonair` | 149 | `newDragonite` | 150 | `newMewtwo` |
| 151 | `newMew` | | | | |

---

## Available items

All item factory methods take a **quantity** argument (how many the player starts with).

| Category | Method | Effect |
|----------|--------|--------|
| HP restore | `potion(qty)` | +20 HP |
| | `superPotion(qty)` | +50 HP |
| | `hyperPotion(qty)` | +200 HP |
| | `maxPotion(qty)` | Full HP |
| | `fullRestore(qty)` | Full HP + cure all statuses |
| Status cure | `antidote(qty)` | Cure poison |
| | `burnHeal(qty)` | Cure burn |
| | `paralyzHeal(qty)` | Cure paralysis |
| | `awakening(qty)` | Cure sleep |
| | `iceHeal(qty)` | Cure freeze |
| | `fullHeal(qty)` | Cure any status |
| Revive | `revive(qty)` | Revive fainted Pokémon to half HP |
| | `maxRevive(qty)` | Revive fainted Pokémon to full HP |
| Stat boost | `xAttack(qty)` | Attack +1 stage |
| | `xDefend(qty)` | Defense +1 stage |
| | `xSpecial(qty)` | Special +1 stage |

---

## Project structure

```
src/main/java/com/pokemon/
├── Main.java                        # Entry point — set up teams and start battle
├── action/
│   ├── condition/battleCond/        # HitsTarget (accuracy roll)
│   ├── effect/                      # DirectDamage, StatChange, ApplyStatus, HealEffect, Drain, OHKO
│   ├── move/                        # Move, MoveFactory (72 moves), Attempt, Combo, WithApplicability
│   ├── number/                      # DamageFormula, Between, Fixed, Weighted, arithmetic ops
│   └── target/                      # Attacker / Defender resolvers
├── battle/
│   ├── Battle.java                  # Turn loop state, logger, status processing, DEV_MODE flag
│   ├── Battler.java                 # Player: team + active Pokémon + inventory
│   ├── EndCondition.java            # Win/lose logic
│   ├── Meteorology.java             # Weather placeholder
│   └── inventory/                   # Inventory, Item, ItemFactory, Consumible, Potion
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