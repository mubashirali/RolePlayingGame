package com.rpg.game;

import com.rpg.character.activity.impl.CounterStrikeMission;
import com.rpg.character.activity.impl.ExplorationImpl;
import com.rpg.character.impl.User;
import com.rpg.game.state.manager.GameStateManager;
import com.rpg.ui.map.GameMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.time.LocalDate.now;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Mubashir on 11/21/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractGameTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();

    @InjectMocks
    private Game game;
    @Mock
    private User character;
    @Mock
    private GameMap map;
    @Mock
    private CounterStrikeMission mission;
    @Mock
    private ExplorationImpl exploration;

    @Before
    public void setUp() {
        game = new Game(character, map, mission, exploration);
    }

    @Test
    public void executeGameTest() {
        String expected = "Press 1 to start the mission:";
        String expected02 = "MISSION ACCOMPLISHED!!!";

        systemInMock.provideLines("1");
        when(mission.startMission(any(), any())).thenReturn(GameStatus.COMPLETED);

        game.executeGame();

        Assert.assertTrue(systemOutMock.getLog().contains(expected));
        Assert.assertTrue(systemOutMock.getLog().contains(expected02));
    }

    @Test
    public void readGameResponseTest() throws IOException {
        game.readGameResponse(GameStatus.SAVE);

        Assert.assertTrue(systemOutMock.getLog().contains("Unable to save the game!"));

        File file = new File("SavedGame_null_" + now() + GameStateManager.EXT);
        Files.deleteIfExists(file.toPath());
    }

}