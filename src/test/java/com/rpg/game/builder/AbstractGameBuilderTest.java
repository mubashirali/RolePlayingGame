package com.rpg.game.builder;

import com.rpg.game.builder.impl.CounterStrikeGameBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Mubashir on 11/19/2018.
 */
public class AbstractGameBuilderTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    private AbstractGameBuilder builder = new CounterStrikeGameBuilder();

    @Test
    public void createExplorationTest() {
        Assert.assertNotNull(builder.createExploration());
    }

    @Test
    public void createCharacterTest() {
        systemInMock.provideLines("Testing");
        Assert.assertNotNull(builder.createCharacter());
    }
}