package com.pokemon.pokemon;

import com.pokemon.action.effect.Paralysis;
import com.pokemon.action.move.MoveInterface;
import com.pokemon.pokemon.status.StatusInterface;
import com.pokemon.pokemon.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private String name;
    private String nickname;

    private Type primaryType;
    private Type secondaryType;

    List<MoveInterface> attacks;

    // Stats
    private int exp;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private int level;

    private int HP;
    private int maxHP;
    private int attack;
    private int defense;
    private int special;
    private int velocity;
    private int precision;
    private int evasion;

    // characteristic calculation values
    private int base;
    private int individualValues;
    private int effortValues;

    //Combat info
    private boolean death;
    private List<StatusInterface> statusList = new ArrayList<StatusInterface>();

    // for test while development
    public Pokemon (String name){
        this.name = name;
        this.HP = 5;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }
    //TODO constructor for pokemons , fabric pattern ?

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getEffortValues() {
        return effortValues;
    }

    public void setEffortValues(int effortValues) {
        this.effortValues = effortValues;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getIndividualValues() {
        return individualValues;
    }

    public void setIndividualValues(int individualValues) {
        this.individualValues = individualValues;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(Type secondaryType) {
        this.secondaryType = secondaryType;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (HP > this.getMaxHP()) {
            this.HP = this.getMaxHP();
        }
        else {
            this.HP = HP;
        }

    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public Type getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(Type primaryType) {
        this.primaryType = primaryType;
    }

    public int getBaseAttack() {
        return attack;
    }

    public int getBaseDefense() {
        return defense;
    }

    public int getBaseSpecial() {
        return special; // in Gen 1, special is a single stat
    }

    public List<Type> getTypes() {
        if (hasSecondaryType()) {
            return List.of(primaryType, secondaryType);
        }
        return List.of(primaryType);
    }

    public boolean hasSecondaryType() {
        return secondaryType != null && secondaryType != Type.NONE;
    }

    public void addStatus(StatusInterface status) {
        statusList.add(status);
    }

    public List<MoveInterface> getAttacks() {
        return attacks;

    }

    public String getMenuPrint() {
        return this.name + " " + getTypesPrint() + " " + getHPPrint()  ;
    }

    private String getTypesPrint() {
        if(hasSecondaryType()){
            return primaryType.toString() + "-" + secondaryType.toString();
        }
        else {
            return primaryType.toString();
        }
    }

    private String getHPPrint() {
        return "( "+ getHP() + "HP/"+ getMaxHP() +"HP )";
    }
}
