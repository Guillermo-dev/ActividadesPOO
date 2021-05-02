
package Actividad2;


public class Docente {
    private final String nombre;
    private final int matricula;
    private String materia;
    
    public Docente(String nombre, int matricula, String materia){
        this.nombre = nombre;
        this.matricula = matricula;
        this.materia = materia;        
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getMateria() {
        return materia;
    }
   
}
