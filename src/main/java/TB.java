/****************************************************************************************
 TextBroker Class
 ***************************************************************************************
 Function:
 Retrieves information from text files for taxes, errors, or translations.
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/12/2022   CMSC 355
  * ***************************************************************************************/

import java.io.*;

public class TB {
    public static void main(String[] args) throws Exception {
        String[] b = args[0].split(",");
        String line;
        File file = new File(
                "src/main/textfiles/" + b[0]);
        BufferedReader a = null;
        try {
            a = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        if (b.length > 2) {
            if (b[2].equals("<=")) {
                int userGross = 0;
                try {
                    userGross = Integer.parseInt(b[1]);
                } catch (NumberFormatException e) {
                    Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "404").start();
                    try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                        String l;
                        while ((l = reader.readLine()) != null) {
                            System.out.println(l);
                        }
                    }
                    System.exit(0);
                }
                if (userGross <= 0) {
                    Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "404").start();
                    try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                        String l;
                        while ((l = reader.readLine()) != null) {
                            System.out.println(l);
                        }
                    }
                    System.exit(0);
                }
                while ((line = a.readLine()) != null) {
                    String[] words = line.split(",");
                    int incomeAmount = 0;
                    try {
                        incomeAmount = Integer.parseInt(words[0]);
                    } catch (NumberFormatException e) {
                        System.out.println(words[1]);
                        System.exit(0);
                    }
                    if (userGross <= incomeAmount) {
                        System.out.println(words[1]);
                        System.exit(0);
                    }
                }
            }
        }

        while ((line = a.readLine()) != null) {
            String[] words = line.split(",");
            if (words[0].equals(b[1])) {
                System.out.println(words[1]);
                System.exit(0);
            }
        }
            Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "813").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
    }


