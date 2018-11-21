package com.rpg.character.impl;

import com.rpg.character.Character;
import com.rpg.character.activity.Explorer;
import com.rpg.character.activity.Fighter;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mubashir on 11/18/2018.
 */
public class User implements Character, Fighter, Explorer {
    private static final long serialVersionUID = 1913983136355317437L;

    private String name;
    private int health;
    private int attackingPower;
    private int experience;
    private Map<String, Integer> places;

    public User(String name, int health, int attackingPower, int experience) {
        this.name = name;
        this.health = health;
        this.attackingPower = attackingPower;
        this.experience = experience;
        places = new TreeMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttackPower() {
        return attackingPower;
    }

    @Override
    public String toString() {
        return "User{" + "Name='" + name + '\'' + ", Health=" + health + ", Attacking Power=" + attackingPower
                + ", Experience=" + experience + ", Places Visited=" + places + '}';
    }

    @Override
    public void fight(int enemyAttPower) {
        this.health = Math.max(health - enemyAttPower, 0);
        experience += 10;

        System.out.println(toString());
    }

    @Override
    public void explore(String place) {
        int count = 0;
        if (places.containsKey(place)) {
            count = places.get(place);
        }
        places.put(place, ++count);
    }
}
