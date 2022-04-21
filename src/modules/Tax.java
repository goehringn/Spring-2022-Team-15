/****************************************************************************************
 Tax Module Class
 ***************************************************************************************
 Function:
 Utilizes value from the Text Broker to calculate the taxes to be paid
 *--------------------------------------------------------------------------------------
 @author Anisha Beladia
 @version 04/19/2022   CMSC 355
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
         *  Test to see if the command line has inputs
         *--------------------------------------------------------------*/
        if (args[0].equals("")) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }

        /*--------------------------------------------------------------
         *  Parse through the command line to split the string of arrays by commas and set
         *  to variables; year, filing type, and user gross
         * --------------------------------------------------------------*/
        String[] tax = args[0].split(",");
        int year = Integer.parseInt(tax[0]);        // filing year
        String type = tax[1];       // filing type
        int userGross = Integer.parseInt(tax[2]);     // total gross income

        /*---------------------------------------------------------------
         *  Make a service oriented call to throw an error when the gross income is not found
         *--------------------------------------------------------------*/
        if (userGross <= 0) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }

        /*---------------------------------------------------------------
         *  Make a service oriented call to throw an error when the tax year is not found
         * (greater than 2021 & less than 2020)
         *--------------------------------------------------------------*/
        if (year < 2020 || year >2021) {
            Process pb1 = new ProcessBuilder("java", "src/modules/Error.java", "903").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb1.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
                System.exit(0);
            }
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
                Process pb = new ProcessBuilder("java", "src/modules/Error.java", "876").start();
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
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "903").start();
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
         *  Read and store the tax bracket percentage in the char "l"
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
