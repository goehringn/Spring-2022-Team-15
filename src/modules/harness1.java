import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class harness1 {
    public static void main (String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Service and parameters in the form SERVICE,\"PARAMETERS,PARAMETERS..\"");
        String a = in.nextLine();
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", a).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
        }
    }
}
