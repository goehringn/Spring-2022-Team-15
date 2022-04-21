/****************************************************************************************
 Error Test Case Class
 ***************************************************************************************
 Function:
 Tests the functionality of the Error Class
 *--------------------------------------------------------------------------------------
 @author Mia Park
 @version 04/19/2022   CMSC 355
 ****************************************************************************************/

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import static org.junit.jupiter.api.Assertions.*;

class ErrorTest {
    //test that "404" outputs "Not Found" in English (tests for default language)
    @Test
    void testEng404() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "404").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("Not Found", line);
    }
    //test that "703" outputs "Service Not Found" in English (tests for default language)
    @Test
    void testEng703() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "703").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("Service Not Found", line);
    }
    //test that "805" outputs "Language Not Found" in English
    @Test
    void testEng805() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "805").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("Language Not Found", line);
    }
    //test that "813" outputs "Word Not Found" in English
    @Test
    void testEng813() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "813").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("Word Not Found", line);
    }
    //test that "903" outputs "Tax Year Not Found" in English (tests for default language)
    @Test
    void testEng903() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "903").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("Tax Year Not Found", line);
    }
    //test that "876" outputs "Filling Status Not Found" in English
    @Test
    void testEng876() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "876").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("Filling Status Not Found", line);
    }
}
