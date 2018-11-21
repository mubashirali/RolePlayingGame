package com.rpg.util;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class ReadUserInputTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test()
    public void getIntInputTest() {
        int input = 999;
        systemInMock.provideLines(String.valueOf(input));
        Assert.assertEquals(input, ReadUserInput.getIntInput());
    }

    @Test
    public void getIntInputWithMaxValueTest() {
        int input = 999;
        systemInMock.provideLines(String.valueOf(input));
        Assert.assertEquals(input, ReadUserInput.getIntInput(999));
    }

    @Test()
    public void getStringInputTest() {
        String input = "Test";
        systemInMock.provideLines(String.valueOf(input));
        Assert.assertEquals(input, ReadUserInput.getStringInput());
    }

    @Test()
    public void getStringInputWithVarArgTest() {
        String input = "Test";
        systemInMock.provideLines(String.valueOf(input));
        Assert.assertEquals(input, ReadUserInput.getStringInput(input.toUpperCase()));
    }

}