package flyweighttest;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CharacterPropertiesFactoryTest.class, ColorFactoryTest.class, FontFactoryTest.class,
FontSizeFactoryTest.class, ColorFactoryTest.class, DocumentTest.class })
public class FlyweightTestSuite {
}
