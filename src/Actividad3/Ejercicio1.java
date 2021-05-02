package Actividad3;

import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio1 {

    public static void main(String[] args) {

        ArrayList<Double> arregloDeNumeros = new ArrayList<Double>(); //porque no toma el Math.random con enteros

        for (int i = 0; i < 1000; i++) {
            arregloDeNumeros.add(Math.random());
        }
//System.out.println("El numero mayor es: " + arregloDeNumeros.max());  -> si es por herencia xq tenemos que importar el Collections

        double max = Collections.max(arregloDeNumeros);
        double min = Collections.min(arregloDeNumeros);

        System.out.println("El numero mayor es: " + max + " que esta en la posicion: " + arregloDeNumeros.indexOf(max));
        System.out.println("El numero menor es: " + min + " que esta en la posicion: " + arregloDeNumeros.indexOf(min));
    }

}
