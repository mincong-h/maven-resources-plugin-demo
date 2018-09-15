package demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Mincong Huang
 * @since 1.0
 */
public class IncludeExcludeTest {

  @Test
  public void include() throws Exception {
    assertEquals("Foo\n", contentOf("foo.txt"));
    assertEquals("Bar\n", contentOf("myDir/bar.txt"));
  }

  @Test
  public void exclude() throws Exception {
    assertNull(contentOf("foo-internal.txt"));

  }

  private String contentOf(String file) throws IOException {
    URL resourceUrl = Thread.currentThread().getContextClassLoader()
        .getResource(file);
    if (resourceUrl == null) {
      return null;
    } else {
      InputStream s = (InputStream) resourceUrl.getContent();
      return new String(s.readAllBytes(), UTF_8);
    }
  }
}
