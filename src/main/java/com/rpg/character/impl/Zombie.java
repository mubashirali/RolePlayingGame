package com.rpg.character.impl;

import com.rpg.character.Character;
import com.rpg.character.activity.Fighter;

/**
 * Created by Mubashir on 11/19/2018.
 */
public class Zombie implements Character, Fighter {
    private static final long serialVersionUID = 155023349006520697L;

    private String name;
    private int health;
    private int attackingPower;

    public Zombie(String name, int health, int attackingPower) {
        this.name = name;
        this.health = health;
        this.attackingPower = attackingPower;
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
        return "Zombie{" + "Name='" + name + '\'' + ", Health=" + health + ", AttackingPower=" + attackingPower + '}';
    }

    @Override
    public void fight(int enemyAttPower) {
        this.health = Math.max(health - enemyAttPower, 0);
        System.out.println(toString());
    }
}
