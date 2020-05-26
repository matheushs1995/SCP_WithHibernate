package dao;

import model.Campus;
import java.sql.SQLException;
import java.util.List;
import model.Campus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class CampusDAO{

     public static List<Campus> obterCampi() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Campus> campi = session.createCriteria(Campus.class).list();

        return campi;
    


        }

    public static Campus obterCampus(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Campus campus = (Campus) session.load(Campus.class, id);

        return campus;

    }
    
      


    

        public static void gravar(Campus campus) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(campus);
        transaction.commit();
    
    }

    public static void alterar(Campus campus) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(campus);
        transaction.commit();
        
    
    }

    public static void excluir(Campus campus) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(campus);
        transaction.commit();
        
    
    }

}
