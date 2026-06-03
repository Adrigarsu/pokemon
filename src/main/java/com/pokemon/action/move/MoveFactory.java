package com.pokemon.action.move;

import com.pokemon.action.condition.battleCond.HitsTarget;
import com.pokemon.action.effect.*;
import com.pokemon.action.move.attempt.Attempt;
import com.pokemon.action.move.attempt.AttemptInterface;
import com.pokemon.action.move.attempt.Combo;
import com.pokemon.action.number.Between;
import com.pokemon.action.number.DamageFormula;
import com.pokemon.action.target.Attacker;
import com.pokemon.action.target.Defender;
import com.pokemon.action.target.TargetInterface;
import com.pokemon.pokemon.type.MoveCategory;
import com.pokemon.pokemon.type.Type;
import com.pokemon.pokemon.type.TypeChart;

import java.util.List;

public class MoveFactory {

    private static final TargetInterface ATTACKER = new Attacker();
    private static final TargetInterface DEFENDER = new Defender();
    private static final MoveEffectInterface NO_EFFECT = new NoEffect();


    // Normal

    public static Move tackle()       { return damaging("Tackle",       Type.NORMAL,  35, 35,  95); }
    public static Move scratch()      { return damaging("Scratch",      Type.NORMAL,  40, 35, 100); }
    public static Move pound()        { return damaging("Pound",        Type.NORMAL,  40, 35, 100); }
    public static Move cut()          { return damaging("Cut",          Type.NORMAL,  50, 30,  95); }
    public static Move strength()     { return damaging("Strength",     Type.NORMAL,  80, 15, 100); }
    public static Move slam()         { return damaging("Slam",         Type.NORMAL,  80, 20,  75); }
    public static Move headbutt()     { return damaging("Headbutt",     Type.NORMAL,  70, 15, 100); }
    public static Move stomp()        { return damaging("Stomp",        Type.NORMAL,  65, 20, 100); }
    public static Move megaPunch()    { return damaging("Mega Punch",   Type.NORMAL,  80, 20,  85); }
    public static Move megaKick()     { return damaging("Mega Kick",    Type.NORMAL, 120,  5,  75); }
    public static Move hyperBeam()    { return damaging("Hyper Beam",   Type.NORMAL, 150,  5,  90); }
    public static Move slash()        { return damaging("Slash",        Type.NORMAL,  70, 20, 100); }
    public static Move bite()         { return damaging("Bite",         Type.NORMAL,  60, 25, 100); }
    public static Move quickAttack()  { return damaging("Quick Attack", Type.NORMAL,  40, 30, 100); }
    public static Move hornAttack()   { return damaging("Horn Attack",  Type.NORMAL,  65, 35, 100); }
    public static Move eggBomb()      { return damaging("Egg Bomb",     Type.NORMAL, 100, 10,  75); }
    public static Move karateChop()   { return damaging("Karate Chop",  Type.NORMAL,  50, 25, 100); }

    // 30% paralysis
    public static Move bodySlam() {
        return withSecondaryEffect("Body Slam", Type.NORMAL, 85, 15, 100,
                30, new Paralysis(DEFENDER));
    }

    // multi-hit
    public static Move furyAttack() {
        return multiHit("Fury Attack", Type.NORMAL, 15, 20, 85);
    }
    public static Move furySwipes() {
        return multiHit("Fury Swipes", Type.NORMAL, 18, 15, 80);
    }
    public static Move cometPunch() {
        return multiHit("Comet Punch", Type.NORMAL, 18, 15, 85);
    }
    public static Move barrage() {
        return multiHit("Barrage", Type.NORMAL, 15, 20, 85);
    }
    public static Move wrap() {
        return multiHit("Wrap", Type.NORMAL, 15, 20, 85);
    }


    // Fire

    public static Move ember()        { return damaging("Ember",        Type.FIRE,  40, 25, 100); }
    public static Move flamethrower() { return damaging("Flamethrower", Type.FIRE,  95, 15, 100); }
    public static Move fireBlast()    { return damaging("Fire Blast",   Type.FIRE, 120,  5,  85); }
    public static Move firePunch()    { return damaging("Fire Punch",   Type.FIRE,  75, 15, 100); }
    public static Move fireSpin()     { return damaging("Fire Spin",    Type.FIRE,  15, 15,  70); }


