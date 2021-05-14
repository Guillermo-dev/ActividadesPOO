package Actividad7;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Actividad7 {

    static Scanner in = new Scanner(System.in);

    public static void cargarDocentes() {
        int opcion;
        char respuesta;

        System.out.println("Desea agregar un docente? S/N");
        respuesta = in.next().charAt(0);
        while (respuesta == 'S' || respuesta == 's') {
            do {
                System.out.println("Cargar un Docente \n 1- Titular \n 2- Suplente");
                opcion = in.nextInt();
            } while (opcion < 1 || opcion > 2);

            cargarDatosDocente(opcion);

            System.out.println("Desea agregar otro docente? S/N");
            respuesta = in.next().charAt(0);
        }
    }

    public static void cargarDatosDocente(int opcion) {
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
                cargarTitular(nombre, edad, legajo, salario);
                break;
            case 2:
                cargarSuplente(nombre, edad, legajo, salario);
                break;
        }
    }

    public static void cargarTitular(String nombre, int edad, int legajo, float salario) {
        System.out.println("Ingrese la antiguedad:");
        int antiguedad = in.nextInt();

        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Titulares titular = new Titulares(antiguedad, legajo, nombre, edad, salario);
            session.beginTransaction();
            session.save(titular);
            session.getTransaction().commit();
            session.close();
        } finally {
            sessionFactory.close();
        }
    }

    public static void cargarSuplente(String nombre, int edad, int legajo, float salario) {
        in.nextLine();
        String zona;
        do {
            System.out.println("Ingrese zona A o B:");
            zona = in.nextLine().substring(0, 1);
        } while (!zona.equals("a") && !zona.equals("A") && !zona.equals("b") && !zona.equals("B"));


        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();
        
        try {
            Suplentes suplente = new Suplentes(zona, legajo, nombre, edad, salario);
            session.beginTransaction();
            session.save(suplente);
            session.getTransaction().commit();
            session.close();
        } finally {
            sessionFactory.close();
        }
    }

    public static void mostrarInformacion() {
        SessionFactory sessionFactory= HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query queryT = session.createQuery("from Titulares");
            Query queryS = session.createQuery("from Suplentes");
            List<Titulares> titulares = (List<Titulares>) queryT.list();
            List<Suplentes> suplentes = (List<Suplentes>) queryS.list();
            session.close();

            System.out.println("\n------------TITULARES------------");
            for (Titulares docen : titulares) {
                if (docen.getAntiguedad() != null) {
                    System.out.println("\nDatos del Docentes"
                            + "\nLegajo: " + docen.getLegajo()
                            + "\nNombre: " + docen.getNombre()
                            + "\nEdad: " + docen.getEdad()
                            + "\nSalario: " + docen.getSalario()
                            + "\nAntiguedad " + docen.getAntiguedad()
                    );
                    docen.plus();
                }
            }
            System.out.println("\n------------SUPLENTES------------");
            for (Suplentes docen : suplentes) {
                if (docen.getZona() != null) {
                    System.out.println("\nDatos del Docentes"
                            + "\nLegajo: " + docen.getLegajo()
                            + "\nNombre: " + docen.getNombre()
                            + "\nEdad: " + docen.getEdad()
                            + "\nSalario: " + docen.getSalario()
                            + "\nAntiguedad " + docen.getZona()
                    );
                    docen.plus();
                }
            }

        } finally {
            sessionFactory.close();
        }
    }

    public static void main(String[] args) {
        cargarDocentes();
        mostrarInformacion();
    }
}
