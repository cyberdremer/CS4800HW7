package flyweighttest;

import org.example.flyweight.Document;
import org.example.flyweight.character.Character;
import org.example.flyweight.character.CharacterProperties;
import org.example.flyweight.character.CharacterPropertiesFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DocumentTest {
    private Document document = new Document();
    private CharacterPropertiesFactory factory;
    @BeforeEach
    public void testSetup(){
        factory = CharacterPropertiesFactory.getInstance();
        CharacterProperties arialBlack12 = factory.retrieveCharacterProperties("arial", "black", 12);
        Character character = new Character('b', arialBlack12);
        document.addCharacter(character);
    }

    @Test
    public void testWriteToFile() throws IOException {
        document.saveToFile("doc.txt");
        File file = new File("doc.txt");
        assertNotNull(file);

    }


    @Test
    public void testLoadInFileExists() throws FileNotFoundException {
        Document loadedInDocument = Document.loadFromFile("doc.txt");
        assertNotNull(loadedInDocument);
    }


    @Test
    public void testLoadedInCharacter() throws FileNotFoundException {
        Document loadedInDocument = Document.loadFromFile("doc.txt");
        Character actualCharacterMetaData = loadedInDocument.getCharacterList().get(0);
        String actualCharacterMetaDataString = actualCharacterMetaData.getCh() +
                actualCharacterMetaData.getCharacterProperties().getFont() + actualCharacterMetaData.getCharacterProperties().getColor()
                + actualCharacterMetaData.getCharacterProperties().getSize();
        String expectedCharacterMetaData = "barialblack12";
        assertEquals(actualCharacterMetaDataString, expectedCharacterMetaData);


    }

}
