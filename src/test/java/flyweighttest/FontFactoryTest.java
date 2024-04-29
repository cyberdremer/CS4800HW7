package flyweighttest;

import org.example.flyweight.propertyfactories.FontFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FontFactoryTest {
    private FontFactory fontFactory = FontFactory.getInstance();


    @Test
    public void testSameInstance(){
        FontFactory instance1 = FontFactory.getInstance();
        FontFactory instance2 = FontFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testSameFontInstance(){
        String font1 = fontFactory.getFont("Comic-Sans");
        String font2 = fontFactory.getFont("Comic-Sans");
        assertSame(font2,font1);

    }
}
