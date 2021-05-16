package Actividad8;

import java.util.List;
import java.util.Scanner;
import org.hibernate.exception.ConstraintViolationException;

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

        try {
            HibernateUtils.saveAlumno(alumno);
            System.out.println("Se creo correctamente el alumno");
        } catch (Exception ex) {
            System.out.println("Error al crear el alumno, intentolo nuevamente");
            cargarAlumno();
        }
    }

    public static void cargarCurso() {
        System.out.println("CARGAR CURSO\nCargar nombre:");
        in.nextLine();
        String nombre = in.nextLine();
        System.out.println("Cargar codigo;");
        int codigo = in.nextInt();
        Curso curso = new Curso(nombre, codigo);

        try {
            HibernateUtils.saveCurso(curso);
            System.out.println("Se creo correctamente el curso");
        } catch (Exception ex) {
            System.out.println("Error al crear el curso, intentolo nuevamente");
            cargarCurso();
        }
    }

    public static void asignarCurso() {
        Alumno alumno;
        System.out.println("Ingrese su dni para inscribirse a un curso:");
        int dni = in.nextInt();

        try {
            alumno = HibernateUtils.getAlumno(dni);
            HibernateUtils.showCursos(alumno.getId());
            try {
                List<Curso> cursos = HibernateUtils.getAllCursos();
                System.out.println("Ingrese el curso al que se quiere inscribir: ");
                int i = 1;
                for (Curso curso : cursos) {
                    System.out.println(i + ") " + curso.getNombre());
                    i++;
                }
                int cursoElegido = in.nextInt();

                try {
                    HibernateUtils.updateAlumno(alumno.getId(), cursos.get(cursoElegido - 1));
                    System.out.println("Se inscribio correctamente al curso: " + cursos.get(cursoElegido - 1).getNombre());
                } catch (ConstraintViolationException ex) {
                    System.out.println("Usted ya se encuentra subscripto a este curso");
                }
            } catch (Exception ex) {
                System.out.println("Error inesperado, intentelo mas tarde");
            }
        } catch (Exception ex) {
            System.out.println("Error al encontrar el alumno, intentelo nuevamente");
            asignarCurso();
        }

    }

    public static void main(String[] args) {
        char opcion;
        do {
            menu();
            System.out.println("Desea hacer otra operacion? (S/N)");
            opcion = in.next().charAt(0);
        } while (opcion == 's' || opcion == 'S');
    }
}
