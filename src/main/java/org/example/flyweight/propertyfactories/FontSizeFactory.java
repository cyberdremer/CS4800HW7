package org.example.flyweight.propertyfactories;

import java.util.HashMap;
import java.util.Map;

public class FontSizeFactory {
    private static final Map<Integer, Integer> fontMap = new HashMap<>();
    private static FontSizeFactory fontSizeFactory = null;

    private FontSizeFactory(){

    }

    public static FontSizeFactory getInstance(){
        if(fontSizeFactory == null){
            fontSizeFactory = new FontSizeFactory();
        }
        return fontSizeFactory;
    }

    public Integer getSize(Integer size){
        if (!fontMap.containsKey(size)){
            if (size < 1){
                fontMap.put(1,1);
                return fontMap.get(1);
            }
            fontMap.put(size, size);

        }
        return fontMap.get(size);
    }
}
