package Actividad3;

public class Interface2 {

    public static void main(String[] args) {

        Pasajero felipe = new Pasajero();
        felipe.setFecha_ultimo_viaje();
        System.out.println("Pasajero Felipe");
        System.out.println("Millas recorridas: " + felipe.millas());
        System.out.println("Fecha del ultimo viaje: " + felipe.ultimoViaje().toString() + "\n");

        Vehiculo auto = new Vehiculo();
        auto.setFecha_ultimo_viaje();
        System.out.println("Auto");
        System.out.println("Millas totales: " + auto.millas());
        System.out.println("Fecha del ultimo viaje: " + auto.ultimoViaje().toString());
    }

}
