/****************************************************************************************
 ServiceBroker Class
 ***************************************************************************************
 Function:
 Based on input, executes a certain module.
 *--------------------------------------------------------------------------------------
 @author Nathan Goehring
 @version 04/19/2022   CMSC 355
 * ***************************************************************************************/

import java.io.*;



public class SB {
    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
        }
        String[] argsArray = new String[0];
        try {
            argsArray = args[0].split(",", 2);
        }catch(Exception e){
            Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "404").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        String line;
        File file = new File("src/main/textfiles/Service.txt");
        BufferedReader a = new BufferedReader(new FileReader(file));
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",",2);
            if (argsArray[0].equals(words[0])) {
                Process pb = new ProcessBuilder("java", words[1], argsArray[1]).start();
                try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                    String l;
                    while ((l = reader.readLine()) != null) {
                        System.out.println(l);
                    }
                }
                System.exit(0);
            }
        }
        Process pb = new ProcessBuilder("java", "src/main/java/Error.java", "703").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }

        }
    }
}
