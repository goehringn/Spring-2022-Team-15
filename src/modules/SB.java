/****************************************************************************************
 ServiceBroker Class
 ***************************************************************************************
 Function:
 Based on input, executes a certain module.
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/12/2022   CMSC 355
 * ***************************************************************************************/

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;


public class SB {
    public static void main(String[] args) throws Exception {
        //System.out.println(args[0]);
        String[] n = args[0].split(",", 2);
        //System.out.println(n[0]);
        //System.out.println(n[1]);
        String line;
        String srcpath = new File("src").getAbsolutePath();
        File file = new File(
                 srcpath + "\\textfiles\\Service.txt");
        BufferedReader a = new BufferedReader(new FileReader(file));
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",");
            if (n[0].equals(words[0])) {
                switch (words[0]) {
                    case "Trans" -> {
                        System.out.println("Trans");
                        Process pb = new ProcessBuilder("java", "-jar", words[1], n[1]).start();
                        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                            String l;
                            while ((l = reader.readLine()) != null) {
                                System.out.println(l);
                            }
                        }
                        System.exit(0);
                    }
                    case "Tax" -> {
                        System.out.println("Tax");
                        Process pb = new ProcessBuilder("java", "-jar", words[1], n[1]).start();
                        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                            String l;
                            l = reader.readLine();
                            System.out.println(l);
                        }
                        System.exit(0);
                    }
                    case "TB" -> {
                        Process pb = new ProcessBuilder("java", "-jar", words[1], n[1]).start();
                        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                            String l;
                            l = reader.readLine();
                            System.out.println(l);
                        }
                        System.exit(0);
                    }
                    case "Error" -> {
                        System.out.println(words[1]);
                        Process pb = new ProcessBuilder("java", "-jar", words[1], "Error").start();
                        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                            String l;
                            while ((l = reader.readLine()) != null) {
                                System.out.println(l);
                            }

                        }
                        System.exit(0);
                    }
                }
            }
        }
        Process pb = new ProcessBuilder("java", "-jar", srcpath + "\\modules\\stub1.jar", "813").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }

        }
    }
}