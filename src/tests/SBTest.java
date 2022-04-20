import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class SBTest {
    @Test
    void SBtest() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/TB.java", "spanish.txt,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("perro", l);
    }
}
