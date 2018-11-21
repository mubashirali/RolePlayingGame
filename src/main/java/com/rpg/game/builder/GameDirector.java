package com.rpg.game.builder;

import com.rpg.game.AbstractGame;
import com.rpg.game.Game;

/**
 * Created by Mubashir on 11/19/2018.
 */
public class GameDirector {

    public AbstractGame createGameObject(AbstractGameBuilder builder) {

        return new Game(builder.createCharacter(), builder.createMap(), builder.createMission(),
                builder.createExploration());
    }

    public AbstractGame createGameObject() {
        AbstractGame gameObject;
        gameObject = AbstractGameBuilder.getSavedGameObject();
        return gameObject;
    }
}
