/****************************************************************************************
 TextBroker Class
 ***************************************************************************************
 Function:
 Retrieves information from text files for taxes, errors, or translations.
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/19/2022   CMSC 355
  * ***************************************************************************************/

import java.io.*;

public class TB {
    public static void main(String[] args) throws Exception {
        String[] b = args[0].split(",");
        String line;
        File file = new File(
                "src/textfiles/" + b[0]);
        BufferedReader a = new BufferedReader(new FileReader(file));
        if (b.length > 2) {
            if (b[2].equals("<=")) {
                int userGross = Integer.parseInt(b[1]);
                ;
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
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",");
            if (words[0].equals(b[1])) {
                System.out.println(words[1]);
                System.exit(0);
            }
        }
        line = a.readLine();
        try {
            Integer.parseInt(line);
        } catch (Exception e) {
            Process pb = new ProcessBuilder("java", "src/modules/Error.java", "813").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        Process pb = new ProcessBuilder("java", "src/modules/Error.java", "404").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
        }
        System.exit(0);
    }
}


