/****************************************************************************************
 Tax Module Class
 ***************************************************************************************
 Function:
 Utilizes value from the Text Broker to calculate the taxes to be paid
 *--------------------------------------------------------------------------------------
 @author Anisha Beladia
 @version 05/02/2022   CMSC 355
  * ***************************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//  To Test: Java ./src/modules/Tax.java "2021,Single,100000,<="
public class Tax {
    public static void main(String[] args) throws Exception {
        /*--------------------------------------------------------------
         *  Parse through the command line to split the string of arrays by commas and set
         *  to variables; year, filing type, and user gross
         * --------------------------------------------------------------*/
        String[] tax = args[0].split(",");
        if(tax.length < 3){
            Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Error,890").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        int userGross=0;
        String type = null;
        int year = 0;
        /*---------------------------------------------------------------
         *  try to interpret as int and if an exception is thrown, the
         *  input is incorrect
         *--------------------------------------------------------------*/
        try {
            year = Integer.parseInt(tax[0]);        // filing year
            type = tax[1];       // filing type
            userGross = Integer.parseInt(tax[2]);     // total gross income
        }catch (Exception e){
            Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Error,890").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        /*---------------------------------------------------------------
         *  Make a service oriented call to throw an error when the gross income is not found
         *--------------------------------------------------------------*/
        if (userGross <= 0) {
            Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Error,404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }


        /*---------------------------------------------------------------
         *  Format the filing type to the appropriate shorthand characters;
         *  Make a service-oriented call to throw an error when the filing status is invalid
         *---------------------------------------------------------------*/
        switch (type) {
            case "Single" -> type = "S";
            case "Joint" -> type = "J";
            case "Head" -> type = "H";
            default -> {
                Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Error,876").start();
                try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                    String l;
                    while ((l = reader.readLine()) != null) {
                        System.out.println(l);
                    }

                }
                System.exit(0);
            }
        }

        /*---------------------------------------------------------------
         *  Format the string that must be called;
         *  Check to see if the file path exists and throw and error if missing
         *---------------------------------------------------------------*/
        String filer = year + type + ".txt";
        Path path = Paths.get("src/textfiles/" + filer);
        if (!Files.exists(path)) {
            Process pb = new ProcessBuilder("java", "src/modules/SB.java", "Error,903").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        String set = "TB" + "," + filer + "," + userGross + "," + "<=";
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", set).start();
        /*---------------------------------------------------------------
         *  Read and store the tax bracket percentage in the string "l"
         *---------------------------------------------------------------*/
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            /*---------------------------------------------------------------
             *  Calculate the taxes to be paid using the value from the Text Broker
             *---------------------------------------------------------------*/
            while ((l = reader.readLine()) != null) {
                double percentage = Double.parseDouble(l);
                double taxes = userGross * percentage;
                /*---------------------------------------------------------------
                 *  Print the taxes to be paid
                 *---------------------------------------------------------------*/
                System.out.print(taxes);
            }
        }
    }
}
