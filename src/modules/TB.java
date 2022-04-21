/****************************************************************************************
 TextBroker Class
 ***************************************************************************************
 Function:
 Retrieves information from text files for taxes, errors, or translations.
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/21/2022   CMSC 355
 ****************************************************************************************/

import java.io.*;

public class TB {
    public static void main(String[] args) throws Exception {
        /*-------------------------------------------------------------
        // Divide input up based on commas
        *-------------------------------------------------------------*/
        String[] b = args[0].split(",");
        String line;
        /*-------------------------------------------------------------
        // open file and get ready to read file
        *-------------------------------------------------------------*/
        File file = new File(
                "src/textfiles/" + b[0]);
        BufferedReader a = new BufferedReader(new FileReader(file));
        /*-------------------------------------------------------------
        // if array length is greater than 2 and <= is included then search
        // through file until userGross is <= to incomeAmount found in file
        // and return percentage tax user owes to Tax module
        *-------------------------------------------------------------*/
        if (b.length > 2) {
            if (b[2].equals("<=")) {
                int userGross = Integer.parseInt(b[1]);
                while ((line = a.readLine()) != null) {
                    String[] words = line.split(",");
                    int incomeAmount = 0;
                    incomeAmount = Integer.parseInt(words[0]);
                    if (userGross <= incomeAmount) {
                        System.out.println(words[1]);
                        System.exit(0);
                    }
                }
            }
        }
        /*-------------------------------------------------------------
        // If not Tax then we read through file to find matching word or
        // error code and print out translation of word or code
        *-------------------------------------------------------------*/
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",");
            if (words[0].equals(b[1])) {
                System.out.println(words[1]);
                System.exit(0);
            }
        }
        /*-------------------------------------------------------------
        // if nothing is found in file then we pass word not found error code
        // to error module
        *-------------------------------------------------------------*/
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "813").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
        }
        System.exit(0);

    }
}


