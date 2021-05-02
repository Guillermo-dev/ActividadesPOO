
package Actividad3;

public class Interface3 {
     public static void main(String[] args) {
        Gato objGato = new Gato();
        System.out.println("Gato:");
        objGato.habla();
        
        Perro objPerro = new Perro();
        System.out.println("Perro:");
        objPerro.habla();
        
        RelojCucu objReloj = new RelojCucu();
        System.out.println("Reloj Cucu:");
        objReloj.habla();
    }
}
