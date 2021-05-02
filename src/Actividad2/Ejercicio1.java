
package Actividad2;

public class Ejercicio1 {

    public static void main(String[] args) {
       
        Alumno alumno = new Alumno ("Paola", 35999709, "Analista en Informatica");
        Docente docente = new Docente ("Gustavo", 36578, "POO");
        Asignatura asignatura = new Asignatura("POO", 3, "Analista en Informatica", "Gustavo");
        
        
        System.out.println("Datos Alumno \nNombre: " + alumno.getNombre() + "\nDni: " + alumno.getDni() + "\nCarrera: " + alumno.getCarrera());
        System.out.println("\nDatos Docente \nNombre: " + docente.getNombre() + "\nMatricula: " + docente.getMatricula() + "\nMateria: " + docente.getMateria());
        System.out.println("\nDatos Asignatura \nNombre: " + asignatura.getNombre() + "\nAño: " + asignatura.getAño() + "\nCarrera: " + asignatura.getCarrera() +  "\nDocente: " + asignatura.getDocente() ) ;
        
        asignatura.setDocente("Juan");
        System.out.println("\nNuevoDocente: \nNombre: " + asignatura.getDocente());
    }
            
}

