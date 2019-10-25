package com.example.mage_battle.player;

import com.example.mage_battle.inventory.Rune;
import com.example.mage_battle.inventory.Spell;
import java.util.ArrayList;

public class Mage {
    public ArrayList<Rune> runeInventory;
    public ArrayList<Spell> spellInventory;
    public int runeMastery[];
    public int hp, barrier;

    public Mage(int health, int runeMageMastery[]){
        this.spellInventory = new ArrayList<>();
        this.runeInventory = new ArrayList<>();
        this.hp = health;
        this.barrier = 0;
        this.runeMastery = runeMageMastery;
    }

    public void UseSpell(Mage target, int spellIndex) {
        if (target.barrier == 1 && this.spellInventory.get(spellIndex).damage > 0) {
            target.barrier = 0;
        } else {
            target.hp -= this.spellInventory.get(spellIndex).damage;
        }
        target.hp += this.spellInventory.get(spellIndex).heal;
        if (this.spellInventory.get(spellIndex).barrier == 1) {
            target.barrier = 1;
        }
        this.spellInventory.remove(spellIndex); //delete spell
    }

    public void AddRune(Rune newRune){
        this.runeInventory.add(newRune);
    }

    public void CraftSpell(){

    }
}
