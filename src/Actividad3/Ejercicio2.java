
/*Ejercicio 2- Crear una clase “Cronometro” que tenga los métodos empezar(), finalizar() y reset().
Luego, crear un array de 100 números aleatorios y calcular cuánto demora la
función sort() en ordenarlo. Probar con 1.000, 10.000 y 100.000 elementos.*/
package Actividad3;

import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {

        ArrayList<Double> arregloDeNumeros = new ArrayList<Double>();
        Cronometro cronometro = new Cronometro();

        for (int i = 0; i < 100; i++) {
            arregloDeNumeros.add(Math.random());
        }
       
        cronometro.empezar(arregloDeNumeros);
        System.out.println("Tiempo de 100: " + cronometro.finalizar());        
        cronometro.reset();
        
        arregloDeNumeros.clear();
   
        for (int i = 0; i < 1000; i++) {
            arregloDeNumeros.add(Math.random());
        }

        cronometro.empezar(arregloDeNumeros);
        System.out.println("\nTiempo de 1000: " + cronometro.finalizar());        
        cronometro.reset();
        
        arregloDeNumeros.clear();
        
        for (int i = 0; i < 10000; i++) {
            arregloDeNumeros.add(Math.random());
        }

        cronometro.empezar(arregloDeNumeros);
        System.out.println("\nTiempo de 10000: " + cronometro.finalizar());        
        cronometro.reset();
        
        arregloDeNumeros.clear();
        
        for (int i = 0; i < 100000; i++) {
            arregloDeNumeros.add(Math.random());
        }

        cronometro.empezar(arregloDeNumeros);
        System.out.println("\nTiempo de 100000: " + cronometro.finalizar());        
        cronometro.reset();        
    }
}
