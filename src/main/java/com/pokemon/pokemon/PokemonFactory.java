package com.pokemon.pokemon;

import com.pokemon.action.move.MoveInterface;
import com.pokemon.pokemon.type.Type;

import java.util.ArrayList;
import java.util.List;

import static com.pokemon.action.move.MoveFactory.*;

public class PokemonFactory {

    // HP = floor(baseHP / 10) + 15  (Gen 1 level-5 approximation)
    // Other stats = raw Gen 1 base stats

    // #001–003 Bulbasaur line
    public static Pokemon newBulbasaur(String n) {
        Pokemon p = base("Bulbasaur", n, 5, Type.GRASS, Type.POISON, 19, 49, 49, 65, 45);
        p.attacks = moves(tackle(), growl());
        return p;
    }
    public static Pokemon newIvysaur(String n) {
        Pokemon p = base("Ivysaur", n, 5, Type.GRASS, Type.POISON, 21, 62, 63, 80, 60);
        p.attacks = moves(vineWhip(), growl(), tackle());
        return p;
    }
    public static Pokemon newVenusaur(String n) {
        Pokemon p = base("Venusaur", n, 5, Type.GRASS, Type.POISON, 23, 82, 83, 100, 80);
        p.attacks = moves(vineWhip(), razorLeaf(), solarBeam(), growl());
        return p;
    }

    // #004–006 Charmander line
    public static Pokemon newCharmander(String n) {
        Pokemon p = base("Charmander", n, 5, Type.FIRE, Type.NONE, 18, 52, 43, 60, 65);
        p.attacks = moves(scratch(), growl());
        return p;
    }
    public static Pokemon newCharmeleon(String n) {
        Pokemon p = base("Charmeleon", n, 5, Type.FIRE, Type.NONE, 20, 64, 58, 80, 80);
        p.attacks = moves(scratch(), growl(), ember());
        return p;
    }
    public static Pokemon newCharizard(String n) {
        Pokemon p = base("Charizard", n, 5, Type.FIRE, Type.FLYING, 22, 84, 78, 109, 100);
        p.attacks = moves(scratch(), ember(), flamethrower(), slash());
        return p;
    }

    // #007–009 Squirtle line
    public static Pokemon newSquirtle(String n) {
        Pokemon p = base("Squirtle", n, 5, Type.WATER, Type.NONE, 19, 48, 65, 50, 43);
        p.attacks = moves(tackle(), tailWhip());
        return p;
    }
    public static Pokemon newWartortle(String n) {
        Pokemon p = base("Wartortle", n, 5, Type.WATER, Type.NONE, 20, 63, 80, 65, 58);
        p.attacks = moves(tackle(), tailWhip(), waterGun());
        return p;
    }
    public static Pokemon newBlastoise(String n) {
        Pokemon p = base("Blastoise", n, 5, Type.WATER, Type.NONE, 22, 83, 100, 85, 78);
        p.attacks = moves(waterGun(), withdraw(), surf(), hydroPump());
        return p;
    }

    // #010–012 Caterpie line
    public static Pokemon newCaterpie(String n) {
        Pokemon p = base("Caterpie", n, 5, Type.BUG, Type.NONE, 19, 30, 35, 20, 45);
        p.attacks = moves(tackle());
        return p;
    }
    public static Pokemon newMetapod(String n) {
        Pokemon p = base("Metapod", n, 5, Type.BUG, Type.NONE, 20, 20, 55, 25, 30);
        p.attacks = moves(tackle(), harden());
        return p;
    }
    public static Pokemon newButterfree(String n) {
        Pokemon p = base("Butterfree", n, 5, Type.BUG, Type.FLYING, 21, 45, 50, 80, 70);
        p.attacks = moves(tackle(), psybeam(), confuseRay());
        return p;
    }

    // #013–015 Weedle line
    public static Pokemon newWeedle(String n) {
        Pokemon p = base("Weedle", n, 5, Type.BUG, Type.POISON, 19, 35, 30, 20, 50);
        p.attacks = moves(poisonSting(), tackle());
        return p;
    }
    public static Pokemon newKakuna(String n) {
        Pokemon p = base("Kakuna", n, 5, Type.BUG, Type.POISON, 19, 25, 50, 25, 35);
        p.attacks = moves(tackle(), harden());
        return p;
    }
    public static Pokemon newBeedrill(String n) {
        Pokemon p = base("Beedrill", n, 5, Type.BUG, Type.POISON, 21, 80, 40, 45, 75);
        p.attacks = moves(poisonSting(), furyAttack(), twineedle());
        return p;
    }

    // #016–018 Pidgey line
    public static Pokemon newPidgey(String n) {
        Pokemon p = base("Pidgey", n, 5, Type.NORMAL, Type.FLYING, 19, 45, 40, 35, 56);
        p.attacks = moves(tackle(), peck());
        return p;
    }
    public static Pokemon newPidgeotto(String n) {
        Pokemon p = base("Pidgeotto", n, 5, Type.NORMAL, Type.FLYING, 21, 60, 55, 50, 71);
        p.attacks = moves(peck(), growl(), wingAttack());
        return p;
    }
    public static Pokemon newPidgeot(String n) {
        Pokemon p = base("Pidgeot", n, 5, Type.NORMAL, Type.FLYING, 23, 80, 75, 70, 91);
        p.attacks = moves(peck(), wingAttack(), drillPeck(), quickAttack());
        return p;
    }

