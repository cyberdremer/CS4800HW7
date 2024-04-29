package flyweighttest;

import org.example.flyweight.propertyfactories.ColorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ColorFactoryTest {
    private ColorFactory colorFactory = ColorFactory.getInstance();


    @Test
    public void testSameInstance(){
        ColorFactory instance1 = colorFactory.getInstance();
        ColorFactory instance2 = colorFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testSameColorInstance(){
        String color1 = colorFactory.getColor("Red");
        String color2 = colorFactory.getColor("Red");
        assertSame(color1,color2);

    }
}
