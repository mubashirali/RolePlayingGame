package com.rpg.ui.map.impl;

import com.rpg.game.GameStatus;
import com.rpg.ui.map.AbstractMap;
import com.rpg.ui.map.GameMap;
import com.rpg.util.PropertyLoader;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class CounterStrikeMap extends AbstractMap implements GameMap {
    public static final String RANGER = "ranger";
    public static final String BOMB = "bomb";

    public CounterStrikeMap() {
        MAP_ARRAY[CURRENT_CHAR_LOC_I][CURRENT_CHAR_LOC_J] = PropertyLoader.getPropertyLoader().getProperty(RANGER);
        MAP_ARRAY[4][5] = PropertyLoader.getPropertyLoader().getProperty(BOMB);
    }

    @Override
    public void updateMap(String move) {
        super.updateMap(move);
        MAP_ARRAY[CURRENT_CHAR_LOC_I][CURRENT_CHAR_LOC_J] = PropertyLoader.getPropertyLoader().getProperty(RANGER);
        MAP_ARRAY[4][5] = PropertyLoader.getPropertyLoader().getProperty(BOMB);

        printMap();
    }

    @Override
    public GameStatus isQuestCompleted() {
        if (CURRENT_CHAR_LOC_I == 4 && CURRENT_CHAR_LOC_J == 5) {
            return GameStatus.COMPLETED;
        }

        return GameStatus.IN_PROGRESS;
    }

}
