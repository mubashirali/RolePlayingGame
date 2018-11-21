package com.rpg.character;

import com.rpg.character.impl.User;
import com.rpg.character.impl.Zombie;

/**
 * Created by Mubashir on 11/18/2018.
 */
public final class CharacterFactory {

    private CharacterFactory() {
    }

    public static Character buildCharacter(CharacterType type) {
        String name = "";
        if (type.equals(CharacterType.ZOMBIE)) {
            int rand = (int) (Math.random() * 3);
            name = ZombieName.values()[rand].getName();
        }
        return buildCharacter(name, type);
    }

    public static Character buildCharacter(String name, CharacterType type) {
        switch (type) {
        case USER:
            return new User(name, 100, 100, 0);
        case ZOMBIE:
            return new Zombie(name, 30, 15);
        default:
            return null;
        }
    }

    public enum CharacterType {
        USER("user"), ZOMBIE("zombie");

        private final String type;

        CharacterType(String type) {
            this.type = type;
        }
    }

    public enum ZombieName {
        BITER("Biter"), CREEPER("Creeper"), FLOATER("Floater");

        private final String name;

        ZombieName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
