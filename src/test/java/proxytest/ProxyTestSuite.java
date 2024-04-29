package proxytest;


import org.example.proxy.streamingservice.AppleMusic;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({AppleMusicCacheTest.class, AppleMusic.class})
public class ProxyTestSuite {
}
