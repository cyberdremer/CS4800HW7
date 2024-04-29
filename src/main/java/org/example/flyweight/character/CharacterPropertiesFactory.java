package org.example.flyweight.character;

import org.example.flyweight.propertyfactories.ColorFactory;
import org.example.flyweight.propertyfactories.FontFactory;
import org.example.flyweight.propertyfactories.FontSizeFactory;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private static ColorFactory colorFactory;
    private static FontFactory fontFactory;

    private static FontSizeFactory fontSizeFactory;

    private static CharacterPropertiesFactory characterPropertiesFactory = null;

    private static Map<String, CharacterProperties> characterPropertiesHashMap;

    private CharacterPropertiesFactory(){
        colorFactory = ColorFactory.getInstance();
        fontFactory = FontFactory.getInstance();
        fontSizeFactory = FontSizeFactory.getInstance();
        characterPropertiesHashMap = new HashMap<>();
    }

    public static CharacterPropertiesFactory getInstance(){
        if (characterPropertiesFactory == null){
            characterPropertiesFactory = new CharacterPropertiesFactory();
        }
        return characterPropertiesFactory;

    }


    public CharacterProperties retrieveCharacterProperties(String font, String color, int size){
        String foundFont = fontFactory.getFont(font);
        String foundColor = colorFactory.getColor(color);
        int foundSize = fontSizeFactory.getSize(size);

        String propertyKey = createPropertyKey(font, color, size);
        if(!characterPropertiesHashMap.containsKey(propertyKey)){
            characterPropertiesHashMap.put(propertyKey, new CharacterProperties(foundColor, foundFont, foundSize));

        }
        return characterPropertiesHashMap.get(propertyKey);

    }


    private String createPropertyKey(String font, String color, int size){
        String propertyKey = font + color + size;
        propertyKey.strip().replace(" ", "").toLowerCase();
        return propertyKey;
    }



}