    // #019–020 Rattata line
    public static Pokemon newRattata(String n) {
        Pokemon p = base("Rattata", n, 5, Type.NORMAL, Type.NONE, 18, 56, 35, 25, 72);
        p.attacks = moves(tackle(), tailWhip());
        return p;
    }
    public static Pokemon newRaticate(String n) {
        Pokemon p = base("Raticate", n, 5, Type.NORMAL, Type.NONE, 20, 81, 60, 50, 97);
        p.attacks = moves(tackle(), bite(), hyperBeam());
        return p;
    }

    // #021–022 Spearow line
    public static Pokemon newSpearow(String n) {
        Pokemon p = base("Spearow", n, 5, Type.NORMAL, Type.FLYING, 19, 60, 30, 31, 70);
        p.attacks = moves(peck(), growl(), furyAttack());
        return p;
    }
    public static Pokemon newFearow(String n) {
        Pokemon p = base("Fearow", n, 5, Type.NORMAL, Type.FLYING, 21, 90, 65, 61, 100);
        p.attacks = moves(peck(), furyAttack(), drillPeck());
        return p;
    }

    // #023–024 Ekans line
    public static Pokemon newEkans(String n) {
        Pokemon p = base("Ekans", n, 5, Type.POISON, Type.NONE, 18, 60, 44, 40, 55);
        p.attacks = moves(wrap(), leer());
        return p;
    }
    public static Pokemon newArbok(String n) {
        Pokemon p = base("Arbok", n, 5, Type.POISON, Type.NONE, 21, 85, 69, 65, 80);
        p.attacks = moves(wrap(), leer(), bite(), acid());
        return p;
    }

    // #025–026 Pikachu line
    public static Pokemon newPikachu(String n) {
        Pokemon p = base("Pikachu", n, 5, Type.ELECTRIC, Type.NONE, 18, 55, 30, 50, 90);
        p.attacks = moves(thundershock(), growl());
        return p;
    }
    public static Pokemon newRaichu(String n) {
        Pokemon p = base("Raichu", n, 5, Type.ELECTRIC, Type.NONE, 21, 90, 55, 90, 100);
        p.attacks = moves(thundershock(), thunderWave(), thunderbolt(), thunder());
        return p;
    }

    // #027–028 Sandshrew line
    public static Pokemon newSandshrew(String n) {
        Pokemon p = base("Sandshrew", n, 5, Type.GROUND, Type.NONE, 20, 75, 85, 30, 40);
        p.attacks = moves(scratch(), defenseCurl());
        return p;
    }
    public static Pokemon newSandslash(String n) {
        Pokemon p = base("Sandslash", n, 5, Type.GROUND, Type.NONE, 22, 100, 110, 55, 65);
        p.attacks = moves(scratch(), furySwipes(), slash(), earthquake());
        return p;
    }

    // #029–031 Nidoran♀ line
    public static Pokemon newNidoranF(String n) {
        Pokemon p = base("Nidoran♀", n, 5, Type.POISON, Type.NONE, 20, 47, 52, 40, 41);
        p.attacks = moves(scratch(), growl());
        return p;
    }
    public static Pokemon newNidorina(String n) {
        Pokemon p = base("Nidorina", n, 5, Type.POISON, Type.NONE, 22, 62, 67, 55, 56);
        p.attacks = moves(scratch(), growl(), bite());
        return p;
    }
    public static Pokemon newNidoqueen(String n) {
        Pokemon p = base("Nidoqueen", n, 5, Type.POISON, Type.GROUND, 24, 82, 87, 75, 76);
        p.attacks = moves(bodySlam(), earthquake(), scratch());
        return p;
    }

    // #032–034 Nidoran♂ line
    public static Pokemon newNidoranM(String n) {
        Pokemon p = base("Nidoran♂", n, 5, Type.POISON, Type.NONE, 19, 57, 40, 40, 50);
        p.attacks = moves(leer(), peck());
        return p;
    }
    public static Pokemon newNidorino(String n) {
        Pokemon p = base("Nidorino", n, 5, Type.POISON, Type.NONE, 21, 72, 57, 55, 65);
        p.attacks = moves(hornAttack(), leer(), furyAttack());
        return p;
    }
    public static Pokemon newNidoking(String n) {
        Pokemon p = base("Nidoking", n, 5, Type.POISON, Type.GROUND, 23, 92, 77, 85, 85);
        p.attacks = moves(earthquake(), bodySlam(), hornAttack());
        return p;
    }

    // #035–036 Clefairy line
    public static Pokemon newClefairy(String n) {
        Pokemon p = base("Clefairy", n, 5, Type.NORMAL, Type.NONE, 22, 45, 48, 60, 35);
        p.attacks = moves(pound(), growl());
        return p;
    }
    public static Pokemon newClefable(String n) {
        Pokemon p = base("Clefable", n, 5, Type.NORMAL, Type.NONE, 24, 70, 73, 85, 60);
        p.attacks = moves(sing(), pound(), bodySlam(), megaKick());
        return p;
    }

    // #037–038 Vulpix line
    public static Pokemon newVulpix(String n) {
        Pokemon p = base("Vulpix", n, 5, Type.FIRE, Type.NONE, 18, 41, 40, 65, 65);
        p.attacks = moves(ember(), tailWhip());
        return p;
    }
    public static Pokemon newNinetales(String n) {
        Pokemon p = base("Ninetales", n, 5, Type.FIRE, Type.NONE, 22, 76, 75, 100, 100);
        p.attacks = moves(ember(), flamethrower(), fireBlast());
        return p;
    }

