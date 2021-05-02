package Actividad3;

import java.util.ArrayList;
import java.util.Collections;

public class Cronometro {

    private float tiempoInicio;
    private float tiempoFinal;

public void empezar(ArrayList arregloDeNumeros) {
        this.tiempoInicio = System.nanoTime();
        Collections.sort(arregloDeNumeros);
        this.tiempoFinal = System.nanoTime();
    }

    public void reset() {
        this.tiempoInicio = 0;
        this.tiempoFinal = 0;
    }

    public float finalizar() {
        return this.tiempoFinal - this.tiempoInicio;
    }
}
