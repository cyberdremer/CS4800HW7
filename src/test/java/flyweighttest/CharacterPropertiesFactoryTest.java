package flyweighttest;

import org.example.flyweight.character.CharacterProperties;
import org.example.flyweight.character.CharacterPropertiesFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CharacterPropertiesFactoryTest {
    private CharacterPropertiesFactory characterPropertiesFactory = CharacterPropertiesFactory.getInstance();


    @Test
    public void testSameInstance(){
        CharacterPropertiesFactory instance1 = CharacterPropertiesFactory.getInstance();
        CharacterPropertiesFactory instance2 = CharacterPropertiesFactory.getInstance();
        assertSame(instance1, instance2);

    }


    @Test
    public void testSameCharacterPropertiesInstance(){
        CharacterProperties characterProperties1 = characterPropertiesFactory.retrieveCharacterProperties("ComicSans",
                "Black", 12);
        CharacterProperties characterProperties2 = characterPropertiesFactory.retrieveCharacterProperties("ComicSans",
                "Black", 12);
        assertSame(characterProperties1,characterProperties2);


    }
}
