package com.rpg.ui.map.impl;

import com.rpg.game.GameStatus;
import com.rpg.ui.map.GameMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class CounterStrikeMapTest {

    private GameMap map;

    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        map = new CounterStrikeMap();
    }

    @Test
    public void updateMapTest() {
        map.updateMap("i");
        Assert.assertTrue(systemOutMock.getLog().contains("There is a wall ahead, try again!!!"));

        systemOutMock.clearLog();
        map.updateMap("k");
        map.updateMap("k");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("k");
        map.updateMap("k");
        Assert.assertTrue(!systemOutMock.getLog().contains("There is a wall ahead, try again!!!"));
    }

    @Test
    public void isQuestCompletedTest() {
        map.updateMap("k");
        map.updateMap("k");
        map.updateMap("k");
        map.updateMap("k");
        map.updateMap("k");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("l");
        map.updateMap("l");

        Assert.assertEquals(GameStatus.COMPLETED, map.isQuestCompleted());
    }
}