package com.example.mage_battle.inventory;

public class Spell {
    public String spellName[];
    public int damage, heal, barrier;

    public Spell(String[] name, int dmg, int healing, int barr){
        this.damage = dmg;
        this.heal = healing;
        this.barrier = barr;
        this.spellName = name;
    }
}
