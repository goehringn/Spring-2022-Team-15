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



public class SB {
    public static void main(String[] args) throws Exception {
        String srcpath = new File(".").getCanonicalPath();
        String[] argsArray = new String[0];
        try {
            argsArray = args[0].split(",", 2);
        }catch(Exception e){
            Process pb = new ProcessBuilder("java", srcpath+"/src/modules/Error.java", "400").start();
            try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                String l;
                while ((l = reader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            System.exit(0);
        }
        String line;
        File file = new File(srcpath+"/src/textfiles/Service.txt");
        BufferedReader a = new BufferedReader(new FileReader(file));
        while ((line = a.readLine()) != null) {
            String[] words = line.split(",");
            if (argsArray[0].equals(words[0])) {
                switch (words[0]) {
                    case "Trans" -> {
                        System.out.println("Trans");
                        Process pb = new ProcessBuilder("java", srcpath+"/src/modules/Trans.java", argsArray[1]).start();
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
                        Process pb = new ProcessBuilder("java", srcpath+"/src/modules/Tax.java", argsArray[1]).start();
                        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                            String l;
                            l = reader.readLine();
                            System.out.println(l);
                        }
                        System.exit(0);
                    }
                    case "TB" -> {
                        //Process pb = new ProcessBuilder("java", "-jar", srcpath+words[1], argsArray[1]).start();
                        Process pb = new ProcessBuilder("java", srcpath+"/src/modules/TB.java", argsArray[1]).start();
                        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
                            String l;
                            l = reader.readLine();
                            System.out.println(l);
                        }
                        System.exit(0);
                    }
                    case "Error" -> {
                        System.out.println(words[1]);
                        Process pb = new ProcessBuilder("java", srcpath+"/src/modules/Error.java", "Error").start();
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
        Process pb = new ProcessBuilder("java", srcpath+"/src/modules/Error.java", "404").start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }

        }
    }
}
