package com.rpg.util;

/**
 * Created by Mubashir on 11/18/2018.
 */
public enum PropertyFiles {

    MENU("menu.properties"), MAP("map.properties"), STORY("storyline.properties");

    private String propertyFile;

    PropertyFiles(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public String getPropertyFile() {
        return propertyFile;
    }

    public void setPropertyFile(String propertyFile) {
        this.propertyFile = propertyFile;
    }

}
