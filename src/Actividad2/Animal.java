
package Actividad2;

public class Animal {
    private final String nombre;
    private final String raza;
    private final String color;
    
    public Animal(String nombre, String raza, String color){
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }
}
