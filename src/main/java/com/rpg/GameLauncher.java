package com.rpg;

import com.rpg.game.AbstractGame;
import com.rpg.game.GameTypes;
import com.rpg.game.builder.AbstractGameBuilder;
import com.rpg.game.builder.GameDirector;
import com.rpg.game.builder.impl.CounterStrikeGameBuilder;
import com.rpg.game.builder.impl.TombRaiderGameBuilder;
import com.rpg.ui.SplashScreen;
import com.rpg.ui.menu.Menu;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class GameLauncher {

    private AbstractGame gameObject = null;

    public void startGame() {
        SplashScreen.showSplash();

        if (Menu.gameMainMenu() == 1) {
            gameObject = new GameDirector().createGameObject(buildGameScenario());
        } else {
            gameObject = new GameDirector().createGameObject();
            if (gameObject == null) {
                System.out.println("Try Starting a new game!!!");
                startGame();
            }
        }

        gameObject.executeGame();
    }

    private AbstractGameBuilder buildGameScenario() {
        GameTypes gameType = Menu.gameStartupMenu();

        switch (gameType) {
        case COUNTER_STRIKE:
            return new CounterStrikeGameBuilder();
        case TOMB_RAIDER:
            return new TombRaiderGameBuilder();
        default:
            System.out.println("Invalid Game Type!");
            return null;
        }
    }
}
