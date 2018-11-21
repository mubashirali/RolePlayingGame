package com.rpg.ui;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

/**
 * Created by Mubashir on 11/21/2018.
 */
public class SplashScreenTest {
    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();

    @Test
    public void showMissionFailedScreenTest() {
        String expected = "GAME OVER - MISSION FAILED!!!";
        SplashScreen.showMissionFailedScreen();
        Assert.assertTrue(systemOutMock.getLog().contains(expected));
    }

    @Test
    public void showMissionCompletedScreenTest() {
        String expected = "MISSION ACCOMPLISHED!!!";
        SplashScreen.showMissionCompletedScreen();
        Assert.assertTrue(systemOutMock.getLog().contains(expected));
    }

}