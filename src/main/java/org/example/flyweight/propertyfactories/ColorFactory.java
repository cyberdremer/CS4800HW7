package org.example.flyweight.propertyfactories;

import java.util.HashMap;
import java.util.Map;

public class ColorFactory {
    private static final Map<String, String> fontMap = new HashMap<>();
    private static ColorFactory colorFactory = null;

    private ColorFactory(){

    }

    public static ColorFactory getInstance(){
        if(colorFactory == null){
            colorFactory = new ColorFactory();
        }
        return colorFactory;
    }

    public String getColor(String color){
        if (!fontMap.containsKey(color)){
            fontMap.put(color, color);

        }
        return fontMap.get(color);
    }
}

