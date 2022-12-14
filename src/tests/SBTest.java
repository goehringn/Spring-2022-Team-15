/****************************************************************************************
 SBTest Class
 ***************************************************************************************
 Function:
 Tests SB
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/21/2022   CMSC 355
 ****************************************************************************************/
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class SBTest {
    @Test
    void SBtestTax() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,2021,Single,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("24000.0", l);
    }
    @Test
    void SBtestTaxWrongYear() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,2022,Single,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Tax Year Not Found", l);
    }
    @Test
    void SBtestTaxWrongIncome() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,2021,Single,-1").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Not Found", l);
    }
    @Test
    void SBtestTaxWrongFiling() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Tax,2021,Sin,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Filing Status Not Found", l);
    }
    @Test
    void SBtestTrans() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Translate,spanish,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("perro", l);
    }
    @Test
    void SBtestTransWrongLangugae() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Translate,spani,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Language Not Found", l);
    }
    @Test
    void SBtestTransWrongWord() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Translate,spanish,do").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Word Not Found", l);
    }
    @Test
    void SBtestError() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Error,404").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {

            l = reader.readLine();
        }
        assertEquals("Not Found", l);
    }
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


}
