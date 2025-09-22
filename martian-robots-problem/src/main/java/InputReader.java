import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    /**
     * Reads all non-empty lines from a resource file on the classpath.
     * Example: readLinesFromResource("/input.txt")
     */
    public static List<String> readLinesFromResource(String resourcePath) {
        InputStream in = InputReader.class.getResourceAsStream(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("Resource not found: " + resourcePath);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            return br.lines()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read resource: " + resourcePath, e);
        }
    }
}
