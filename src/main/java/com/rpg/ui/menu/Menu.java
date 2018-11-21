package com.rpg.ui.menu;

import com.rpg.game.GameTypes;
import com.rpg.util.PropertyLoader;

import static com.rpg.util.ReadUserInput.getIntInput;

/**
 * Created by Mubashir on 11/18/2018.
 */
// TODO: Menu can be made abstract
public final class Menu {
    public static final String START_MENU = "start.menu";
    public static final String GAME_LOAD_MENU = "game.load.menu";

    private Menu() {
    }

    public static int gameMainMenu() {
        System.out.println(PropertyLoader.getPropertyLoader().getProperty(GAME_LOAD_MENU));
        switch (getIntInput(2)) {
        case 1:
            return 1;
        case 2:
            return 2;
        default:
            System.out.println("Invalid input please try again!");
        }

        return 0;
    }

    public static GameTypes gameStartupMenu() {
        int input = 0;

        System.out.println("***** Select the game from main menu *****");
        System.out.println(PropertyLoader.getPropertyLoader().getProperty(START_MENU));

        input = getIntInput(GameTypes.values().length);

        return GameTypes.values()[input - 1];
    }

}
