package dao;

import model.Professor;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class ProfessorDAO{

     public static List<Professor> obterProfessores() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
         List<Professor> professores = session.createCriteria(Professor.class).list();

        return professores;
    


        }

    public static Professor obterProfessor(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Professor professor = (Professor) session.load(Professor.class, id);

        return professor;

    }
    
      


    

        public static void gravar(Professor professor) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(professor);
        transaction.commit();
    
    }

    public static void alterar(Professor professor) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(professor);
        transaction.commit();
        
    
    }

    public static void excluir(Professor professor) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(professor);
        transaction.commit();
        
    
    }
}
