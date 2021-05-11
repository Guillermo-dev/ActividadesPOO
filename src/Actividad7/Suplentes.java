package Actividad7;

import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "docente")
public class Suplentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private int idDocente;

    @Column(name = "zona")
    private String zona;

    @Column(name = "legajo")
    private int legajo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "salario")
    private float salario;

    public Suplentes() {
    }

    
    
    public Suplentes(String zona, int legajo, String nombre, int edad, float salario) {
        this.edad = edad;
        this.legajo = legajo;
        this.nombre = nombre;
        this.salario = salario;
        this.zona = zona;
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

    public String getZona() {
        return zona;
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
        return (getEdad() < 25) && (zona.equals("A")|| zona.equals("a"));
    }
}
