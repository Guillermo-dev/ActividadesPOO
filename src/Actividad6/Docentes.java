package Actividad6;

public abstract class Docentes {

    private int legajo;
    private String nombre;
    private int edad;
    private float salario;
    private int PLUS = 15000;

    public Docentes(int legajo, String nombre, int edad, float salario) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalario() {
        return salario;
    }

    public int getPLUS() {
        return PLUS;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String mostrarDatos() {
        return "\nDatos del Docentes " + "\nLegajo: " + legajo + "\nNombre: " + nombre + "\nEdad: " + edad + "\nSalario: " + salario;
    }

    // Template Method
    public void plus() {
        if (requierePlus()) {
            setSalario(getSalario() + getPLUS());
            System.out.println("Obtiene un plus, su nuevo salario es: $" + getSalario());
        } else {
            System.out.println("No cumple con los requisitos y no obtiene un plus, su salario es: $" + getSalario());
        }
    }

    public abstract boolean requierePlus();

}
