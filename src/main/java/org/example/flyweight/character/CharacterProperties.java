package org.example.flyweight.character;

public class CharacterProperties {
    private String color;
    private String font;
    private int size;

    CharacterProperties(String color, String font, int size){
        this.color = color;
        this.font = font;
        this.size = size;
    }


    public String getColor() {
        return color;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CharacterProperties{" +
                "color='" + color + '\'' +
                ", font='" + font + '\'' +
                ", size=" + size +
                '}';
    }
}