    // #039–040 Jigglypuff line
    public static Pokemon newJigglypuff(String n) {
        Pokemon p = base("Jigglypuff", n, 5, Type.NORMAL, Type.NONE, 26, 45, 20, 25, 20);
        p.attacks = moves(sing(), pound());
        return p;
    }
    public static Pokemon newWigglytuff(String n) {
        Pokemon p = base("Wigglytuff", n, 5, Type.NORMAL, Type.NONE, 29, 70, 45, 50, 45);
        p.attacks = moves(sing(), pound(), bodySlam());
        return p;
    }

    // #041–042 Zubat line
    public static Pokemon newZubat(String n) {
        Pokemon p = base("Zubat", n, 5, Type.POISON, Type.FLYING, 19, 45, 35, 40, 55);
        p.attacks = moves(bite(), wingAttack());
        return p;
    }
    public static Pokemon newGolbat(String n) {
        Pokemon p = base("Golbat", n, 5, Type.POISON, Type.FLYING, 22, 80, 70, 75, 90);
        p.attacks = moves(bite(), wingAttack(), confuseRay(), leechLife());
        return p;
    }

    // #043–045 Oddish line
    public static Pokemon newOddish(String n) {
        Pokemon p = base("Oddish", n, 5, Type.GRASS, Type.POISON, 19, 50, 55, 75, 30);
        p.attacks = moves(absorb(), acid());
        return p;
    }
    public static Pokemon newGloom(String n) {
        Pokemon p = base("Gloom", n, 5, Type.GRASS, Type.POISON, 21, 65, 70, 85, 40);
        p.attacks = moves(absorb(), acid(), poisonSting());
        return p;
    }
    public static Pokemon newVileplume(String n) {
        Pokemon p = base("Vileplume", n, 5, Type.GRASS, Type.POISON, 22, 80, 85, 100, 50);
        p.attacks = moves(megaDrain(), acid(), razorLeaf(), solarBeam());
        return p;
    }

    // #046–047 Paras line
    public static Pokemon newParas(String n) {
        Pokemon p = base("Paras", n, 5, Type.BUG, Type.GRASS, 18, 70, 55, 55, 25);
        p.attacks = moves(scratch(), stunSpore(), leechLife());
        return p;
    }
    public static Pokemon newParasect(String n) {
        Pokemon p = base("Parasect", n, 5, Type.BUG, Type.GRASS, 21, 95, 80, 60, 30);
        p.attacks = moves(scratch(), stunSpore(), leechLife(), slash());
        return p;
    }

    // #048–049 Venonat line
    public static Pokemon newVenonat(String n) {
        Pokemon p = base("Venonat", n, 5, Type.BUG, Type.POISON, 21, 55, 50, 40, 45);
        p.attacks = moves(tackle(), psybeam());
        return p;
    }
    public static Pokemon newVenomoth(String n) {
        Pokemon p = base("Venomoth", n, 5, Type.BUG, Type.POISON, 22, 65, 60, 90, 90);
        p.attacks = moves(tackle(), psybeam(), psychic(), stunSpore());
        return p;
    }

    // #050–051 Diglett line
    public static Pokemon newDiglett(String n) {
        Pokemon p = base("Diglett", n, 5, Type.GROUND, Type.NONE, 16, 55, 25, 45, 95);
        p.attacks = moves(scratch(), growl());
        return p;
    }
    public static Pokemon newDugtrio(String n) {
        Pokemon p = base("Dugtrio", n, 5, Type.GROUND, Type.NONE, 18, 80, 50, 70, 120);
        p.attacks = moves(scratch(), slash(), earthquake());
        return p;
    }

    // #052–053 Meowth line
    public static Pokemon newMeowth(String n) {
        Pokemon p = base("Meowth", n, 5, Type.NORMAL, Type.NONE, 19, 45, 35, 40, 90);
        p.attacks = moves(scratch(), growl());
        return p;
    }
    public static Pokemon newPersian(String n) {
        Pokemon p = base("Persian", n, 5, Type.NORMAL, Type.NONE, 21, 70, 60, 65, 115);
        p.attacks = moves(scratch(), growl(), slash(), bite());
        return p;
    }

    // #054–055 Psyduck line
    public static Pokemon newPsyduck(String n) {
        Pokemon p = base("Psyduck", n, 5, Type.WATER, Type.NONE, 20, 52, 48, 50, 55);
        p.attacks = moves(scratch(), tailWhip());
        return p;
    }
    public static Pokemon newGolduck(String n) {
        Pokemon p = base("Golduck", n, 5, Type.WATER, Type.NONE, 23, 82, 78, 80, 85);
        p.attacks = moves(waterGun(), confusion(), psychic());
        return p;
    }

    // #056–057 Mankey line
    public static Pokemon newMankey(String n) {
        Pokemon p = base("Mankey", n, 5, Type.FIGHTING, Type.NONE, 19, 80, 35, 35, 70);
        p.attacks = moves(scratch(), leer(), lowKick());
        return p;
    }
    public static Pokemon newPrimeape(String n) {
        Pokemon p = base("Primeape", n, 5, Type.FIGHTING, Type.NONE, 21, 105, 60, 60, 95);
        p.attacks = moves(lowKick(), karaChop(), scratch(), submission());
        return p;
    }

    // #058–059 Growlithe line
    public static Pokemon newGrowlithe(String n) {
        Pokemon p = base("Growlithe", n, 5, Type.FIRE, Type.NONE, 20, 70, 45, 70, 60);
        p.attacks = moves(bite(), ember());
        return p;
    }
    public static Pokemon newArcanine(String n) {
        Pokemon p = base("Arcanine", n, 5, Type.FIRE, Type.NONE, 24, 110, 80, 80, 95);
        p.attacks = moves(bite(), ember(), flamethrower(), fireBlast());
        return p;
    }

