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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.io.*;
import java.util.*;

public class Error {
    public static void main(String[] args) throws Exception {
        //args will be Language,message-code
        //need to split args to get Language and then message code
        String[] argsArray = args[0].split(",");
        String language;
        int code = 404;
        String filer = "msgEng.txt";
        String set;
        String line;
        // default language file to English if one is not provided
        if (argsArray.length == 1) {
            code = Integer.parseInt(argsArray[0]);
        }
        else if (argsArray.length == 2){
            language = argsArray[0].substring(0, 3);
            code = Integer.parseInt(argsArray[1]);
            // format language.txt file
            filer = "msg" + language + ".txt";
        }
        // format arguments for calling SB
        set = "TB" + "," + filer + "," +  code;
        // call SB using service-oriented call
        Process pb = new ProcessBuilder("java", "src/main/java/SB.java", set).start();
        // read input from pb
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            while ((line = reader.readLine()) != null) {
                // print error message to user
                System.out.println(line);
            }
        }
    }
}

