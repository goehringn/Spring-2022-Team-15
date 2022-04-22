/****************************************************************************************
 Translator Class
 ***************************************************************************************
 Function:
 Returns a translated version of a word based on the language specified by the user
 *--------------------------------------------------------------------------------------
 @author Mason Delane
 @version 04/13/2022   CMSC 355
  * ***************************************************************************************/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Translate {
    public static void main(String[] args) throws Exception {

        /*-------------------------------------------------------------
        // splitting input at the comma and separating language of translation
        // and word to be translated
        *-------------------------------------------------------------*/
        String[] Trans = args[0].split(",");
        Trans[0] = Trans[0].toLowerCase();
        String convert = Trans[0] + ".txt";

        /*-------------------------------------------------------------
        // error handling for if an invalid language is inputted
        *-------------------------------------------------------------*/
        Path path = Paths.get("src/textfiles/" + convert);
        if (!Files.exists(path)) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "805").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    // System.out.println(l);
                }
            }
            System.out.println("805");
            System.exit(0);
        }

        /*--------------------------------------------------------------
        // Format the string that must be called;
        // Check to see if the file path exists and throw and error if missing
         *-------------------------------------------------------------*/
        String word = Trans[1].toLowerCase();
        String set = "TB" + "," + convert + "," + word;

        Process pb = new ProcessBuilder("java", "src/modules/SB.java", set).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            /*-------------------------------------------------------------
            // find the correct file path and finally print the properly
            // translated word
            *-------------------------------------------------------------*/
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
        }
    }
}
