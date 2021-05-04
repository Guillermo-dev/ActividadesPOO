package Actividad6;

public class Titulares extends Docentes {

    private final int antiguedad;

    public Titulares(int antiguedad, int legajo, String nombre, int edad, float salario) {
        super(legajo, nombre, edad, salario);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void mostrarAtributos() {
        System.out.println("Antiguedad: " + getAntiguedad());
    }

    public boolean requierePlus() {
        return (getEdad() > 30) && (this.antiguedad > 6);
    }
}
