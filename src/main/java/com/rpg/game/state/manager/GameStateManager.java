package com.rpg.game.state.manager;

import com.rpg.game.AbstractGame;

import java.io.*;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class GameStateManager {

    public static String EXT = ".ser";
    private static GameStateManager gameStateManager;

    private GameStateManager() {
    }

    public static GameStateManager getGameStateManager() {
        if (gameStateManager == null) {
            gameStateManager = new GameStateManager();
        }
        return gameStateManager;
    }

    public void saveGame(AbstractGame gameObj) {
        try (FileOutputStream myFileOutputStream = new FileOutputStream(gameObj.getGameName() + EXT)) {
            ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myFileOutputStream);
            myObjectOutputStream.writeObject(gameObj);
            myObjectOutputStream.close();
            System.out.println("Game Saved!!!");
        } catch (IOException ex) {
            System.out.println("Unable to save the game!");
        }
    }

    public AbstractGame loadGame(String path) {
        AbstractGame gameObj = null;
        try (FileInputStream myFileInputStream = new FileInputStream(path.trim())) {
            ObjectInputStream myObjectInputStream = new ObjectInputStream(myFileInputStream);
            gameObj = (AbstractGame) myObjectInputStream.readObject();
            myObjectInputStream.close();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Unable to load the game!");
        }
        return gameObj;
    }
}
