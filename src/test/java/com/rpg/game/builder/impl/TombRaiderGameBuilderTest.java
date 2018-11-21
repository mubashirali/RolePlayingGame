package com.rpg.game.builder.impl;

import com.rpg.character.activity.impl.TombRaiderMission;
import com.rpg.ui.map.impl.TombRaiderMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class TombRaiderGameBuilderTest {
    @Test
    public void createMapTest() {
        TombRaiderGameBuilder builder = new TombRaiderGameBuilder();

        Assert.assertNotNull(builder.createMap());
        Assert.assertTrue(builder.createMap() instanceof TombRaiderMap);
    }

    @Test
    public void createMissionTest() {
        TombRaiderGameBuilder builder = new TombRaiderGameBuilder();

        Assert.assertNotNull(builder.createMission());
        Assert.assertTrue(builder.createMission() instanceof TombRaiderMission);
    }

}