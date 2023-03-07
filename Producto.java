/**
 * @author Julio García Salas
 * Tare: Hoja de trabajo 6
 * Archivo: Producto.java
 * Fecha: 06/03/2023
 */
public class Producto {
    private String nombre;
    private String cateogria;
    private int existence;
    public Producto(String producto, String categoria, int existence)
    {
        this.nombre = producto;
        this.cateogria = categoria;
        this.existence = existence;
    }

    
    /** 
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    
    /** 
     * @param producto
     */
    public void setNombre(String producto) {
        this.nombre = producto;
    }

    
    /** 
     * @return String
     */
    public String getCateogria() {
        return this.cateogria;
    }

    
    /** 
     * @param cateogria
     */
    public void setCateogria(String cateogria) {
        this.cateogria = cateogria;
    }

    
    /** 
     * @return int
     */
    public int getExistence() {
        return this.existence;
    }

    
    /** 
     * @param existence
     */
    public void setExistence(int existence) {
        this.existence = existence;
    }

    @Override
    public String toString() {
        return "{" +
            " producto='" + getNombre() + "'" +
            ", cateogria='" + getCateogria() + "'" +
            ", existence='" + getExistence() + "'" +
            "}";
    }
    
    
}
