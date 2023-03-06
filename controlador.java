import java.util.Map;
import java.util.Scanner;

public class controlador {
private int opcion;
private int opcionMenu;
private readersito lector = new readersito();
private Map<Integer, Producto> inv;
private Map<Integer, Producto> carrito;
private boolean flag = true;
private Scanner teclado = new Scanner(System.in);
private tienda tienda = new tienda();
public void iniciar() {
    System.out.println("¡Bienvenido a nuestra tienda! Aquí encontrarás varios productos que pueden interesarte. ¿Qué tipo de mapa deseas utilizar? \n[1] TreeMap \n[2] HashMap \n[3] LinkedHashMap");
    opcion = teclado.nextInt();
    inv = factoryMaps.fabrica(opcion);
    carrito = factoryMaps.fabrica(opcion);
    lector.getInventory(inv, "ListadoProducto.txt");
    
    while (flag) {
        System.out.println("¿Qué desea hacer? \n [1] Agregar un producto al carrito \n [2] Ver la categoría de un producto \n [3] Ver el contenido del carrito \n [4] Filtrar el contenido del carrito por categoría \n [5] Ver todos los productos y sus categorías \n [6] Ver todos los productos y sus categorías ordenados \n [7] Salir");
        opcionMenu = teclado.nextInt();

        switch (opcionMenu) {
            case 1:
                System.out.println("Ingresa el nombre del producto:");
                String nombre = teclado.next();
                System.out.println("Ingresa la categoría del producto:");
                String categoria = teclado.next();
                System.out.println("Ingresa la cantidad del producto:");
                int cantidad = teclado.nextInt();
                boolean flag2 = false;
                
                for (Map.Entry<Integer, Producto> entry : inv.entrySet()) {
                    Producto producto = entry.getValue();
                    if (producto.getNombre().equals(nombre) && producto.getCateogria().equals(categoria)) {
                        tienda.addCarrito(carrito, nombre, categoria, cantidad);
                        flag2 = true;
                    }
                }
                if (!flag2) {
                    System.out.println("No se encontró ningún producto con el nombre y la categoría especificados.");
                }
                break;

            case 2:
                System.out.println("Ingresa el nombre del producto:");
                String nombreProducto = teclado.next();
                System.out.println(tienda.buscarCategoriaProducto(inv, nombreProducto));
                break;

            case 3:
                System.out.println(tienda.produtosSinSort(carrito));
                break;

            case 4:
                System.out.println(tienda.productosOrdPorCategoria(carrito));
                break;

            case 5:
                System.out.println(tienda.produtosSinSort(inv));
                break;

            case 6:
                System.out.println(tienda.productosOrdPorCategoria(inv));
                break;

            case 7:
                System.out.println("¡Gracias por visitarnos, vuelva pronto!");
                flag = false;
                break;

            default:
                System.out.println("Por favor, ingresa un número válido.");
                break;
        }
    }
}

}