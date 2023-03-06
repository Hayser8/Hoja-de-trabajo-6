
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class tienda {
    public tienda()
    {}
    public void addCarrito(Map<Integer, Producto> carrito, String producto, String categoria, int cantidad)
    {
        int indice = carrito.size() +1;
        Producto Producto = new Producto(producto, categoria, cantidad);
        carrito.put(indice, Producto);
    }
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
            resultado += "\n\nCategoría: " + categoria + "\n";
            List<Producto> productosDeCategoria = productosPorCategoria.get(categoria);
            productosDeCategoria.sort(Comparator.comparing(Producto::getNombre));
            for (Producto producto : productosDeCategoria) {
                resultado += "Categoría: " + producto.getCateogria() + ", Producto: " + producto.getNombre() + ", Cantidad en lista: " + producto.getExistence() + "\n";
            }
        }
        return resultado;
    }
    public String buscarCategoriaProducto(Map<Integer, Producto> productos, String nombreProducto) {
        for (Producto producto : productos.values()) {
            if (producto.getNombre().equals(nombreProducto)) {
                return String.format("La categoría del producto '%s' es '%s'", nombreProducto, producto.getCateogria());
            }
        }
        return String.format("No se encontró el producto con nombre '%s'", nombreProducto);
    }
    public String produtosSinSort(Map<Integer, Producto> productos) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Producto> producto : productos.entrySet()) {
            int indice = producto.getKey();
            String categoria = producto.getValue().getCateogria();
            String nombre = producto.getValue().getNombre();
            int existencias = producto.getValue().getExistence();
            sb.append("Indice: ").append(indice).append(", Categoría: ").append(categoria).append(", Producto: ").append(nombre).append(", Cantidad en lista: ").append(existencias).append("\n");
        }
        return sb.toString();
    }
    
    
    
}
