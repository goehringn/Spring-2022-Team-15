/****************************************************************************************
 TBTest Class
 ***************************************************************************************
 Function:
 Tests TB
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/21/2022   CMSC 355
 ****************************************************************************************/
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class TBTest {
    @Test
    void SBtestTB() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/TB.java", "spanish.txt,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("perro", l);
    }
    @Test
    void SBtestTBWrongWord() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/TB.java", "spanish.txt,do").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Word Not Found", l);
    }
    @Test
    void SBtestTBErrorCode() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/TB.java", "msgEnglish.txt,404").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Not Found", l);
    }
    @Test
    void SBtestTBTax() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/TB.java", "2021S.txt,100000,<=").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals(".24", l);
    }
}