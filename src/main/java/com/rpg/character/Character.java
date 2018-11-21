package com.rpg.character;

import java.io.Serializable;

/**
 * Created by Mubashir on 11/18/2018.
 */
public interface Character extends Serializable {

    String getName();

    int getHealth();

    int getAttackPower();

}