    // #060–062 Poliwag line
    public static Pokemon newPoliwag(String n) {
        Pokemon p = base("Poliwag", n, 5, Type.WATER, Type.NONE, 19, 50, 40, 40, 90);
        p.attacks = moves(waterGun(), hypnosis());
        return p;
    }
    public static Pokemon newPoliwhirl(String n) {
        Pokemon p = base("Poliwhirl", n, 5, Type.WATER, Type.NONE, 21, 65, 65, 50, 90);
        p.attacks = moves(waterGun(), hypnosis(), bodySlam());
        return p;
    }
    public static Pokemon newPoliwrath(String n) {
        Pokemon p = base("Poliwrath", n, 5, Type.WATER, Type.FIGHTING, 24, 85, 95, 70, 70);
        p.attacks = moves(waterGun(), hypnosis(), bodySlam(), submission());
        return p;
    }

    // #063–065 Abra line
    public static Pokemon newAbra(String n) {
        Pokemon p = base("Abra", n, 5, Type.PSYCHIC, Type.NONE, 17, 20, 15, 105, 90);
        p.attacks = moves(teleport());
        return p;
    }
    public static Pokemon newKadabra(String n) {
        Pokemon p = base("Kadabra", n, 5, Type.PSYCHIC, Type.NONE, 19, 35, 30, 120, 105);
        p.attacks = moves(teleport(), psybeam(), psychic());
        return p;
    }
    public static Pokemon newAlakazam(String n) {
        Pokemon p = base("Alakazam", n, 5, Type.PSYCHIC, Type.NONE, 20, 50, 45, 135, 120);
        p.attacks = moves(teleport(), psychic(), recover());
        return p;
    }

    // #066–068 Machop line
    public static Pokemon newMachop(String n) {
        Pokemon p = base("Machop", n, 5, Type.FIGHTING, Type.NONE, 22, 80, 50, 35, 35);
        p.attacks = moves(karaChop(), lowKick());
        return p;
    }
    public static Pokemon newMachoke(String n) {
        Pokemon p = base("Machoke", n, 5, Type.FIGHTING, Type.NONE, 23, 100, 70, 50, 45);
        p.attacks = moves(karaChop(), lowKick(), strength(), submission());
        return p;
    }
    public static Pokemon newMachamp(String n) {
        Pokemon p = base("Machamp", n, 5, Type.FIGHTING, Type.NONE, 24, 130, 80, 65, 55);
        p.attacks = moves(karaChop(), submission(), strength(), megaKick());
        return p;
    }

    // #069–071 Bellsprout line
    public static Pokemon newBellsprout(String n) {
        Pokemon p = base("Bellsprout", n, 5, Type.GRASS, Type.POISON, 20, 75, 35, 70, 40);
        p.attacks = moves(vineWhip(), growth());
        return p;
    }
    public static Pokemon newWeepinbell(String n) {
        Pokemon p = base("Weepinbell", n, 5, Type.GRASS, Type.POISON, 21, 90, 50, 85, 55);
        p.attacks = moves(vineWhip(), growth(), acid(), razorLeaf());
        return p;
    }
    public static Pokemon newVictreebel(String n) {
        Pokemon p = base("Victreebel", n, 5, Type.GRASS, Type.POISON, 23, 105, 65, 100, 70);
        p.attacks = moves(vineWhip(), acid(), razorLeaf(), solarBeam());
        return p;
    }

    // #072–073 Tentacool line
    public static Pokemon newTentacool(String n) {
        Pokemon p = base("Tentacool", n, 5, Type.WATER, Type.POISON, 19, 40, 35, 100, 70);
        p.attacks = moves(waterGun(), acid());
        return p;
    }
    public static Pokemon newTentacruel(String n) {
        Pokemon p = base("Tentacruel", n, 5, Type.WATER, Type.POISON, 23, 70, 65, 120, 100);
        p.attacks = moves(waterGun(), acid(), hydroPump(), wrap());
        return p;
    }

    // #074–076 Geodude line
    public static Pokemon newGeodude(String n) {
        Pokemon p = base("Geodude", n, 5, Type.ROCK, Type.GROUND, 19, 80, 100, 30, 20);
        p.attacks = moves(tackle(), defenseCurl());
        return p;
    }
    public static Pokemon newGraveler(String n) {
        Pokemon p = base("Graveler", n, 5, Type.ROCK, Type.GROUND, 20, 95, 115, 45, 35);
        p.attacks = moves(rockThrow(), defenseCurl(), earthquake());
        return p;
    }
    public static Pokemon newGolem(String n) {
        Pokemon p = base("Golem", n, 5, Type.ROCK, Type.GROUND, 23, 110, 130, 55, 45);
        p.attacks = moves(rockThrow(), earthquake(), bodySlam());
        return p;
    }

    // #077–078 Ponyta line
    public static Pokemon newPonyta(String n) {
        Pokemon p = base("Ponyta", n, 5, Type.FIRE, Type.NONE, 20, 85, 55, 65, 90);
        p.attacks = moves(ember(), tailWhip(), stomp());
        return p;
    }
    public static Pokemon newRapidash(String n) {
        Pokemon p = base("Rapidash", n, 5, Type.FIRE, Type.NONE, 21, 100, 70, 80, 105);
        p.attacks = moves(ember(), stomp(), fireBlast(), slash());
        return p;
    }

