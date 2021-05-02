package Actividad6;

import java.util.ArrayList;
import java.util.Scanner;

/*Desarrollar una un programa que permita gestionar los docentes de un distrito.
Los docentes se caracterizan por tener: legajo, nombre, edad y salario. También, tendrán
una constante llamada “PLUS_RURALIDAD”, que tendrá un valor de $15.000.
Existen dos tipos de docentes: titulares y suplentes. El titular, además de los atributos
anteriores, tiene uno más llamado “antigüedad”. El suplente, por su parte, tiene otro
atributo llamado “zona”.
Las clases tendrán un método llamado “plus”, que según el tipo de docente tendrá una
implementación distinta. Este “plus” básicamente, aumenta el salario del docente.
En titular, si tiene más de 30 años y tiene una antigüedad de más de 6 años, se le aplicará
el PLUS_SALARIAL.
En suplente, si tiene menos de 25 y dicta clases en “Zona A”, recibirá el PLUS_SALARIAL.
Crear una clase ejecutable o principal, donde puedan crear distintos docentes y aplicar el
“plus” para comprobar que todo funciona adecuadamente. Importante: los docentes se
crean con datos ingresados por teclado.
 */
public class Actividad6 {

    static Scanner in = new Scanner(System.in);

    public static void cargarDocentes(ArrayList<Docentes> docentes) {
        int opcion;
        char respuesta;
        do {
            do {
                System.out.println("Cargar un Docente \n 1- Titular \n 2- Suplente");
                opcion = in.nextInt();
            } while (opcion < 1 || opcion > 2);

            cargarDatosDocente(docentes, opcion);

            System.out.println("Desea agregar otro docente? S/N");
            respuesta = in.next().charAt(0);
        } while (respuesta == 'S' || respuesta == 's');
    }

    public static void cargarDatosDocente(ArrayList<Docentes> docentes, int opcion) {
        System.out.println("Ingrese el nombre");
        String nombre = in.next();
        System.out.println("Ingrese la edad");
        int edad = in.nextInt();
        System.out.println("Ingrese el numero de legajo");
        int legajo = in.nextInt();
        System.out.println("Ingrese su salario");
        float salario = in.nextFloat();

        switch (opcion) {
            case 1:
                cargarTitular(docentes, nombre, edad, legajo, salario);
                break;
            case 2:
                cargarSuplente(docentes, nombre, edad, legajo, salario);
                break;
        }
    }

    public static void cargarTitular(ArrayList<Docentes> docentes, String nombre, int edad, int legajo, float salario) {
        int antiguedad;

        System.out.println("Ingrese la antiguedad:");
        antiguedad = in.nextInt();

        Titulares titular = new Titulares(antiguedad, legajo, nombre, edad, salario);
        docentes.add(titular);
    }

    public static void cargarSuplente(ArrayList<Docentes> docentes, String nombre, int edad, int legajo, float salario) {
        char zona;

        System.out.println("Ingrese zona A o B:");
        zona = in.next().charAt(0);

        Suplentes suplentes = new Suplentes(zona, legajo, nombre, edad, salario);
        docentes.add(suplentes);
    }

    public static void mostrarInformacion(ArrayList<Docentes> docentes) {
        for (Docentes docen : docentes) {
            System.out.println("\nDatos del Docentes"
                    + "\nLegajo: " + docen.getLegajo()
                    + "\nNombre: " + docen.getNombre()
                    + "\nEdad: " + docen.getEdad()
                    + "\nSalario: " + docen.getSalario()
            ); 
            // System.out.println(docen.getClass().getSimpleName());
            docen.plus();
        }
    }

    public static void main(String[] args) {
        ArrayList<Docentes> docentes = new ArrayList<Docentes>();
        cargarDocentes(docentes);
        mostrarInformacion(docentes);
    }
}
