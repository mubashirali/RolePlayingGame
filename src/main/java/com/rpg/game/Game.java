package com.rpg.game;

import com.rpg.character.Character;
import com.rpg.character.activity.AbstractExploration;
import com.rpg.character.activity.AbstractMission;
import com.rpg.ui.map.GameMap;

import static java.time.LocalDate.now;

/**
 * Created by Mubashir on 11/20/2018.
 */
public class Game extends AbstractGame {
    private static final long serialVersionUID = 3872177745979005061L;

    public Game(Character character, GameMap map, AbstractMission mission, AbstractExploration explorer) {
        this.character = character;
        this.map = map; // TODO: Get the collection of maps i.e. a HashMap map<Level,GameMap>
        this.mission = mission; // TODO: Get the collection of missions i.e. a HashMap map<Level,Mission>`
        this.explorer = explorer;
    }

    public String getGameName() {
        return "SavedGame_" + character.getName() + "_" + now();
    }
}
