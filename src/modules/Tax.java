import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tax {
    public static void main(String[] args) throws Exception {
        String[] tax = args[0].split(",");
        int year = Integer.parseInt(tax[0]);
        String type = tax[1];
        int userGross = Integer.parseInt(tax[2]);
        switch (type) {
            case "Single" -> type = "S";
            case "Joint" -> type = "J";
            case "Head" -> type = "H";
        }
        String filer = year + type + ".txt";
        String set = "TB" + "," + filer + "," + userGross + "," + "<=";
        Process pb = new ProcessBuilder("java", "src/modules/SB.java", set).start();
        try (var reader = new BufferedReader(new InputStreamReader(pb.getInputStream()))) {
            String l;
            while ((l = reader.readLine()) != null) {
                System.out.println(l);
            }
//            float percentage = Float.parseFloat(l);
//            float taxes = userGross * percentage;
//            System.out.print(taxes);`
        }
    }
}
