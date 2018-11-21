package com.rpg.game.builder;

import com.rpg.character.Character;
import com.rpg.character.CharacterFactory;
import com.rpg.character.activity.AbstractExploration;
import com.rpg.character.activity.AbstractMission;
import com.rpg.character.activity.impl.ExplorationImpl;
import com.rpg.game.AbstractGame;
import com.rpg.game.state.manager.GameStateManager;
import com.rpg.ui.map.GameMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.rpg.game.state.manager.GameStateManager.EXT;
import static com.rpg.util.ReadUserInput.getStringInput;

/**
 * Created by Mubashir on 11/19/2018.
 */
public abstract class AbstractGameBuilder {

    protected abstract GameMap createMap();

    protected abstract AbstractMission createMission();

    protected AbstractExploration createExploration() {
        return new ExplorationImpl();
    }

    public Character createCharacter() {
        System.out.println("Enter your first name:");
        String username = getStringInput();
        return CharacterFactory.buildCharacter(username, CharacterFactory.CharacterType.USER);
    }

    public static AbstractGame getSavedGameObject() {
        AbstractGame gameObj = null;
        try {
            List<Path> fileList = new ArrayList<>();
            Files.newDirectoryStream(Paths.get("."), entry -> entry.getFileName().toString().contains(EXT))
                    .forEach(fileList::add);

            if (fileList.size() > 0) {
                System.out.println("Select the Game to load (copy and past the path from the list): ");
                fileList.forEach(System.out::println);
                gameObj = GameStateManager.getGameStateManager().loadGame(getStringInput());
            } else {
                System.out.println("No saved game found!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gameObj;
    }
}
