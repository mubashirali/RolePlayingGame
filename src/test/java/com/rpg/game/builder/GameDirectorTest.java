package com.rpg.game.builder;

import com.rpg.game.Game;
import com.rpg.game.builder.impl.CounterStrikeGameBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Mubashir on 11/19/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameDirectorTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void createGameObjectTest() {
        systemInMock.provideLines("Test");
        GameDirector director = new GameDirector();

        Assert.assertNotNull(director.createGameObject(new CounterStrikeGameBuilder()));

    }

    @Test
    public void createGameObjectWithNoArgumentsTest() {
        GameDirector director = mock(GameDirector.class);
        when(director.createGameObject()).thenReturn(new Game(null, null, null, null));

        Assert.assertNotNull(director.createGameObject());
    }

}