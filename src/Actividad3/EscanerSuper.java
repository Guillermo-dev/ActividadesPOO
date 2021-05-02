package Actividad3;

import java.util.ArrayList;

public class EscanerSuper {

    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public void cargarProducto(Producto producto, int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            productos.add(producto);
        }
    }

    public double getTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total = total + producto.getPrecio();
        }
        return total;
    }
}
