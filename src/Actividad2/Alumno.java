
package Actividad2;


public class Alumno {
    private String nombre;
    private int dni;
    private String carrera;
    
    public  Alumno (String nombre, int dni, String carrera){
        this.nombre = nombre;
        this.dni = dni;
        this.carrera = carrera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getCarrera() {
        return carrera;
    }   
}