    // #079–080 Slowpoke line
    public static Pokemon newSlowpoke(String n) {
        Pokemon p = base("Slowpoke", n, 5, Type.WATER, Type.PSYCHIC, 24, 65, 65, 40, 15);
        p.attacks = moves(waterGun(), confusion(), headbutt());
        return p;
    }
    public static Pokemon newSlowbro(String n) {
        Pokemon p = base("Slowbro", n, 5, Type.WATER, Type.PSYCHIC, 24, 75, 110, 80, 30);
        p.attacks = moves(waterGun(), confusion(), psychic(), amnesia());
        return p;
    }

    // #081–082 Magnemite line
    public static Pokemon newMagnemite(String n) {
        Pokemon p = base("Magnemite", n, 5, Type.ELECTRIC, Type.NONE, 17, 35, 70, 95, 45);
        p.attacks = moves(thundershock(), thunderWave());
        return p;
    }
    public static Pokemon newMagneton(String n) {
        Pokemon p = base("Magneton", n, 5, Type.ELECTRIC, Type.NONE, 20, 60, 95, 120, 70);
        p.attacks = moves(thundershock(), thunderWave(), thunderbolt());
        return p;
    }

    // #083 Farfetch'd
    public static Pokemon newFarfetchd(String n) {
        Pokemon p = base("Farfetch'd", n, 5, Type.NORMAL, Type.FLYING, 20, 65, 55, 58, 60);
        p.attacks = moves(peck(), scratch(), cut(), slash());
        return p;
    }

    // #084–085 Doduo line
    public static Pokemon newDoduo(String n) {
        Pokemon p = base("Doduo", n, 5, Type.NORMAL, Type.FLYING, 18, 85, 45, 35, 75);
        p.attacks = moves(peck(), growl(), furyAttack());
        return p;
    }
    public static Pokemon newDodrio(String n) {
        Pokemon p = base("Dodrio", n, 5, Type.NORMAL, Type.FLYING, 21, 110, 70, 60, 100);
        p.attacks = moves(peck(), furyAttack(), drillPeck());
        return p;
    }

    // #086–087 Seel line
    public static Pokemon newSeel(String n) {
        Pokemon p = base("Seel", n, 5, Type.WATER, Type.NONE, 21, 45, 55, 70, 45);
        p.attacks = moves(headbutt(), growl());
        return p;
    }
    public static Pokemon newDewgong(String n) {
        Pokemon p = base("Dewgong", n, 5, Type.WATER, Type.ICE, 24, 70, 80, 95, 70);
        p.attacks = moves(headbutt(), growl(), iceBeam(), surf());
        return p;
    }

    // #088–089 Grimer line
    public static Pokemon newGrimer(String n) {
        Pokemon p = base("Grimer", n, 5, Type.POISON, Type.NONE, 23, 80, 50, 40, 25);
        p.attacks = moves(pound(), smog(), sludge());
        return p;
    }
    public static Pokemon newMuk(String n) {
        Pokemon p = base("Muk", n, 5, Type.POISON, Type.NONE, 25, 105, 75, 65, 50);
        p.attacks = moves(pound(), smog(), sludge(), bodySlam());
        return p;
    }

    // #090–091 Shellder line
    public static Pokemon newShellder(String n) {
        Pokemon p = base("Shellder", n, 5, Type.WATER, Type.NONE, 18, 65, 100, 45, 40);
        p.attacks = moves(tackle(), withdraw());
        return p;
    }
    public static Pokemon newCloyster(String n) {
        Pokemon p = base("Cloyster", n, 5, Type.WATER, Type.ICE, 20, 95, 180, 85, 70);
        p.attacks = moves(tackle(), withdraw(), iceBeam(), blizzard());
        return p;
    }

    // #092–094 Gastly line
    public static Pokemon newGastly(String n) {
        Pokemon p = base("Gastly", n, 5, Type.GHOST, Type.POISON, 18, 35, 30, 100, 80);
        p.attacks = moves(lick(), confuseRay());
        return p;
    }
    public static Pokemon newHaunter(String n) {
        Pokemon p = base("Haunter", n, 5, Type.GHOST, Type.POISON, 19, 50, 45, 115, 95);
        p.attacks = moves(lick(), confuseRay(), hypnosis());
        return p;
    }
    public static Pokemon newGengar(String n) {
        Pokemon p = base("Gengar", n, 5, Type.GHOST, Type.POISON, 21, 65, 60, 130, 110);
        p.attacks = moves(lick(), confuseRay(), hypnosis(), psychic());
        return p;
    }

    // #095 Onix
    public static Pokemon newOnix(String n) {
        Pokemon p = base("Onix", n, 5, Type.ROCK, Type.GROUND, 18, 45, 160, 30, 70);
        p.attacks = moves(tackle(), screech(), rockThrow());
        return p;
    }

    // #096–097 Drowzee line
    public static Pokemon newDrowzee(String n) {
        Pokemon p = base("Drowzee", n, 5, Type.PSYCHIC, Type.NONE, 21, 48, 45, 43, 42);
        p.attacks = moves(pound(), hypnosis());
        return p;
    }
    public static Pokemon newHypno(String n) {
        Pokemon p = base("Hypno", n, 5, Type.PSYCHIC, Type.NONE, 23, 73, 70, 73, 67);
        p.attacks = moves(pound(), hypnosis(), psybeam(), psychic());
        return p;
    }

