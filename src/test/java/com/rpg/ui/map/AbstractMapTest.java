package com.rpg.ui.map;

import com.rpg.ui.map.impl.TombRaiderMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

/**
 * Created by Mubashir on 11/21/2018.
 */
public class AbstractMapTest {
    private AbstractMap map;

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
    public void moveUpTest() {
        String expected = "There is a wall ahead, try again!!!";
        map.moveUp();
        Assert.assertTrue(systemOutMock.getLog().contains(expected));
    }

    @Test
    public void moveDownTest() {
        map.moveDown();
        map.moveDown();
        map.moveDown();
        map.moveDown();
        Assert.assertTrue(systemOutMock.getLog().isEmpty());
    }

    @Test
    public void moveLeftTest() {
        map.moveRight();
        map.moveLeft();
        Assert.assertTrue(systemOutMock.getLog().isEmpty());
    }

    @Test
    public void moveRightTest() {
        map.moveRight();
        map.moveRight();
        map.moveRight();
        map.moveRight();
        map.moveRight();
        Assert.assertTrue(systemOutMock.getLog().isEmpty());
        map.moveRight();
        Assert.assertTrue(!systemOutMock.getLog().isEmpty());
    }

}