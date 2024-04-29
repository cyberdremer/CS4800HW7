package org.example.flyweight.propertyfactories;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static final Map<String, String> fontMap = new HashMap<>();
    private static FontFactory fontFactory = null;

    private FontFactory(){

    }

    public static FontFactory getInstance(){
        if(fontFactory == null){
            fontFactory = new FontFactory();
        }
        return fontFactory;
    }

    public String getFont(String name){
        if (!fontMap.containsKey(name)){
            fontMap.put(name, name);

        }
        return fontMap.get(name);
    }
}
