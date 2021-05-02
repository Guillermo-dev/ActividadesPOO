
package Actividad2;


public final class Perro extends Animal {
    private final boolean tieneDueño;

    public Perro(String nombre, String raza, String color, boolean tieneDueño) {
        super(nombre, raza, color);
        this.tieneDueño = tieneDueño;
    }

    public boolean isTieneDueño() {
        return tieneDueño;
    }
 
}
