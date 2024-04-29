package org.example.flyweight;

import org.example.flyweight.character.Character;
import org.example.flyweight.character.CharacterProperties;
import org.example.flyweight.character.CharacterPropertiesFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Document {
    private List<Character> characterList;
    private static CharacterPropertiesFactory characterPropertiesFactory;

    public Document(){
        characterList = new ArrayList<>();
        characterPropertiesFactory = CharacterPropertiesFactory.getInstance();
    }


    public void addCharacter(Character character){
        characterList.add(character);
    }

    public List<Character> getCharacterList(){
        return characterList;
    }

    public void saveToFile(String path) throws IOException {
        try(Writer writer = new FileWriter(path)){
            for (Character character : characterList){
                writer.write(character.getCh() + "," +
                        character.getCharacterProperties().getFont() + "," +
                        character.getCharacterProperties().getColor() + ","+
                        character.getCharacterProperties().getSize() + "\n");
            }

        }


    }


    public static Document loadFromFile(String path) throws FileNotFoundException {
        Document document = new Document();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] characterData = line.split(",");
                char ch = characterData[0].charAt(0);
                String fontName = characterData[1];
                String fontColor = characterData[2];
                int fontSize = Integer.parseInt(characterData[3]);

                CharacterProperties characterProperties = characterPropertiesFactory.retrieveCharacterProperties(
                        fontName, fontColor, fontSize
                );

                document.addCharacter(new Character(ch, characterProperties));

            }
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
