/****************************************************************************************
 Translator Class
 ***************************************************************************************
 Function:
 Returns a translated version of a word based on the language specified by the user
 *--------------------------------------------------------------------------------------
 @author Mason Delane
 @version 04/13/2022   CMSC 355
  * ***************************************************************************************/


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Trans {
    public static void main(String[] args) throws Exception {
        String[] Trans = args[0].split(",");
        Trans[0] = Trans[0].toLowerCase();
        String convert = Trans[0] + ".txt";
        Path path = Paths.get("src/textfiles/" + convert);
        if (!Files.exists(path)) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "805").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        String word = Trans[1].toLowerCase();

        String set = "TB" + "," + convert + "," + word;

        Process pb = new ProcessBuilder("java", "src/modules/SB.java", set).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
        }
    }
}