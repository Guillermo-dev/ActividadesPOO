
package Actividad3;

import java.util.Random;

public class Ejercicio3 {

    public static void main(String[] args) {

        EscanerSuper escaner = new EscanerSuper();
        // llenarlo a mano
        Random random = new Random();
        
        for (int i = 0; i < random.nextInt(9)+1; i++) {
            Producto producto = new Producto(random.nextInt(), Math.random()*100);
            escaner.cargarProducto(producto, random.nextInt(2)+1);

        }
        //imprimir listado de productos
        System.out.println("Su total es de: " + escaner.getTotal());
        System.out.println("Muchas gracias por su compra");
    }
}
