package dao;

import model.Edital;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class EditalDAO{
 public static List<Edital> obterEditais() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Edital> editais = session.createCriteria(Edital.class).list();

        return editais;
    


        }

    public static Edital obterEdital(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Edital edital = (Edital) session.load(Edital.class, id);

        return edital;

    }
    
      


    

        public static void gravar(Edital edital) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(edital);
        transaction.commit();
    
    }

    public static void alterar(Edital edital) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(edital);
        transaction.commit();
        
    
    }

    public static void excluir(Edital edital) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(edital);
        transaction.commit();
        
    
    }
}
