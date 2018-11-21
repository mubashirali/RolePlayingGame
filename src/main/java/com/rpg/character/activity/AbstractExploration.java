package com.rpg.character.activity;

import com.rpg.character.Character;
import com.rpg.game.GameStatus;
import com.rpg.util.PropertyLoader;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.rpg.util.ReadUserInput.getIntInput;
import static com.rpg.util.ReadUserInput.getStringInput;

/**
 * Created by Mubashir on 11/18/2018.
 */
public abstract class AbstractExploration implements Serializable {

    public List<String> placesList;

    public AbstractExploration(String places) {

        placesList = Arrays.asList(PropertyLoader.getPropertyLoader().getProperty(places).split("\n"));
    }

    public GameStatus startExploring(Character character) {
        // Game loop
        do {
            System.out.println("Type E to explore:\nType Q to quit game:\nType S to save and exit game:");
            String userInput = getStringInput("q", "s", "e").toLowerCase();
            switch (userInput) {
            case "q":
                return GameStatus.QUIT;
            case "s":
                return GameStatus.SAVE;
            case "e":
                exploreUserInput();
                break;
            default:
                System.out.println("Invalid input!!!");
            }

            ((Explorer) character).explore(placesList.get(getIntInput(placesList.size()) - 1));
            System.out.println(character.toString());
        } while (true);
    }

    protected void exploreUserInput() {
        AtomicInteger index = new AtomicInteger(0);
        placesList.forEach(place -> {
            index.set(index.intValue() + 1);
            System.out.println(String.format("Type %s to visit %s: ", index.toString(), place));
        });
    }

}
