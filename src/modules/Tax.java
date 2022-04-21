/****************************************************************************************
 Tax Module Class
 ***************************************************************************************
 Function:
 Utilizes value from Text Broker to calculate taxes to be paid
 *--------------------------------------------------------------------------------------
 @author Anisha Beladia
 @version 04/19/2022   CMSC 355
  * ***************************************************************************************/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Tax {
    public static void main(String[] args) throws Exception {
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

        String[] tax = args[0].split(",");
        int year = Integer.parseInt(tax[0]);
        String type = tax[1];
        int userGross = 0;
        try {
            userGross = Integer.parseInt(tax[2]);
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
         *   Call TextBroker to look up tax bracket and return tax rate
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
        if (userGross <= 0) {
            System.out.println(0);
            System.exit(0);
        }
        String set = "TB" + "," + filer + "," + userGross + "," + "<=";
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", set).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                try {
                    double percentage = Double.parseDouble(l);
                    double taxes = userGross * percentage;
                    System.out.print(taxes);
                } catch (Exception e) {
                    System.out.println(l);
                }
            }
        }
    }
}
