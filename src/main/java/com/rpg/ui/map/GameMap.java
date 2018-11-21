package com.rpg.ui.map;

import com.rpg.game.GameStatus;
import com.rpg.util.PropertyLoader;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by Mubashir on 11/18/2018.
 */
public interface GameMap extends Serializable {
    String MAP = "map";
    String DEFAULT_MAP = "default.map";

    default void defaultMap(String storyLine) {
        System.out.println(PropertyLoader.getPropertyLoader().getProperty(DEFAULT_MAP));

        System.out.println(PropertyLoader.getPropertyLoader().getProperty(storyLine));
        System.out.println("\nRemember you must not to die!!!");
        System.out.println("\nTo Begin your journey - Hit any key and press [Enter]:");

        new Scanner(System.in).next();
    }

    void updateMap(String move);

    void printMap();

    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    GameStatus isQuestCompleted();
}
