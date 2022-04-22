/****************************************************************************************
 OverallTest Class
 ***************************************************************************************
 Function:
 Tests Overall Program
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/21/2022   CMSC 355
 ****************************************************************************************/
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class OverallTest {
    @Test
    void testMissing1() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,2021,Single").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Incorrect Input", l);
    }
    @Test
    void testMissing2() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Translate,spanish").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Incorrect Input", l);
    }
    @Test
    void testMissing3() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Translate").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Incorrect Input", l);
    }
    @Test
    void testMissing4() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,fdsajhf,adhfjmfda").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Incorrect Input", l);
    }
    @Test
    void testMissing5() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Translate,2021,Single").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Language Not Found", l);
    }
    @Test
    void testMissing6() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,fdaj,Single,jfdkaj100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Incorrect Input", l);
    }
}