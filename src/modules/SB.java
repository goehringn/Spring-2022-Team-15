/****************************************************************************************
 ServiceBroker Class
 ***************************************************************************************
 Function:
 Based on input, executes a certain module.
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/21/2022   CMSC 355
 ****************************************************************************************/

import java.io.*;
import java.util.Arrays;


public class SB {
    public static void main(String[] args) throws Exception {
        /*-------------------------------------------------------------
        // if no input provided throw error
        *-------------------------------------------------------------*/
        if (args.length == 0) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
        }
        /*-------------------------------------------------------------
        // remove white space from input so no errors occur
        *-------------------------------------------------------------*/
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < args.length; i++) {
            sb.append(args[i]);
        }
        String str = sb.toString();
        args[0] = str;
        /*-------------------------------------------------------------
        // Divide input up to get service and parmlist. If args cannot split at
        // comma we have an invalid input and error is thrown
        *-------------------------------------------------------------*/
        String[] argsArray = new String[0];
        try {
            argsArray = args[0].split(",", 2);
        } catch (Exception e) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        /*-------------------------------------------------------------
        // Search through Service.txt file for service and then call
        // service based on path included in file and pass parameters
        *-------------------------------------------------------------*/
        String line;
        argsArray[0] = argsArray[0].substring(0, 1).toUpperCase() + argsArray[0].substring(1);
        File file = new File("src/textfiles/Service.txt");
        BufferedReader a = new BufferedReader(new FileReader(file));
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",", 2);
            if (argsArray[0].equals(words[0])) {
                Process pb = new ProcessBuilder("java", words[1], argsArray[1]).start();
                /*-------------------------------------------------------------
                // return output of running services
                *-------------------------------------------------------------*/
                try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                    String l;
                    while ((l = reader.readLine()) != null) {
                        System.out.println(l);
                    }
                }
                System.exit(0);
            }
        }
        /*-------------------------------------------------------------
        // Throw service not found error if service cannot be found in file
        *-------------------------------------------------------------*/
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "703").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }

        }
    }
}
