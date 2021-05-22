package Actividad8;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    public static SessionFactory newSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernateAct8.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory SessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return SessionFactory;
    }

    public static void saveAlumno(Alumno alumno) {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(alumno);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    public static void saveCurso(Curso curso) {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(curso);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    public static Alumno getAlumno(int dni) {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("FROM Alumno WHERE dni = :dni");
        // Asi o trayenddo todos los alumnos y con logica buscar el de == dni adentro de la lista
        query.setParameter("dni", dni);
        List<Alumno> alumnos = (List<Alumno>) query.list();
        Alumno alumno = alumnos.get(0);

        session.close();
        sessionFactory.close();

        return alumno;
    }

    public static void showCursos(int idAlumno) {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        Alumno alumno = (Alumno) session.get(Alumno.class, idAlumno);
        if (!alumno.getCursos().isEmpty()) {
            System.out.println("Cursos inscriptos: ");
            alumno.getCursos().forEach((curso) -> {
                System.out.println(curso.getNombre());
            });
        } else {
            System.out.println("No se encuentra inscripto a ningun cursos");
        }

        session.close();
        sessionFactory.close();
    }

    public static List<Curso> getAllCursos() {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("FROM Curso");
        List<Curso> cursos = (List<Curso>) query.list();

        session.close();
        sessionFactory.close();
        return cursos;
    }

    // Actualizar la n:m
    public static void updateAlumno(int idAlumno, Curso curso) {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        Alumno alumno = (Alumno) session.get(Alumno.class, idAlumno);
        alumno.addCurso(curso);

        session.beginTransaction();
        session.update(alumno);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    // No es necesaria pero es otra forma de actualizar la n:m
    public static void updateCurso(int idCurso, Alumno alumno) {
        SessionFactory sessionFactory = HibernateUtils.newSessionFactory();
        Session session = sessionFactory.openSession();

        Curso curso = (Curso) session.get(Curso.class, idCurso);
        curso.addAlumno(alumno);

        session.beginTransaction();
        session.update(curso);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

}
