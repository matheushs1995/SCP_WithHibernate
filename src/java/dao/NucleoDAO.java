package dao;

import model.Nucleo;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class NucleoDAO{

    public static List<Nucleo> obterNucleos() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Nucleo> nucleos = session.createCriteria(Nucleo.class).list();

        return nucleos;
    


        }

    public static Nucleo obterNucleo(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Nucleo nucleo = (Nucleo) session.load(Nucleo.class, id);

        return nucleo;

    }
    
      


    

        public static void gravar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(nucleo);
        transaction.commit();
    
    }

    public static void alterar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(nucleo);
        transaction.commit();
        
    
    }

    public static void excluir(Nucleo nucleo) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(nucleo);
        transaction.commit();
        
    
    }

}
