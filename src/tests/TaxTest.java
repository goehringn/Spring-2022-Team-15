/****************************************************************************************
 Tax Test Case Class
 ***************************************************************************************
 Function:
 Tests the functionality of the Tax Class
 *--------------------------------------------------------------------------------------
 @author Anisha Beladia
 @version 04/20/2022   CMSC 355
 ****************************************************************************************/

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static org.junit.jupiter.api.Assertions.*;

class TaxTest {
    //test that taxes to be paid when gross income is zero
    @Test
    void testGross1() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2021,Single,0").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("0", line);
    }

    //test that taxes to be paid when gross income is at the end of a tax bracket
    @Test
    void testGross2() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2021,Single,9950").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("995.0", line);
    }

    //test that that the command line has an argument
    @Test
    void testInput() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Not Found", l);
    }

    //test that that the command line has an a valid year (less than 2020)
    @Test
    void testYear1() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2019,Single,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Tax Year Not Found", l);
    }

    //test that that the command line has an a valid year (greater than 2021)
    @Test
    void testYear2() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2022,Single,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Tax Year Not Found", l);
    }

    //test that that the command line has an a valid filing status
    @Test
    void testFiling() throws Exception {
        String l;
        Process pb = new ProcessBuilder("java", "src/modules/Tax.java", "2021,ingle,100000").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            l = reader.readLine();
        }
        assertEquals("Filing Status Not Found", l);
    }

}