package com.rpg.ui.map.impl;

import com.rpg.game.GameStatus;
import com.rpg.ui.map.GameMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class TombRaiderMapTest {
    private GameMap map;

    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        map = new TombRaiderMap();
    }

    @Test
    public void updateMapTest() {
        String expected = "Invalid input!";
        map.updateMap("test");
        Assert.assertTrue(systemOutMock.getLog().contains(expected));
    }

    @Test
    public void isQuestCompletedTest() {
        map.updateMap("k");
        map.updateMap("k");
        Assert.assertEquals(GameStatus.IN_PROGRESS, map.isQuestCompleted());
    }

}