    // #098–099 Krabby line
    public static Pokemon newKrabby(String n) {
        Pokemon p = base("Krabby", n, 5, Type.WATER, Type.NONE, 18, 105, 90, 25, 50);
        p.attacks = moves(waterGun(), leer());
        return p;
    }
    public static Pokemon newKingler(String n) {
        Pokemon p = base("Kingler", n, 5, Type.WATER, Type.NONE, 20, 130, 115, 50, 75);
        p.attacks = moves(waterGun(), leer(), crabhammer(), slash());
        return p;
    }

    // #100–101 Voltorb line
    public static Pokemon newVoltorb(String n) {
        Pokemon p = base("Voltorb", n, 5, Type.ELECTRIC, Type.NONE, 19, 30, 50, 55, 100);
        p.attacks = moves(thundershock(), screech());
        return p;
    }
    public static Pokemon newElectrode(String n) {
        Pokemon p = base("Electrode", n, 5, Type.ELECTRIC, Type.NONE, 21, 50, 70, 80, 140);
        p.attacks = moves(thundershock(), screech(), thunderbolt());
        return p;
    }

    // #102–103 Exeggcute line
    public static Pokemon newExeggcute(String n) {
        Pokemon p = base("Exeggcute", n, 5, Type.GRASS, Type.PSYCHIC, 21, 40, 80, 60, 40);
        p.attacks = moves(barrage(), hypnosis(), psybeam());
        return p;
    }
    public static Pokemon newExeggutor(String n) {
        Pokemon p = base("Exeggutor", n, 5, Type.GRASS, Type.PSYCHIC, 24, 95, 85, 125, 55);
        p.attacks = moves(barrage(), hypnosis(), psychic(), stomp());
        return p;
    }

    // #104–105 Cubone line
    public static Pokemon newCubone(String n) {
        Pokemon p = base("Cubone", n, 5, Type.GROUND, Type.NONE, 20, 50, 95, 40, 35);
        p.attacks = moves(boneClub(), growl());
        return p;
    }
    public static Pokemon newMarowak(String n) {
        Pokemon p = base("Marowak", n, 5, Type.GROUND, Type.NONE, 21, 80, 110, 50, 45);
        p.attacks = moves(boneClub(), bonemerang(), growl(), strength());
        return p;
    }

    // #106–107 Hitmon
    public static Pokemon newHitmonlee(String n) {
        Pokemon p = base("Hitmonlee", n, 5, Type.FIGHTING, Type.NONE, 20, 120, 53, 35, 87);
        p.attacks = moves(lowKick(), meditate(), hiJumpKick());
        return p;
    }
    public static Pokemon newHitmonchan(String n) {
        Pokemon p = base("Hitmonchan", n, 5, Type.FIGHTING, Type.NONE, 20, 105, 79, 35, 76);
        p.attacks = moves(megaPunch(), thunderpunch(), firePunch(), icePunch());
        return p;
    }

    // #108 Lickitung
    public static Pokemon newLickitung(String n) {
        Pokemon p = base("Lickitung", n, 5, Type.NORMAL, Type.NONE, 24, 55, 75, 60, 30);
        p.attacks = moves(lick(), screech(), wrap());
        return p;
    }

    // #109–110 Koffing line
    public static Pokemon newKoffing(String n) {
        Pokemon p = base("Koffing", n, 5, Type.POISON, Type.NONE, 19, 65, 95, 60, 35);
        p.attacks = moves(tackle(), smog(), sludge());
        return p;
    }
    public static Pokemon newWeezing(String n) {
        Pokemon p = base("Weezing", n, 5, Type.POISON, Type.NONE, 21, 90, 120, 85, 60);
        p.attacks = moves(smog(), sludge(), bodySlam());
        return p;
    }

    // #111–112 Rhyhorn line
    public static Pokemon newRhyhorn(String n) {
        Pokemon p = base("Rhyhorn", n, 5, Type.GROUND, Type.ROCK, 23, 85, 95, 30, 25);
        p.attacks = moves(stomp(), tackle(), rockThrow());
        return p;
    }
    public static Pokemon newRhydon(String n) {
        Pokemon p = base("Rhydon", n, 5, Type.GROUND, Type.ROCK, 25, 130, 120, 45, 40);
        p.attacks = moves(stomp(), rockThrow(), earthquake(), megaKick());
        return p;
    }

    // #113 Chansey
    public static Pokemon newChansey(String n) {
        Pokemon p = base("Chansey", n, 5, Type.NORMAL, Type.NONE, 40, 5, 5, 105, 50);
        p.attacks = moves(pound(), growl(), softBoiled(), sing());
        return p;
    }

    // #114 Tangela
    public static Pokemon newTangela(String n) {
        Pokemon p = base("Tangela", n, 5, Type.GRASS, Type.NONE, 21, 55, 115, 100, 60);
        p.attacks = moves(vineWhip(), wrap(), growth(), slam());
        return p;
    }

    // #115 Kangaskhan
    public static Pokemon newKangaskhan(String n) {
        Pokemon p = base("Kangaskhan", n, 5, Type.NORMAL, Type.NONE, 25, 95, 80, 40, 90);
        p.attacks = moves(pound(), growl(), bite(), megaPunch());
        return p;
    }

    // #116–117 Horsea line
    public static Pokemon newHorsea(String n) {
        Pokemon p = base("Horsea", n, 5, Type.WATER, Type.NONE, 18, 40, 70, 70, 60);
        p.attacks = moves(waterGun(), leer());
        return p;
    }
    public static Pokemon newSeadra(String n) {
        Pokemon p = base("Seadra", n, 5, Type.WATER, Type.NONE, 20, 65, 95, 95, 85);
        p.attacks = moves(waterGun(), leer(), hydroPump());
        return p;
    }

