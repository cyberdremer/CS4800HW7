package flyweighttest;

import org.example.flyweight.propertyfactories.FontSizeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FontSizeFactoryTest {
    private FontSizeFactory fontSizeFactory = FontSizeFactory.getInstance();
    @Test
    public void testSameInstance(){
        FontSizeFactory instance1 = FontSizeFactory.getInstance();
        FontSizeFactory instance2 = FontSizeFactory.getInstance();
        assertSame(instance1, instance2);
    }


    @Test
    public void testIllegalSize(){
        Integer size = fontSizeFactory.getSize(-1);
        Integer expected = 1;
        assertEquals(size, expected);
    }


    @Test
    public void testSizeSameInstance(){
        Integer sizeInstance1 = fontSizeFactory.getSize(10);
        Integer sizeInstance2 = fontSizeFactory.getSize(10);
        assertSame(sizeInstance1, sizeInstance2);
    }
}
