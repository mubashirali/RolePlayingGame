package com.rpg.game.builder.impl;

import com.rpg.character.activity.AbstractMission;
import com.rpg.character.activity.impl.TombRaiderMission;
import com.rpg.game.builder.AbstractGameBuilder;
import com.rpg.ui.map.GameMap;
import com.rpg.ui.map.impl.TombRaiderMap;

import static com.rpg.game.Storyline.TR_STORY;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class TombRaiderGameBuilder extends AbstractGameBuilder {

    @Override
    protected GameMap createMap() {
        return new TombRaiderMap();
    }

    @Override
    protected AbstractMission createMission() {
        return new TombRaiderMission(TR_STORY);
    }

}
