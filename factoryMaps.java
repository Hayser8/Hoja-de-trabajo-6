/**
 * @author Julio García Salas
 * Tare: Hoja de trabajo 6
 * Archivo: factoryMaps.java
 * Fecha: 06/03/2023
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
public class factoryMaps {
    /**
     * Crea un nuevo mapa según el tipo especificado.
     * @param tipo el tipo de mapa a crear
     * @return un nuevo mapa del tipo especificado
     * @throws IllegalArgumentException si se proporciona un tipo no válido
     */
    public static Map<Integer, Producto> fabrica(int tipo)
    {
        switch(tipo)
        {
            case 1:
            {
                return new TreeMap<Integer, Producto>();
            }
            case 2:
            {
                return new HashMap<Integer,Producto>();
            }
            case 3:
            {
                return new LinkedHashMap<Integer, Producto>();
            }
            default:
            {
                throw new IllegalArgumentException("Selecciona una opción correcta");
            }
        }
    }
}
