package com.rpg.game.builder.impl;

import com.rpg.character.activity.AbstractMission;
import com.rpg.character.activity.impl.CounterStrikeMission;
import com.rpg.game.builder.AbstractGameBuilder;
import com.rpg.ui.map.GameMap;
import com.rpg.ui.map.impl.CounterStrikeMap;

import static com.rpg.game.Storyline.CS_STORY;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class CounterStrikeGameBuilder extends AbstractGameBuilder {

    @Override
    protected GameMap createMap() {
        return new CounterStrikeMap();
    }

    @Override
    protected AbstractMission createMission() {
        return new CounterStrikeMission(CS_STORY);
    }
}