    // Water

    public static Move waterGun()    { return damaging("Water Gun",   Type.WATER,  40, 25, 100); }
    public static Move bubble()      { return damaging("Bubble",      Type.WATER,  20, 30, 100); }
    public static Move bubbleBeam()  { return damaging("Bubble Beam", Type.WATER,  65, 20, 100); }
    public static Move surf()        { return damaging("Surf",        Type.WATER,  95, 15, 100); }
    public static Move hydroPump()   { return damaging("Hydro Pump",  Type.WATER, 120,  5,  80); }
    public static Move crabhammer()  { return damaging("Crabhammer",  Type.WATER, 100, 10,  85); }


    // Electric

    public static Move thundershock() {
        return withSecondaryEffect("Thundershock", Type.ELECTRIC, 40, 30, 100,
                10, new Paralysis(DEFENDER));
    }
    public static Move thunderbolt() {
        return withSecondaryEffect("Thunderbolt", Type.ELECTRIC, 95, 15, 100,
                10, new Paralysis(DEFENDER));
    }
    public static Move thunder() {
        return withSecondaryEffect("Thunder", Type.ELECTRIC, 120, 10, 70,
                10, new Paralysis(DEFENDER));
    }
    public static Move thunderpunch() {
        return withSecondaryEffect("Thunderpunch", Type.ELECTRIC, 75, 15, 100,
                10, new Paralysis(DEFENDER));
    }


    // Grass

    public static Move vineWhip()   { return damaging("Vine Whip",  Type.GRASS,  35, 25, 100); }
    public static Move razorLeaf()  { return damaging("Razor Leaf", Type.GRASS,  55, 25,  95); }
    public static Move solarBeam()  { return damaging("Solar Beam", Type.GRASS, 120, 10, 100); }
    public static Move absorb()     { return damaging("Absorb",     Type.GRASS,  20, 20, 100); }
    public static Move megaDrain()  { return damaging("Mega Drain", Type.GRASS,  40, 10, 100); }
    public static Move leechLife()  { return damaging("Leech Life", Type.BUG,    20, 15, 100); }


    // Ice

    public static Move iceBeam()  { return damaging("Ice Beam", Type.ICE,  95, 10, 100); }
    public static Move blizzard() { return damaging("Blizzard", Type.ICE, 120,  5,  90); }
    public static Move icePunch() { return damaging("Ice Punch", Type.ICE,  75, 15, 100); }


    // Psychic

    public static Move psybeam()   { return damaging("Psybeam",   Type.PSYCHIC,  65, 20, 100); }
    public static Move confusion() { return damaging("Confusion",  Type.PSYCHIC,  50, 25, 100); }

    // 30% chance to lower opponent's Special by 1
    public static Move psychic() {
        return withSecondaryEffect("Psychic", Type.PSYCHIC, 90, 10, 100,
                30, new StatChange(DEFENDER, StatChange.Stat.SPECIAL, -1));
    }


    // Fighting

    public static Move lowKick()     { return damaging("Low Kick",      Type.FIGHTING,  50, 20, 90); }
    public static Move submission()  { return damaging("Submission",     Type.FIGHTING,  80, 25, 80); }
    public static Move hiJumpKick()  { return damaging("Hi Jump Kick",   Type.FIGHTING,  85, 20, 90); }
    public static Move jumpKick()    { return damaging("Jump Kick",       Type.FIGHTING,  70, 25, 95); }


    // Poison

    public static Move poisonSting() { return damaging("Poison Sting", Type.POISON, 15, 35, 100); }
    public static Move smog()        { return damaging("Smog",          Type.POISON, 20, 20,  70); }
    public static Move sludge()      { return damaging("Sludge",        Type.POISON, 65, 20, 100); }

    // 30% chance to lower opponent's Special by 1
    public static Move acid() {
        return withSecondaryEffect("Acid", Type.POISON, 40, 30, 100,
                30, new StatChange(DEFENDER, StatChange.Stat.SPECIAL, -1));
    }


    // Ground

    public static Move earthquake() { return damaging("Earthquake",  Type.GROUND, 100, 10, 100); }
    public static Move boneClub()   { return damaging("Bone Club",   Type.GROUND,  65, 20,  85); }

