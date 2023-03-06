import java.io.File;
import java.util.Map;
import java.util.Scanner;
public class readersito {
    public void readInventory(Map<Integer, Producto> productMap, String fileName) {
        try {
               Scanner scanner = new Scanner(new File(fileName));
               int indice = 1;
               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   String[] tokens = line.split(" \\| ");
                   productMap.put(indice, new Producto(tokens[1], tokens[0], 10));
                   indice++;
               }
               scanner.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
}
