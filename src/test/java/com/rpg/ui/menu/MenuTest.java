package com.rpg.ui.menu;

import com.rpg.game.GameTypes;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class MenuTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void gameMainMenuTest() {
        int input = 1;
        systemInMock.provideLines(String.valueOf(input));
        assertEquals(input, Menu.gameMainMenu());

        input = 2;
        systemInMock.provideLines(String.valueOf(input));
        assertEquals(input, Menu.gameMainMenu());
    }

    @Test
    public void gameStartupMenuTest() {
        int input = 1;
        systemInMock.provideLines(String.valueOf(input));

        assertEquals(GameTypes.COUNTER_STRIKE, Menu.gameStartupMenu());

        input = 2;
        systemInMock.provideLines(String.valueOf(input));

        assertEquals(GameTypes.TOMB_RAIDER, Menu.gameStartupMenu());
    }

}
