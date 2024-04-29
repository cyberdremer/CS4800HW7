package org.example.flyweight;

import org.example.flyweight.character.Character;
import org.example.flyweight.character.CharacterProperties;
import org.example.flyweight.character.CharacterPropertiesFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Document document = new Document();
        CharacterPropertiesFactory metaDataFactory = CharacterPropertiesFactory.getInstance();
        CharacterProperties arialBlack12 = metaDataFactory.retrieveCharacterProperties("arial", "black" , 12);
        CharacterProperties calibriBlue14 = metaDataFactory.retrieveCharacterProperties("calibri", "blue", 14);
        CharacterProperties verdanaRed16 = metaDataFactory.retrieveCharacterProperties("verdana", "red", 16);
        CharacterProperties verdanaBlack14 = metaDataFactory.retrieveCharacterProperties("verdana", "black", 14);


        document.addCharacter(new Character('h', arialBlack12));
        document.addCharacter(new Character('e', calibriBlue14));
        document.addCharacter(new Character('l', verdanaBlack14));
        document.addCharacter(new Character('l', verdanaRed16));
        document.addCharacter(new Character('o', verdanaBlack14));

        document.addCharacter(new Character('w', arialBlack12));
        document.addCharacter(new Character('o', verdanaBlack14));
        document.addCharacter(new Character('r', arialBlack12));
        document.addCharacter(new Character('l', calibriBlue14));
        document.addCharacter(new Character('d', verdanaBlack14));

        document.addCharacter(new Character('C', arialBlack12));
        document.addCharacter(new Character('S', verdanaBlack14));
        document.addCharacter(new Character('4', verdanaRed16));
        document.addCharacter(new Character('8', calibriBlue14));
        document.addCharacter(new Character('0', verdanaBlack14));
        document.addCharacter(new Character('0', arialBlack12));

        document.saveToFile("newdoc.txt");

        Document loadedIn = Document.loadFromFile("newdoc.txt");
        List<Character> readInChar = loadedIn.getCharacterList();

        System.out.println(readInChar.toString());



    }
}
