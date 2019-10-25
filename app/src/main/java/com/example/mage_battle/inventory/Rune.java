package com.example.mage_battle.inventory;

import android.media.Image;

public class Rune {
    public enum RuneType {
        Fire, Earth, Water, Air
    }
    public RuneType runeType;
    public Image runeImage;

    public Rune(RuneType type){
        this.runeType = type;
    }
}
