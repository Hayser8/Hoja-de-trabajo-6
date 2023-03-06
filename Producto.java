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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String producto) {
        this.nombre = producto;
    }

    public String getCateogria() {
        return this.cateogria;
    }

    public void setCateogria(String cateogria) {
        this.cateogria = cateogria;
    }

    public int getExistence() {
        return this.existence;
    }

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