    // #118–119 Goldeen line
    public static Pokemon newGoldeen(String n) {
        Pokemon p = base("Goldeen", n, 5, Type.WATER, Type.NONE, 19, 67, 60, 50, 63);
        p.attacks = moves(peck(), tailWhip());
        return p;
    }
    public static Pokemon newSeaking(String n) {
        Pokemon p = base("Seaking", n, 5, Type.WATER, Type.NONE, 23, 92, 65, 65, 68);
        p.attacks = moves(peck(), tailWhip(), waterGun(), surf());
        return p;
    }

    // #120–121 Staryu line
    public static Pokemon newStaryu(String n) {
        Pokemon p = base("Staryu", n, 5, Type.WATER, Type.NONE, 18, 45, 55, 70, 85);
        p.attacks = moves(tackle(), waterGun(), harden(), recover());
        return p;
    }
    public static Pokemon newStarmie(String n) {
        Pokemon p = base("Starmie", n, 5, Type.WATER, Type.PSYCHIC, 21, 75, 85, 100, 115);
        p.attacks = moves(waterGun(), psychic(), iceBeam(), thunderbolt(), recover());
        return p;
    }

    // #122 Mr. Mime
    public static Pokemon newMrMime(String n) {
        Pokemon p = base("Mr. Mime", n, 5, Type.PSYCHIC, Type.NONE, 19, 45, 65, 100, 90);
        p.attacks = moves(psybeam(), barrier(), psychic());
        return p;
    }

    // #123 Scyther
    public static Pokemon newScyther(String n) {
        Pokemon p = base("Scyther", n, 5, Type.BUG, Type.FLYING, 22, 110, 80, 55, 105);
        p.attacks = moves(scratch(), leer(), cut(), slash());
        return p;
    }

    // #124 Jynx
    public static Pokemon newJynx(String n) {
        Pokemon p = base("Jynx", n, 5, Type.ICE, Type.PSYCHIC, 21, 50, 35, 95, 95);
        p.attacks = moves(pound(), hypnosis(), icePunch(), psychic());
        return p;
    }

    // #125 Electabuzz
    public static Pokemon newElectabuzz(String n) {
        Pokemon p = base("Electabuzz", n, 5, Type.ELECTRIC, Type.NONE, 21, 83, 57, 85, 105);
        p.attacks = moves(thundershock(), leer(), thunderpunch(), thunderbolt());
        return p;
    }

    // #126 Magmar
    public static Pokemon newMagmar(String n) {
        Pokemon p = base("Magmar", n, 5, Type.FIRE, Type.NONE, 21, 95, 57, 85, 93);
        p.attacks = moves(ember(), leer(), firePunch(), flamethrower());
        return p;
    }

    // #127 Pinsir
    public static Pokemon newPinsir(String n) {
        Pokemon p = base("Pinsir", n, 5, Type.BUG, Type.NONE, 21, 125, 100, 55, 85);
        p.attacks = moves(bite(), leer(), slash(), strength());
        return p;
    }

    // #128 Tauros
    public static Pokemon newTauros(String n) {
        Pokemon p = base("Tauros", n, 5, Type.NORMAL, Type.NONE, 22, 100, 95, 70, 110);
        p.attacks = moves(tackle(), tailWhip(), stomp(), headbutt());
        return p;
    }

    // #129–130 Magikarp line
    public static Pokemon newMagikarp(String n) {
        Pokemon p = base("Magikarp", n, 5, Type.WATER, Type.NONE, 17, 10, 55, 15, 80);
        p.attacks = moves(splash());
        return p;
    }
    public static Pokemon newGyarados(String n) {
        Pokemon p = base("Gyarados", n, 5, Type.WATER, Type.FLYING, 24, 125, 79, 100, 81);
        p.attacks = moves(bite(), leer(), headbutt(), hydroPump());
        return p;
    }

    // #131 Lapras
    public static Pokemon newLapras(String n) {
        Pokemon p = base("Lapras", n, 5, Type.WATER, Type.ICE, 28, 85, 80, 95, 60);
        p.attacks = moves(waterGun(), growl(), iceBeam(), bodySlam(), confuseRay());
        return p;
    }

    // #132 Ditto
    public static Pokemon newDitto(String n) {
        Pokemon p = base("Ditto", n, 5, Type.NORMAL, Type.NONE, 19, 48, 48, 48, 48);
        p.attacks = moves(pound()); // Transform not implemented
        return p;
    }

    // #133–136 Eevee line
    public static Pokemon newEevee(String n) {
        Pokemon p = base("Eevee", n, 5, Type.NORMAL, Type.NONE, 20, 55, 50, 45, 55);
        p.attacks = moves(tackle(), growl());
        return p;
    }
    public static Pokemon newVaporeon(String n) {
        Pokemon p = base("Vaporeon", n, 5, Type.WATER, Type.NONE, 28, 65, 60, 110, 65);
        p.attacks = moves(waterGun(), growl(), acidArmor(), surf());
        return p;
    }
    public static Pokemon newJolteon(String n) {
        Pokemon p = base("Jolteon", n, 5, Type.ELECTRIC, Type.NONE, 21, 65, 60, 110, 130);
        p.attacks = moves(thundershock(), growl(), thunderWave(), thunderbolt(), pinMissile());
        return p;
    }
    public static Pokemon newFlareon(String n) {
        Pokemon p = base("Flareon", n, 5, Type.FIRE, Type.NONE, 21, 130, 60, 95, 65);
        p.attacks = moves(ember(), growl(), bodySlam(), flamethrower());
        return p;
    }

