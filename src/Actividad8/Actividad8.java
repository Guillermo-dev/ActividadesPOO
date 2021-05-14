package Actividad8;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Actividad8 {

    static Scanner in = new Scanner(System.in);

    public static void menu() {
        int opcion;
        do {
            System.out.println("Ingrese La opcion que desea \n1-Cargar Alumno \n2-Cargar Curso \n3-Asignar curso a alumno \n4-salir");
            opcion = in.nextInt();
        } while (opcion < 1 || opcion > 4);
        
        switch (opcion) {
            case 1:
                cargarAlumno();
                break;
            case 2:
                cargarCurso();
                break;
            case 3:
                asignarCurso();
                break;
            default:
                break;
        }
    }

    public static void cargarAlumno() {
        System.out.println("CARGAR ALUMNO\nCargar nombre:");
        in.nextLine();
        String nombre = in.nextLine();
        System.out.println("Cargar apellido:");
        String apellido = in.nextLine();
        System.out.println("Cargar DNI:");
        int dni = in.nextInt();
        Alumno alumno = new Alumno(nombre, apellido, dni);
        
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Filada puta carga un dni distinto");
            System.out.println("コードを繰り返さないでください、愚かです");
            cargarAlumno();
        } finally {
            sessionFactory.close();
        }
    }

    public static void cargarCurso() {
        System.out.println("CARGAR CURSO\nCargar nombre:");
        in.nextLine();
        String nombre = in.nextLine();
        System.out.println("Cargar codigo;");
        int codigo = in.nextInt();
        Curso curso = new Curso(nombre, codigo);
        
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(curso);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Filada puta carga un codigo distinto");
            System.out.println("コードを繰り返さないでください、愚かです");
            cargarCurso();
        } finally {
            sessionFactory.close();
        }
    }
    
    public static void asignarCurso(){
        
    }

    public static void main(String[] args) {
        char opcion;
        do {
            menu();
            System.out.println("Desea hacer otra operacion? (S/N)");
            opcion=in.next().charAt(0);
        } while (opcion == 's' || opcion =='S');
    }
}
