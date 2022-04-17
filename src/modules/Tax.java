import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tax {
    public static void main(String[] args) throws Exception {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input = read.readLine();
        String[] tax = input.split(",");

        int year = Integer.parseInt(tax[0]);
        String type = tax[1];
        int userGross = Integer.parseInt(tax[2]);

        String filer = year + type.toString() + ".txt";
        String set = "TB" + "," + "\""+ filer + "," + userGross + "\"";

        System.out.print(set);


        Process pb = new ProcessBuilder("java", "src/modules/TB.java", set).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            l = reader.readLine();
            System.out.print(l);
//            float percentage = Float.parseFloat(l);
//            float taxes = userGross * percentage;
//            System.out.print(taxes);`
        }
        System.exit(0);


    }
}
