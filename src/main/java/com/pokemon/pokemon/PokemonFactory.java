package com.pokemon.pokemon;

import com.pokemon.action.move.Move;
import com.pokemon.action.move.MoveInterface;
import com.pokemon.pokemon.type.Type;

import java.util.ArrayList;
import java.util.List;

public class PokemonFactory {

    public static Pokemon newPikachu(String nickname) {
        Pokemon p = base("Pikachu", nickname, 5, Type.ELECTRIC, Type.NONE, 20, 55, 30, 50, 90);
        p.attacks = moves(
            move("Thundershock", Type.ELECTRIC, 40, 30),
            move("Growl",        Type.NORMAL,    0, 40)
        );
        return p;
    }

    public static Pokemon newCharmander(String nickname) {
        Pokemon p = base("Charmander", nickname, 5, Type.FIRE, Type.NONE, 22, 52, 43, 50, 65);
        p.attacks = moves(
            move("Scratch", Type.NORMAL, 40, 35),
            move("Growl",   Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newBulbasaur(String nickname) {
        Pokemon p = base("Bulbasaur", nickname, 5, Type.GRASS, Type.POISON, 25, 49, 49, 65, 45);
        p.attacks = moves(
            move("Tackle", Type.NORMAL, 40, 35),
            move("Growl",  Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newSquirtle(String nickname) {
        Pokemon p = base("Squirtle", nickname, 5, Type.WATER, Type.NONE, 20, 48, 65, 50, 43);
        p.attacks = moves(
            move("Tackle",    Type.NORMAL, 40, 35),
            move("Tail Whip", Type.NORMAL,  0, 30)
        );
        return p;
    }

    public static Pokemon newVulpix(String nickname) {
        Pokemon p = base("Vulpix", nickname, 5, Type.FIRE, Type.NONE, 18, 41, 40, 65, 65);
        p.attacks = moves(
            move("Ember",     Type.FIRE,   40, 25),
            move("Tail Whip", Type.NORMAL,  0, 30)
        );
        return p;
    }

    public static Pokemon newAbra(String nickname) {
        Pokemon p = base("Abra", nickname, 5, Type.PSYCHIC, Type.NONE, 17, 20, 15, 105, 90);
        p.attacks = moves(
            move("Teleport", Type.PSYCHIC, 0, 20)
        );
        return p;
    }

    public static Pokemon newMachop(String nickname) {
        Pokemon p = base("Machop", nickname, 5, Type.FIGHTING, Type.NONE, 22, 80, 50, 35, 35);
        p.attacks = moves(
            move("Karate Chop", Type.NORMAL, 50, 25),
            move("Leer",        Type.NORMAL,  0, 30)
        );
        return p;
    }

    public static Pokemon newGeodude(String nickname) {
        Pokemon p = base("Geodude", nickname, 5, Type.ROCK, Type.GROUND, 19, 80, 100, 30, 20);
        p.attacks = moves(
            move("Tackle",       Type.NORMAL, 40, 35),
            move("Defense Curl", Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newGastly(String nickname) {
        Pokemon p = base("Gastly", nickname, 5, Type.GHOST, Type.POISON, 18, 35, 30, 100, 80);
        p.attacks = moves(
            move("Lick",       Type.GHOST, 20, 30),
            move("Confuse Ray", Type.GHOST,  0, 10)
        );
        return p;
    }

    public static Pokemon newDrowzee(String nickname) {
        Pokemon p = base("Drowzee", nickname, 5, Type.PSYCHIC, Type.NONE, 21, 48, 45, 43, 42);
        p.attacks = moves(
            move("Pound",    Type.NORMAL,  40, 35),
            move("Hypnosis", Type.PSYCHIC,  0, 20)
        );
        return p;
    }

    public static Pokemon newOnix(String nickname) {
        Pokemon p = base("Onix", nickname, 5, Type.ROCK, Type.GROUND, 18, 45, 160, 30, 70);
        p.attacks = moves(
            move("Tackle",  Type.NORMAL, 40, 35),
            move("Screech", Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newEevee(String nickname) {
        Pokemon p = base("Eevee", nickname, 5, Type.NORMAL, Type.NONE, 20, 55, 50, 45, 55);
        p.attacks = moves(
            move("Tackle", Type.NORMAL, 40, 35),
            move("Growl",  Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newJigglypuff(String nickname) {
        Pokemon p = base("Jigglypuff", nickname, 5, Type.NORMAL, Type.NONE, 26, 45, 20, 25, 20);
        p.attacks = moves(
            move("Sing",  Type.NORMAL, 0, 15),
            move("Pound", Type.NORMAL, 40, 35)
        );
        return p;
    }

    public static Pokemon newDratini(String nickname) {
        Pokemon p = base("Dratini", nickname, 5, Type.DRAGON, Type.NONE, 19, 64, 45, 50, 50);
        p.attacks = moves(
            move("Wrap", Type.NORMAL, 15, 20),
            move("Leer", Type.NORMAL,  0, 30)
        );
        return p;
    }

    public static Pokemon newMagikarp(String nickname) {
        Pokemon p = base("Magikarp", nickname, 5, Type.WATER, Type.NONE, 17, 10, 55, 15, 80);
        p.attacks = moves(
            move("Splash", Type.NORMAL, 0, 40)
        );
        return p;
    }

    public static Pokemon newSnorlax(String nickname) {
        Pokemon p = base("Snorlax", nickname, 5, Type.NORMAL, Type.NONE, 31, 110, 65, 65, 30);
        p.attacks = moves(
            move("Headbutt", Type.NORMAL, 70, 15),
            move("Amnesia",  Type.PSYCHIC,  0, 20)
        );
        return p;
    }

    public static Pokemon newPsyduck(String nickname) {
        Pokemon p = base("Psyduck", nickname, 5, Type.WATER, Type.NONE, 20, 52, 48, 50, 55);
        p.attacks = moves(
            move("Scratch",   Type.NORMAL, 40, 35),
            move("Tail Whip", Type.NORMAL,  0, 30)
        );
        return p;
    }

    public static Pokemon newMeowth(String nickname) {
        Pokemon p = base("Meowth", nickname, 5, Type.NORMAL, Type.NONE, 19, 45, 35, 40, 90);
        p.attacks = moves(
            move("Scratch", Type.NORMAL, 40, 35),
            move("Growl",   Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newClefairy(String nickname) {
        Pokemon p = base("Clefairy", nickname, 5, Type.NORMAL, Type.NONE, 22, 45, 48, 35, 35);
        p.attacks = moves(
            move("Pound", Type.NORMAL, 40, 35),
            move("Growl", Type.NORMAL,  0, 40)
        );
        return p;
    }

    public static Pokemon newGengar(String nickname) {
        Pokemon p = base("Gengar", nickname, 5, Type.GHOST, Type.POISON, 21, 65, 60, 130, 110);
        p.attacks = moves(
            move("Lick",        Type.GHOST, 20, 30),
            move("Confuse Ray", Type.GHOST,  0, 10)
        );
        return p;
    }

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

    private static Move move(String name, Type type, int power, int pp) {
        Move m = new Move();
        m.setName(name);
        m.setType(type);
        m.setPower(power);
        m.setPp(pp);
        m.setMaxPp(pp);
        m.setPrecision(100);
        return m;
    }

    private static List<MoveInterface> moves(Move... moves) {
        return new ArrayList<>(List.of(moves));
    }
}