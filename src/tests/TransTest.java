/****************************************************************************************
 Translator Test Class
 ***************************************************************************************
 Function:
 Tests the functionality of the Translator Class
 *--------------------------------------------------------------------------------------
 @author Mason Delane
 @version 04/19/2022   CMSC 355
  * ***************************************************************************************/


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;


class TransTest {

  /*-------------------------------------------------------------
    // test for proper translation of the word dog to spanish
    *-------------------------------------------------------------*/

    @Test
    void testLanguage1() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Translate.java", "spanish,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("perro", line);
    }

  /*-------------------------------------------------------------
    // test for proper translation of the word dog to german
    *-------------------------------------------------------------*/

    @Test
    void testLanguage2() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Translate.java", "german,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("hund", line);
    }

    /*-------------------------------------------------------------
      // test for proper translation of the word dog to french
      *-------------------------------------------------------------*/
    @Test
    void testLanguage3() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Translate.java", "french,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("chien", line);
    }

    /*-------------------------------------------------------------
      // test for error code output if the word entered is not found in the text file
      *-------------------------------------------------------------*/
    @Test
    void testLanguage4() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Translate.java", "spanish,bedroom").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("813", line);
    }

    /*-------------------------------------------------------------
      // test for error code output if the language entered is not found in the text file
      *-------------------------------------------------------------*/
    @Test
    void testLanguage5() throws Exception {
        String line;
        Process pb = new ProcessBuilder("java", "src/modules/Translate.java", "arabic,dog").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            line = reader.readLine();
        }
        assertEquals("805", line);
    }


}