    // hits exactly 2 times
    public static Move bonemerang() {
        DirectDamage dmg = directDamage(Type.GROUND, 50);
        Combo combo = new Combo(new HitsTarget(90), new Between(2, 3), dmg);
        return build("Bonemerang", Type.GROUND, 50, 10, 90, combo);
    }


    // Rock

    public static Move rockThrow() { return damaging("Rock Throw", Type.ROCK, 50, 15, 65); }
    public static Move rockSlide() { return damaging("Rock Slide", Type.ROCK, 75, 10, 90); }


    // Flying

    public static Move peck()      { return damaging("Peck",       Type.FLYING, 35, 35, 100); }
    public static Move wingAttack(){ return damaging("Wing Attack", Type.FLYING, 35, 35, 100); }
    public static Move drillPeck() { return damaging("Drill Peck", Type.FLYING, 80, 20, 100); }


    // Bug

    public static Move pinMissile() { return multiHit("Pin Missile", Type.BUG, 14, 20, 85); }
    public static Move spikeCannon(){ return multiHit("Spike Cannon", Type.NORMAL, 20, 15, 100); }

    // hits exactly 2 times
    public static Move twineedle() {
        DirectDamage dmg = directDamage(Type.BUG, 25);
        Combo combo = new Combo(new HitsTarget(100), new Between(2, 3), dmg);
        return build("Twineedle", Type.BUG, 25, 20, 100, combo);
    }


    // Ghost

    // 30% paralysis
    public static Move lick() {
        return withSecondaryEffect("Lick", Type.GHOST, 20, 30, 100,
                30, new Paralysis(DEFENDER));
    }


    // Stat-lowering (target: Defender)

    public static Move growl()    { return statChange("Growl",    Type.NORMAL,  40, 100, DEFENDER, StatChange.Stat.ATTACK,  -1); }
    public static Move tailWhip() { return statChange("Tail Whip", Type.NORMAL, 30, 100, DEFENDER, StatChange.Stat.DEFENSE, -1); }
    public static Move leer()     { return statChange("Leer",      Type.NORMAL,  30, 100, DEFENDER, StatChange.Stat.DEFENSE, -1); }
    public static Move screech()  { return statChange("Screech",   Type.NORMAL,  40,  85, DEFENDER, StatChange.Stat.DEFENSE, -2); }


    // Stat-raising (target: Attacker / self)

    public static Move meditate()   { return statChange("Meditate",    Type.NORMAL,   40, 100, ATTACKER, StatChange.Stat.ATTACK,  +1); }
    public static Move sharpen()    { return statChange("Sharpen",     Type.NORMAL,   30, 100, ATTACKER, StatChange.Stat.ATTACK,  +1); }
    public static Move swordsDance(){ return statChange("Swords Dance", Type.NORMAL,  30, 100, ATTACKER, StatChange.Stat.ATTACK,  +2); }
    public static Move defenseCurl(){ return statChange("Defense Curl", Type.NORMAL,  40, 100, ATTACKER, StatChange.Stat.DEFENSE, +1); }
    public static Move harden()     { return statChange("Harden",       Type.NORMAL,  30, 100, ATTACKER, StatChange.Stat.DEFENSE, +1); }
    public static Move withdraw()   { return statChange("Withdraw",     Type.WATER,   40, 100, ATTACKER, StatChange.Stat.DEFENSE, +1); }
    public static Move barrier()    { return statChange("Barrier",      Type.PSYCHIC, 30, 100, ATTACKER, StatChange.Stat.DEFENSE, +2); }
    public static Move acidArmor()  { return statChange("Acid Armor",   Type.POISON,  40, 100, ATTACKER, StatChange.Stat.DEFENSE, +2); }
    public static Move growth()     { return statChange("Growth",       Type.NORMAL,  40, 100, ATTACKER, StatChange.Stat.SPECIAL, +1); }
    public static Move amnesia()    { return statChange("Amnesia",      Type.PSYCHIC, 20, 100, ATTACKER, StatChange.Stat.SPECIAL, +2); }


    // Pure-paralysis status

