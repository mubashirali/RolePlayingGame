package com.rpg.character.activity;

import com.rpg.character.Character;
import com.rpg.character.CharacterFactory;
import com.rpg.game.GameStatus;
import com.rpg.ui.map.GameMap;
import com.rpg.util.PropertyLoader;

import java.io.Serializable;

import static com.rpg.character.CharacterFactory.CharacterType.ZOMBIE;
import static com.rpg.util.ReadUserInput.getStringInput;

/**
 * Created by Mubashir on 11/20/2018.
 */
public abstract class AbstractMission implements Serializable {
    protected String storyLine;

    public AbstractMission(String storyLine) {
        this.storyLine = storyLine;
    }

    public GameStatus startMission(GameMap map, Character character) {
        System.out.println(PropertyLoader.getPropertyLoader().getProperty(storyLine));

        System.out.println("Type J to move left:\nType L to move Right:\nType I to move Up:\nType K to move Down:");
        System.out.println("Type Q to quit game:\nType S to save and exit game:");

        return startGameLogic(map, character);

    }

    protected GameStatus startGameLogic(GameMap map, Character character) {
        // Game loop
        do {
            String userInput = getStringInput().toLowerCase();
            switch (userInput) {
            case "q":
                return GameStatus.QUIT;
            case "s":
                return GameStatus.SAVE;
            }

            map.updateMap(userInput);

            if (map.isQuestCompleted().equals(GameStatus.COMPLETED)) {
                System.out.println(character);
                return GameStatus.COMPLETED;
            }

            fight(character);

            if (character.getHealth() <= 0) {
                System.out.println("You are dead!!!");
                return GameStatus.FAILED;
            }

        } while (true);
    }

    public Character fight(Character user) {
        if ((int) (Math.random() * 3) > 0) {
            userFight(user, CharacterFactory.buildCharacter(ZOMBIE));
        }
        return user;
    }

    protected void userFight(Character user, Character enemy) {
        System.out.println(String.format("You are being attacked by %s !!!", enemy.getName()));
        ((Fighter) user).fight(enemy.getAttackPower());
        ((Fighter) enemy).fight(user.getAttackPower());
    }

}
