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
        //int i = 0;
        Process pb = new ProcessBuilder("java", "src/main/java/SB.java", "TB,msgEng.txt," + argsArray[1]).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
        }
        System.exit(0);
    }
}

