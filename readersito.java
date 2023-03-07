/**
 * @author Julio García Salas
 * Tare: Hoja de trabajo 6
 * Archivo: readersito.java
 * Fecha: 06/03/2023
 */

 import java.io.File;
 import java.util.Map;
 import java.util.Scanner;
 
 public class readersito {
 
     public void getInventory(Map <Integer, Producto> productoTree, String filename) {
         try {
                Scanner input = new Scanner(new File(filename));
                int i = 1;
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] tokens = line.split(" \\|	");
                    productoTree.put(i, new Producto(tokens[1], tokens[0], 55));
                    i++;
                }
                input.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
 }
 