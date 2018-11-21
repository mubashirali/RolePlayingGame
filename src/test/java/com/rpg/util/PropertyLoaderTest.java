package com.rpg.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class PropertyLoaderTest {
    @Test
    public void getPropertyLoaderTest() {
        Assert.assertNotNull(PropertyLoader.getPropertyLoader());
    }

    @Test
    public void getPropertyTest() {
        String result = "Press 1 to start Counter Strike:\nPress 2 to start Tomb Raider:";

        Assert.assertEquals(result, PropertyLoader.getPropertyLoader().getProperty("start.menu"));
    }

}
