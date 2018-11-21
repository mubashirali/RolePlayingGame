package com.rpg.game;

import com.rpg.character.CharacterFactory;
import com.rpg.game.state.manager.GameStateManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

import static java.time.LocalDate.now;

/**
 * Created by Mubashir on 11/21/2018.
 */
public class GameTest {

    private String fileName = "GameTest";

    @Test
    public void getGameName() {
        String expected = "SavedGame_" + fileName + "_" + now();
        Game game = new Game(CharacterFactory.buildCharacter(fileName, CharacterFactory.CharacterType.USER), null, null,
                null);

        Assert.assertEquals(expected, game.getGameName());
    }

    @After
    public void tearDown() throws Exception {
        File file = new File("SavedGame_" + fileName + "_" + now() + GameStateManager.EXT);
        Files.deleteIfExists(file.toPath());
    }
}