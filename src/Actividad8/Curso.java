package Actividad8;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int idCurso;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_curso")
    private int codigo;

    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos;

    public Curso() {
    }

    public Curso(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public void addAlumnos(Alumno alumno) {
        if (this.alumnos == null) {
            this.alumnos = new ArrayList<>();
        }
        this.alumnos.add(alumno);
    }

}
