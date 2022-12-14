/****************************************************************************************
 Error Class
 ***************************************************************************************
 Function:
 Based on incorrect input, outputs error message.
 *--------------------------------------------------------------------------------------
 @author Mia Park
 @version 04/14/2022   CMSC 355
 ****************************************************************************************/

import java.io.*;

public class Error {
    public static void main(String[] args) throws Exception {
        /*-------------------------------------------------------------
        // Read language file in Options.txt
        *-------------------------------------------------------------*/
        File file = new File("src/textfiles/Option.txt");
        BufferedReader a = new BufferedReader(new FileReader(file));
        String line =  a.readLine();
        line = line.replaceAll("\\s", "");
        String[] words = line.split(",",2);
        String l;
        /*-------------------------------------------------------------
        // call SB using service-oriented call
        *-------------------------------------------------------------*/
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", "TB" + "," + words[1] + "," + args[0]).start();
        /*-------------------------------------------------------------
        // read input from pb
        *-------------------------------------------------------------*/
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            while ((l = reader.readLine()) != null) {
                /*-------------------------------------------------------------
                // print error message to user
                *-------------------------------------------------------------*/
                System.out.println(l);
            }
        }
    }
}

