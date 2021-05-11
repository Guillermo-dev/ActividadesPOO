package Actividad7;

import javax.persistence.*;

@Entity
@Table(name = "docente")
public class Titulares /*extends Docentes*/ {

    @Column(name = "antiguedad")
    private Integer antiguedad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private int idDocente;

    @Column(name = "legajo")
    private int legajo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "salario")
    private float salario;

    public Titulares() {
        this.antiguedad=0;
    }

    public Titulares(int antiguedad, int legajo, String nombre, int edad, float salario) {
        this.edad = edad;
        this.legajo = legajo;
        this.nombre = nombre;
        this.salario = salario;
        this.antiguedad = antiguedad;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void plus() {
        if (requierePlus()) {
            setSalario(getSalario() + 15000);
            System.out.println("Obtiene un plus, su nuevo salario es: $" + getSalario());
        } else {
            System.out.println("No cumple con los requisitos y no obtiene un plus, su salario es: $" + getSalario());
        }
    }

    public boolean requierePlus() {
        return (getEdad() > 30) && (this.antiguedad > 6);
    }
}
