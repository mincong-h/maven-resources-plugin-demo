package demo;

import java.io.InputStream;
import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertTrue;

/**
 * @author Mincong Huang
 * @since 1.0
 */
public class FilteringTest {

  @Test
  public void testProperty() throws Exception {
    InputStream s = (InputStream) Thread.currentThread().getContextClassLoader()
        .getResource("foo.properties").getContent();
    String actual = new String(s.readAllBytes(), UTF_8);
    assertTrue(actual.contains("pom=Value from POM"));
    assertTrue(actual.contains("cli="));
    assertTrue(actual.contains("filter=Value from Resource Filter"));
    assertTrue(actual.contains("myProp=Value from POM"));
    assertTrue(actual.contains("system="));
  }
}
