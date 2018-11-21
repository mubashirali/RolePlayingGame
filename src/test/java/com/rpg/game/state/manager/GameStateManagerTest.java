package com.rpg.game.state.manager;

import com.rpg.character.CharacterFactory;
import com.rpg.character.activity.impl.CounterStrikeMission;
import com.rpg.character.activity.impl.ExplorationImpl;
import com.rpg.character.impl.User;
import com.rpg.game.AbstractGame;
import com.rpg.game.Game;
import com.rpg.ui.map.GameMap;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.File;
import java.nio.file.Files;

import static java.time.LocalDate.now;
import static org.junit.Assert.*;

/**
 * Created by Mubashir on 11/21/2018.
 */
public class GameStateManagerTest {

    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();

    private Game gameObj;
    private String fileName = "TestGameStateManagerTest";

    @Before
    public void setUp() throws Exception {
        gameObj = new Game(CharacterFactory.buildCharacter(fileName, CharacterFactory.CharacterType.USER), null, null,
                null);
    }

    @Test
    public void getGameStateManagerTest() {
        Assert.assertNotNull(GameStateManager.getGameStateManager());
    }

    @Test
    public void saveGameTest() {
        GameStateManager.getGameStateManager().saveGame(gameObj);

        Assert.assertTrue(systemOutMock.getLog().contains("Game Saved!!!"));

    }

    @Test
    public void loadGameTest() {
        String filePath = "SavedGame_" + fileName + "_" + now() + GameStateManager.EXT;
        GameStateManager.getGameStateManager().saveGame(gameObj);
        systemOutMock.clearLog();
        GameStateManager.getGameStateManager().loadGame(filePath);
        Assert.assertTrue(systemOutMock.getLog().isEmpty());

    }

    @After
    public void tearDown() throws Exception {
        File file = new File("SavedGame_" + fileName + "_" + now() + GameStateManager.EXT);
        Files.deleteIfExists(file.toPath());
    }
}