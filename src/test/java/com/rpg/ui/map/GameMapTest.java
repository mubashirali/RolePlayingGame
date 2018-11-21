package com.rpg.ui.map;

import com.rpg.game.Storyline;
import com.rpg.ui.map.impl.CounterStrikeMap;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Mubashir on 11/21/2018.
 */
public class GameMapTest {

    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void defaultMap() {
        GameMap map = new CounterStrikeMap();
        systemInMock.provideLines("test");
        String expected = "Your task is to reach towards South, East of the town (bottom right of the map)";
        map.defaultMap(Storyline.CS_STORY);

        Assert.assertTrue(systemOutMock.getLog().contains(expected));
    }

}