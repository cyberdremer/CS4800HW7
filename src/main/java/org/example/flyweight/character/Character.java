package org.example.flyweight.character;

public class Character {
    private char ch;
    private CharacterProperties characterProperties;


    public Character(char ch, CharacterProperties characterProperties){
        this.ch = ch;
        this.characterProperties = characterProperties;

    }

    public char getCh() {
        return ch;
    }

    public CharacterProperties getCharacterProperties() {
        return characterProperties;
    }

    @Override
    public String toString() {
        return "Character{" +
                "ch=" + ch +
                ", characterProperties=" + characterProperties +
                "}\n";
    }
}
