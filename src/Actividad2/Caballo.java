
package Actividad2;

public final class Caballo extends Animal {
    private final boolean esCorredor;
    
    public Caballo(String nombre, String raza, String color, boolean esCorredor) {
        super(nombre, raza, color);
        this.esCorredor = esCorredor;
    }

    public boolean isEsCorredor() {
        return esCorredor;
    }
       
}
