package com.rpg.game.builder.impl;

import com.rpg.character.activity.impl.CounterStrikeMission;
import com.rpg.game.builder.AbstractGameBuilder;
import com.rpg.ui.map.GameMap;
import com.rpg.ui.map.impl.CounterStrikeMap;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class CounterStrikeGameBuilderTest {
    @Test
    public void createMapTest() {
        CounterStrikeGameBuilder builder = new CounterStrikeGameBuilder();

        Assert.assertNotNull(builder.createMap());
        Assert.assertTrue(builder.createMap() instanceof CounterStrikeMap);
    }

    @Test
    public void createMissionTest() {
        CounterStrikeGameBuilder builder = new CounterStrikeGameBuilder();

        Assert.assertNotNull(builder.createMission());
        Assert.assertTrue(builder.createMission() instanceof CounterStrikeMission);
    }

}