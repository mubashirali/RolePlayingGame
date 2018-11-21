package com.rpg.game;

import com.rpg.character.Character;
import com.rpg.character.activity.AbstractExploration;
import com.rpg.character.activity.AbstractMission;
import com.rpg.game.state.manager.GameStateManager;
import com.rpg.ui.SplashScreen;
import com.rpg.ui.map.GameMap;

import java.io.Serializable;

import static com.rpg.game.Storyline.DEFAULT_STORY;
import static com.rpg.util.ReadUserInput.getIntInput;

/**
 * Created by Mubashir on 11/21/2018.
 */
public abstract class AbstractGame implements Serializable {

    protected Character character;
    protected GameMap map;
    protected AbstractMission mission;
    protected AbstractExploration explorer;

    public abstract String getGameName();

    public void executeGame() {
        System.out.println("Press 1 to start the mission: ");
        System.out.println("Press 2 to explore town: ");
        System.out.println("Press 3 quit game: ");

        switch (getIntInput(3)) {
        case 1:
            map.defaultMap(DEFAULT_STORY);
            readGameResponse(mission.startMission(map, character));
            break;
        case 2:
            readGameResponse(explorer.startExploring(character));
        case 3:
            break;
        }
    }

    protected void readGameResponse(GameStatus status) {
        switch (status) {
        case COMPLETED:
            SplashScreen.showMissionCompletedScreen();
            break;
        case FAILED:
            SplashScreen.showMissionFailedScreen();
            break;
        case SAVE:
            GameStateManager.getGameStateManager().saveGame(this);
        default:
            System.out.println("Good Bye!!!");
        }

    }
}
