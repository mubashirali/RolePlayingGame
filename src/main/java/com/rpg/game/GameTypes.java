package com.rpg.game;

/**
 * Created by Mubashir on 11/18/2018.
 */
public enum GameTypes {
    COUNTER_STRIKE("counterStrike"), TOMB_RAIDER("tombRaider");

    private final String type;

    GameTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
