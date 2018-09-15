package demo;

import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Mincong Huang
 * @since 1.0
 */
public class MultipleDirectoriesTest {

  @Test
  public void testProperty() throws Exception {
    assertTrue(contentOf("foo.properties").startsWith("key=value"));
    assertEquals("File 1\n", contentOf("file1"));
    assertEquals("File 2\n", contentOf("file2"));
  }

  private String contentOf(String file) throws IOException {
    InputStream s = (InputStream) Thread.currentThread().getContextClassLoader()
        .getResource(file).getContent();
    return new String(s.readAllBytes(), UTF_8);
  }
}
