package com.rpg.game;

/**
 * Created by Mubashir on 11/18/2018.
 */
public enum GameStatus {
    COMPLETED("completed"), IN_PROGRESS("inProgress"), QUIT("quit"), FAILED("failed"), SAVE("save");

    private final String status;

    GameStatus(String type) {
        this.status = type;
    }

    public String getStatus() {
        return status;
    }

}
