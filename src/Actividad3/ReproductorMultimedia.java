
package Actividad3;

public class ReproductorMultimedia implements VideoClip {
    
    public void play() {
        System.out.println("Se reproduce la musica actual.");
    }

    
    public void bucle() {
        System.out.println ("Bucle activado.");
    }

    
    public void stop() {
        System.out.println("Se detiene la musica actual.");
    }
}
