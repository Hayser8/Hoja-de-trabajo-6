/**
 * @author Julio García Salas
 * Tare: Hoja de trabajo 6
 * Archivo: tienda.java
 * Fecha: 06/03/2023
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class tienda {
    public tienda()
    {}
    /**
    Este método agrega un producto al carrito de compras.
    @param carrito Un objeto Map que representa el carrito de compras.
    @param producto Un String que representa el nombre del producto a agregar.
    @param categoria Un String que representa la categoría del producto a agregar.
    @param cantidad Un int que representa la cantidad del producto a agregar.
    **/
    public void addCarrito(Map<Integer, Producto> carrito, String producto, String categoria, int cantidad)
    {
        int indice = carrito.size() +1;
        Producto Producto = new Producto(producto, categoria, cantidad);
        carrito.put(indice, Producto);
    }
    /**
    Este método ordena los productos en el inventario por categoría y luego los muestra en un String.
    @param productos Un objeto Map que representa el inventario de la tienda.
    @return Un String que contiene los productos ordenados por categoría.
    */
    public String productosOrdPorCategoria(Map<Integer, Producto> productos) {
        Map<String, List<Producto>> productosPorCategoria = new HashMap<>();
        for (Producto producto : productos.values()) {
            String categoria = producto.getCateogria();
            productosPorCategoria.computeIfAbsent(categoria, k -> new ArrayList<>()).add(producto);
        }
        List<String> categoriasOrdenadas = new ArrayList<>(productosPorCategoria.keySet());
        Collections.sort(categoriasOrdenadas);
    
        String resultado = "";
        for (String categoria : categoriasOrdenadas) {
            resultado += "***************************************************************************";
            resultado += "\n\t\tCategoría: " + categoria + "\n";
            resultado += "***************************************************************************\n";
            List<Producto> productosDeCategoria = productosPorCategoria.get(categoria);
            productosDeCategoria.sort(Comparator.comparing(Producto::getNombre));
            for (Producto producto : productosDeCategoria) {
                resultado += "Categoría: " + producto.getCateogria() + "; Producto: " + producto.getNombre() + "; Cantidad: " + producto.getExistence() + "\n---------------------------------------------------------------------------------\n";
            }
        }
        return resultado;
    }
    /**
    Este método busca la categoría de un producto en el inventario y lo muestra en un String.
    @param productos Un objeto Map que representa el inventario de la tienda.
    @param nombreProducto Un String que representa el nombre del producto a buscar.
    @return Un String que contiene la categoría del producto buscado, o un mensaje de error si el producto no se encuentra.
    */
    public String buscarCategoriaProducto(Map<Integer, Producto> productos, String nombreProducto) {
        for (Producto producto : productos.values()) {
            if (producto.getNombre().equals(nombreProducto)) {
                return String.format("La categoría del producto '%s' es '%s'", nombreProducto, producto.getCateogria());
            }
        }
        return String.format("No se encontró el producto con nombre '%s'", nombreProducto);
    }
    /**
    Este método muestra los productos en el inventario en un String, sin ordenarlos.
    @param productos Un objeto Map que representa el inventario de la tienda.
    @return Un String que contiene los productos sin ordenar.
    */
    public String produtosSinSort(Map<Integer, Producto> productos) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Producto> producto : productos.entrySet()) {
            int indice = producto.getKey();
            String categoria = producto.getValue().getCateogria();
            String nombre = producto.getValue().getNombre();
            int existencias = producto.getValue().getExistence();
            sb.append("Producto número: ").append(indice).append("; Categoría: ").append(categoria).append("; Producto: ").append(nombre).append("; Cantidad: ").append(existencias).append("\n");
        }
        return sb.toString();
    }
    
    
    
}
