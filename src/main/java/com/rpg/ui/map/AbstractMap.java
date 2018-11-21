package com.rpg.ui.map;

import com.rpg.util.PropertyLoader;

import java.util.Arrays;

/**
 * Created by Mubashir on 11/18/2018.
 */
public abstract class AbstractMap implements GameMap {
    protected int CURRENT_CHAR_LOC_I = 0;
    protected int CURRENT_CHAR_LOC_J = 0;
    public String[][] MAP_ARRAY = new String[5][];

    public AbstractMap() {
        MAP_ARRAY[0] = new String[6];
        MAP_ARRAY[1] = new String[6];
        MAP_ARRAY[2] = new String[6];
        MAP_ARRAY[3] = new String[6];
        MAP_ARRAY[4] = new String[6];
        Arrays.stream(MAP_ARRAY).forEach(a -> Arrays.fill(a, "  "));
    }

    @Override
    public void printMap() {
        System.out.println(String.format(PropertyLoader.getPropertyLoader().getProperty(MAP),
                Arrays.stream(MAP_ARRAY).flatMap(Arrays::stream).toArray()));

    }

    public void updateMap(String move) {
        Arrays.stream(MAP_ARRAY).forEach(a -> Arrays.fill(a, "  "));
        switch (move.toLowerCase()) {
        case "i":
            moveUp();
            break;
        case "k":
            moveDown();
            break;
        case "j":
            moveLeft();
            break;
        case "l":
            moveRight();
            break;
        default:
            System.out.println("Type J to move left:\nType L to move Right:\nType I to move Up:\nType K to move Down:");
            System.out.println("Type Q to quit game:\nType S to save and exit game:");
            System.out.println("Invalid input!");
        }
    }

    @Override
    public void moveUp() {
        if (CURRENT_CHAR_LOC_I == 0 || CURRENT_CHAR_LOC_I == 2 && CURRENT_CHAR_LOC_J > 0 && CURRENT_CHAR_LOC_J < 5
                || CURRENT_CHAR_LOC_I == 4 && CURRENT_CHAR_LOC_J > 0) {
            System.out.println("There is a wall ahead, try again!!!");
        } else {
            CURRENT_CHAR_LOC_I--;
        }
    }

    @Override
    public void moveDown() {
        if (CURRENT_CHAR_LOC_I == 0 && CURRENT_CHAR_LOC_J > 0 && CURRENT_CHAR_LOC_J < 5
                || CURRENT_CHAR_LOC_I == 2 && CURRENT_CHAR_LOC_J > 0 && CURRENT_CHAR_LOC_J < 5
                || CURRENT_CHAR_LOC_I == 4) {
            System.out.println("There is a wall ahead, try again!!!");
        } else {
            CURRENT_CHAR_LOC_I++;
        }
    }

    @Override
    public void moveLeft() {
        if (CURRENT_CHAR_LOC_J == 0 || CURRENT_CHAR_LOC_I == 1 || CURRENT_CHAR_LOC_I == 3) {
            System.out.println("There is a wall ahead, try again!!!");
        } else {
            CURRENT_CHAR_LOC_J--;
        }
    }

    @Override
    public void moveRight() {
        if (CURRENT_CHAR_LOC_I == 1 || CURRENT_CHAR_LOC_I == 3 || CURRENT_CHAR_LOC_I == 0 && CURRENT_CHAR_LOC_J == 5
                || CURRENT_CHAR_LOC_I == 2 && CURRENT_CHAR_LOC_J == 5
                || CURRENT_CHAR_LOC_I == 4 && CURRENT_CHAR_LOC_J == 5) {
            System.out.println("There is a wall ahead, try again!!!");
        } else {
            CURRENT_CHAR_LOC_J++;
        }
    }
}