    // #137 Porygon
    public static Pokemon newPorygon(String n) {
        Pokemon p = base("Porygon", n, 5, Type.NORMAL, Type.NONE, 21, 60, 70, 75, 40);
        p.attacks = moves(tackle(), sharpen(), psybeam());
        return p;
    }

    // #138–139 Omanyte line
    public static Pokemon newOmanyte(String n) {
        Pokemon p = base("Omanyte", n, 5, Type.ROCK, Type.WATER, 18, 40, 100, 90, 35);
        p.attacks = moves(waterGun(), withdraw(), rockThrow());
        return p;
    }
    public static Pokemon newOmastar(String n) {
        Pokemon p = base("Omastar", n, 5, Type.ROCK, Type.WATER, 22, 60, 125, 115, 55);
        p.attacks = moves(waterGun(), withdraw(), rockThrow(), hydroPump());
        return p;
    }

    // #140–141 Kabuto line
    public static Pokemon newKabuto(String n) {
        Pokemon p = base("Kabuto", n, 5, Type.ROCK, Type.WATER, 18, 80, 90, 55, 55);
        p.attacks = moves(scratch(), harden());
        return p;
    }
    public static Pokemon newKabutops(String n) {
        Pokemon p = base("Kabutops", n, 5, Type.ROCK, Type.WATER, 21, 115, 105, 70, 80);
        p.attacks = moves(scratch(), harden(), slash(), waterGun());
        return p;
    }

    // #142 Aerodactyl
    public static Pokemon newAerodactyl(String n) {
        Pokemon p = base("Aerodactyl", n, 5, Type.ROCK, Type.FLYING, 23, 105, 65, 60, 130);
        p.attacks = moves(peck(), bite(), wingAttack(), rockThrow());
        return p;
    }

    // #143 Snorlax
    public static Pokemon newSnorlax(String n) {
        Pokemon p = base("Snorlax", n, 5, Type.NORMAL, Type.NONE, 31, 110, 65, 65, 30);
        p.attacks = moves(headbutt(), amnesia(), bodySlam(), megaPunch());
        return p;
    }

    // #144–146 Legendary birds
    public static Pokemon newArticuno(String n) {
        Pokemon p = base("Articuno", n, 5, Type.ICE, Type.FLYING, 24, 85, 100, 125, 85);
        p.attacks = moves(peck(), iceBeam(), blizzard());
        return p;
    }
    public static Pokemon newZapdos(String n) {
        Pokemon p = base("Zapdos", n, 5, Type.ELECTRIC, Type.FLYING, 24, 90, 85, 125, 100);
        p.attacks = moves(thundershock(), thunderWave(), thunderbolt(), thunder());
        return p;
    }
    public static Pokemon newMoltres(String n) {
        Pokemon p = base("Moltres", n, 5, Type.FIRE, Type.FLYING, 24, 100, 90, 125, 90);
        p.attacks = moves(ember(), fireSpin(), flamethrower(), fireBlast());
        return p;
    }

    // #147–149 Dratini line
    public static Pokemon newDratini(String n) {
        Pokemon p = base("Dratini", n, 5, Type.DRAGON, Type.NONE, 19, 64, 45, 50, 50);
        p.attacks = moves(wrap(), leer());
        return p;
    }
    public static Pokemon newDragonair(String n) {
        Pokemon p = base("Dragonair", n, 5, Type.DRAGON, Type.NONE, 21, 84, 65, 70, 70);
        p.attacks = moves(wrap(), leer(), thunderWave(), slam());
        return p;
    }
    public static Pokemon newDragonite(String n) {
        Pokemon p = base("Dragonite", n, 5, Type.DRAGON, Type.FLYING, 24, 134, 95, 100, 80);
        p.attacks = moves(slam(), wrap(), thunderWave(), hyperBeam());
        return p;
    }

    // #150–151 Mewtwo & Mew
    public static Pokemon newMewtwo(String n) {
        Pokemon p = base("Mewtwo", n, 5, Type.PSYCHIC, Type.NONE, 25, 110, 90, 154, 130);
        p.attacks = moves(confusion(), barrier(), recover(), amnesia(), psychic(), megaPunch(), megaKick());
        return p;
    }
    public static Pokemon newMew(String n) {
        Pokemon p = base("Mew", n, 5, Type.PSYCHIC, Type.NONE, 25, 100, 100, 100, 100);
        p.attacks = moves(pound(), psychic(), recover());
        return p;
    }


    // Private helpers

    private static Pokemon base(String name, String nickname, int level,
                                Type primary, Type secondary,
                                int hp, int atk, int def, int spe, int vel) {
        Pokemon p = new Pokemon(name);
        p.setNickname(nickname);
        p.setLevel(level);
        p.setPrimaryType(primary);
        p.setSecondaryType(secondary);
        p.setMaxHP(hp);
        p.setHP(hp);
        p.setAttack(atk);
        p.setDefense(def);
        p.setSpecial(spe);
        p.setVelocity(vel);
        p.setPrecision(100);
        p.setEvasion(100);
        return p;
    }

    private static List<MoveInterface> moves(MoveInterface... moves) {
        return new ArrayList<>(List.of(moves));
    }

    // alias to avoid clash with MoveFactory.karateChop import
    private static com.pokemon.action.move.Move karaChop() {
        return com.pokemon.action.move.MoveFactory.karateChop();
    }
}