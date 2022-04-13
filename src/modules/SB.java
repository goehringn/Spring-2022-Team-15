/*****************************************************************************************
 * ServiceBroker Class
 * ***************************************************************************************
 * Function:
 *          Based on input, executes a certain module.
 * *--------------------------------------------------------------------------------------
 * @author Nathan Goehring
 * @version 04/12/2022   CMSC 355
 * ***************************************************************************************/

import java.io.*;
import java.util.*;

public class SB {
    public static void main(String args[]) throws Exception {
        //System.out.println(args[0]);
        String[] n = args[0].split(",", 2);
        //System.out.println(n[0]);
        //System.out.println(n[1]);
        String line;
        String output;
        File file = new File(
                "\\Sprint-2\\src\\Service.txt");
        BufferedReader a = new BufferedReader(new FileReader(file));
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",");
            if (n[0].equals(words[0])) {
                if (words[0].equals("Trans")) {
                    System.out.println("Trans");
                    Process pb = new ProcessBuilder("java", "-jar", words[1], n[1]).start();
                    try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                        output = reader.readLine();
                        System.out.println(output);
                    }
                }
            } else if (words[0].equals("Tax")) {
                System.out.println("Tax");
                Process pb = new ProcessBuilder("java", "-jar", words[1], n[1]).start();
                try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                    output = reader.readLine();
                    System.out.println(output);
                }
            } else if (words[0].equals("TB")) {
                Process pb = new ProcessBuilder("java", "-jar", words[1], n[1]).start();
                try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                    output = reader.readLine();
                    System.out.println(output);
                }

            } else if (words[0].equals("Error")) {
                System.out.println(words[1]);
                Process pb = new ProcessBuilder("java", "-jar", words[1], "Error").start();
                try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                    output = reader.readLine();
                    System.out.println(output);
                }
            }
        }

        Process pb = new ProcessBuilder("java", "-jar", "/Sprint-2/src/stub1.jar", "703").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            //NG
            output = reader.readLine();
            System.out.println(output);
        }

    }
}




