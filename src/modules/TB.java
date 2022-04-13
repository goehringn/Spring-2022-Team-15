/*****************************************************************************************
 * TextBroker Class
 * ***************************************************************************************
 * Function:
 *          Retrieves information from text files for taxes, errors, or translations.
 * *--------------------------------------------------------------------------------------
 * @author Nathan Goehring
 * @version 04/12/2022   CMSC 355
 * ***************************************************************************************/

import java.io.*;

public class TB {
    public static void main(String args[]) throws Exception {
        /*if (args[0].equals("English")) {
            String line;
            File file = new File(
                    "C:\\Sprint2\\src\\main\\java\\Service.txt");
            BufferedReader a = new BufferedReader(new FileReader(file));
            while ((line = a.readLine()) != null) {
                String[] words = line.split(",");
                for (String word : words) {
                    if (word.equals("Trans")) {
                        System.out.println("The word was found");
                    }
                }
            }

        }*/
        String[] b = args[0].split(",");
        String line;
        File file = new File(
                "/Sprint-2/src/", b[0]);
        BufferedReader a = null;
        try {
            a = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            Process pb = new ProcessBuilder("java", "-jar", "/Sprint-2/src/stub1.jar", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String output;
                output = reader.readLine();
                System.out.println(output);
            }
            System.exit(0);
        }
        String j = b[0].substring(0, 4);
        try {
            Integer.parseInt(j);
        } catch (NumberFormatException e) {
            while ((line = a.readLine()) != null) {
                String[] words = line.split(",");
                if (words[0].equals(b[1])) {
                    System.out.println(words[1]);
                    System.exit(0);
                }
            }
            Process pb = new ProcessBuilder("java", "-jar", "/Sprint-2/src/stub1.jar", "813").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String output;
                output = reader.readLine();
                System.out.println(output);
            }
            System.exit(0);
        }
        int userGross = 0;
        try {
            userGross = Integer.parseInt(b[1]);
        } catch (NumberFormatException e) {
            Process pb = new ProcessBuilder("java", "-jar", "/Sprint-2/src/stub1.jar", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String output;
                output = reader.readLine();
                System.out.println(output);
            }
            System.exit(0);
        }
        if (userGross <= 0) {
            Process pb = new ProcessBuilder("java", "-jar", "/Sprint-2/src/stub1.jar", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String output;
                output = reader.readLine();
                System.out.println(output);
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

