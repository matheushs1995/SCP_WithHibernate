package dao;

import model.Curso;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class CursoDAO{

    public static List<Curso> obterCursos() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Curso> cursos = session.createCriteria(Curso.class).list();

        return cursos;
    


        }

    public static Curso obterCurso(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Curso curso = (Curso) session.load(Curso.class, id);

        return curso;

    }
    
      


    

        public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(curso);
        transaction.commit();
    
    }

    public static void alterar(Curso curso) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(curso);
        transaction.commit();
        
    
    }

    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(curso);
        transaction.commit();
        
    
    }

}