    public static Move thunderWave() {
        Attempt a = new Attempt(new HitsTarget(100), new Paralysis(DEFENDER), NO_EFFECT, NO_EFFECT);
        return build("Thunder Wave", Type.ELECTRIC, 0, 20, 100, a);
    }
    public static Move stunSpore() {
        Attempt a = new Attempt(new HitsTarget(75), new Paralysis(DEFENDER), NO_EFFECT, NO_EFFECT);
        return build("Stun Spore", Type.GRASS, 0, 30, 75, a);
    }
    public static Move glare() {
        Attempt a = new Attempt(new HitsTarget(75), new Paralysis(DEFENDER), NO_EFFECT, NO_EFFECT);
        return build("Glare", Type.NORMAL, 0, 30, 75, a);
    }


    // Sleep / Confusion (status pending)

    public static Move hypnosis()   { return statusMove("Hypnosis",   Type.PSYCHIC, 20, 60); }
    public static Move sing()       { return statusMove("Sing",        Type.NORMAL,  15, 55); }
    public static Move confuseRay() { return statusMove("Confuse Ray", Type.GHOST,   10, 100); }


    // Healing

    public static Move recover() {
        Attempt a = new Attempt(new HitsTarget(100), new HealEffect(ATTACKER, 0.5), NO_EFFECT, NO_EFFECT);
        return build("Recover", Type.NORMAL, 0, 20, 100, a);
    }
    public static Move softBoiled() {
        Attempt a = new Attempt(new HitsTarget(100), new HealEffect(ATTACKER, 0.5), NO_EFFECT, NO_EFFECT);
        return build("Soft-Boiled", Type.NORMAL, 0, 10, 100, a);
    }


    // No-effect / misc

    public static Move splash()    { return statusMove("Splash",   Type.NORMAL,  40, 100); }
    public static Move teleport()  { return statusMove("Teleport", Type.PSYCHIC, 20, 100); }


    // Private helpers

    private static Move damaging(String name, Type type, int power, int pp, int accuracy) {
        Attempt attempt = new Attempt(new HitsTarget(accuracy), directDamage(type, power), NO_EFFECT, NO_EFFECT);
        return build(name, type, power, pp, accuracy, attempt);
    }

    private static Move withSecondaryEffect(String name, Type type, int power, int pp,
                                            int accuracy, int chancePercent,
                                            MoveEffectInterface secondary) {
        MoveEffectInterface onHit = new EffectInSequence(List.of(
                directDamage(type, power),
                new EffectWithCondition(new HitsTarget(chancePercent), NO_EFFECT, secondary)
        ));
        Attempt attempt = new Attempt(new HitsTarget(accuracy), onHit, NO_EFFECT, NO_EFFECT);
        return build(name, type, power, pp, accuracy, attempt);
    }

    private static Move multiHit(String name, Type type, int power, int pp, int accuracy) {
        DirectDamage dmg = directDamage(type, power);
        Combo combo = new Combo(new HitsTarget(accuracy), new Between(2, 6), dmg);
        return build(name, type, power, pp, accuracy, combo);
    }

    private static Move statChange(String name, Type type, int pp, int accuracy,
                                   TargetInterface target, StatChange.Stat stat, int stages) {
        Attempt attempt = new Attempt(new HitsTarget(accuracy),
                new StatChange(target, stat, stages), NO_EFFECT, NO_EFFECT);
        return build(name, type, 0, pp, accuracy, attempt);
    }

    private static Move statusMove(String name, Type type, int pp, int accuracy) {
        Attempt attempt = new Attempt(new HitsTarget(accuracy), NO_EFFECT, NO_EFFECT, NO_EFFECT);
        return build(name, type, 0, pp, accuracy, attempt);
    }

    private static DirectDamage directDamage(Type type, double power) {
        MoveCategory cat = TypeChart.getCategoryOf(type);
        return new DirectDamage(DEFENDER, new DamageFormula(ATTACKER, DEFENDER, power, type, cat));
    }

    private static Move build(String name, Type type, int power, int pp, int precision,
                               AttemptInterface attempt) {
        Move m = new Move();
        m.setName(name);
        m.setType(type);
        m.setPower(power);
        m.setPp(pp);
        m.setMaxPp(pp);
        m.setPrecision(precision);
        m.setAttempt(attempt);
        return m;
    }
}