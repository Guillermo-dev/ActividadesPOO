package Actividad6;

public class Suplentes extends Docentes {

    private final char zona;

    public Suplentes(char zona, int legajo, String nombre, int edad, float salario) {
        super(legajo, nombre, edad, salario);
        this.zona = zona;
    }

    public char getZona() {
        return zona;
    }

    public boolean requierePlus() {
        return (getEdad() < 25) && (zona == 'A' || zona == 'a');
    }
}
