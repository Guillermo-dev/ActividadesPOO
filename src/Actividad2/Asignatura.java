
package Actividad2;


public class Asignatura {
    
    private final String nombre;
    private final int año;
    private final String carrera;
    private String docente;
    
    public  Asignatura (String nombre, int año, String carrera, String docente){
        this.año = año;
        this.carrera = carrera;
        this.docente = docente;
        this.nombre = nombre;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getDocente() {
        return docente;
    }
}
