
package Actividad2;

public final class Gato extends Animal {
    private final int edad;

    public Gato(String nombre, String raza, String color, int edad) {
        super(nombre, raza, color);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }  
}
