package dao;

import java.sql.SQLException;
import java.util.List;
import model.Planoindividual;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class PlanoIndividualDAO{

     public static List<Planoindividual> obterPlanosIndividuais() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Planoindividual> planosIndividuais = session.createCriteria(Planoindividual.class).list();

        return planosIndividuais;
    


        }

    public static Planoindividual obterPlanoIndividual(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Planoindividual planoIndividual = (Planoindividual) session.load(Planoindividual.class, id);

        return planoIndividual;

    }
    
      


    

        public static void gravar(Planoindividual planoIndividual) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(planoIndividual);
        transaction.commit();
    
    }

    public static void alterar(Planoindividual planoIndividual) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(planoIndividual);
        transaction.commit();
        
    
    }

    public static void excluir(Planoindividual planoIndividual) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(planoIndividual);
        transaction.commit();
        
    
    }
}
