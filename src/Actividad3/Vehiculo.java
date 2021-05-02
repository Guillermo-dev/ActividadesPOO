package Actividad3;

import java.util.Date;

public class Vehiculo implements Frecuencia {

    private Date fecha_ultimo_viaje;

    public void setFecha_ultimo_viaje() {
        this.fecha_ultimo_viaje = new Date();
    }

    public int millas() {
        return (60);
    }

    public Date ultimoViaje() {
        return (fecha_ultimo_viaje);
    }

}
