package demo;

import java.io.InputStream;
import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;

/**
 * @author Mincong Huang
 * @since 1.0
 */
public class ResourcesTest {

  @Test
  public void srcResources() throws Exception {
    InputStream s = (InputStream) Thread.currentThread().getContextClassLoader()
        .getResource("foo.properties").getContent();
    assertEquals("key=value\n", new String(s.readAllBytes(), UTF_8));
  }

  @Test
  public void testResources() throws Exception {
    InputStream s = (InputStream) Thread.currentThread().getContextClassLoader()
        .getResource("bar.properties").getContent();
    assertEquals("key=testValue\n", new String(s.readAllBytes(), UTF_8));
  }
}
