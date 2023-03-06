import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
public class factoryMaps {
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
