import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class SBTest {
    @Test
    void name() throws Exception{
        String l;
        Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "404").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Not Found",l);
    }
}