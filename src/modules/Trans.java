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

public class Trans {
    public static void main(String[] args) throws Exception {

        String[] Trans = args[0].split(",");
        String language = Trans[0];
        String convert = language + ".txt";
        String word = Trans[1];

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