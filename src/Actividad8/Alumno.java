package Actividad8;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private int idAlumno;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private int dni;

    @ManyToMany
    @JoinTable(name = "alumnos_cursos",
            joinColumns = {
                @JoinColumn(name = "id_alumno")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_curso")})
    private List<Curso> cursos;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    } 

    public void addCursos(Curso curso) {
        if(this.cursos == null){
            this.cursos = new ArrayList<>();
        } 
        this.cursos.add(curso);
    }
    
}
