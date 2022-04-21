/****************************************************************************************
 Error Test Case Class
 ***************************************************************************************
 Function:
 Tests the functionality of the Error Class
 *--------------------------------------------------------------------------------------
 @author Anisha Beladia
 @version 04/20/2022   CMSC 355
 ****************************************************************************************/

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static org.junit.jupiter.api.Assertions.*;

class ErrorTest {
    //test that taxes to be paid when gross income is zero
    @Test
    void testFiling() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2021,Single,0").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals(0, line);
    }

    //test that taxes to be paid when gross income is at the end of a tax bracket
    @Test
    void testFiling() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2021,Single,9950").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals(995.0, line);
    }

    //test that taxes to be paid when gross income is 100,000
    @Test
    void testFiling() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2021,Single,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals(24000.0, line);
    }

}