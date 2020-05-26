
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Areaconhecimento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class AreaConhecimentoDAO{
    
 public static List<Areaconhecimento> obterAreasConhecimento() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Areaconhecimento> cadastros = session.createCriteria(Areaconhecimento.class).list();

        return cadastros;
    


        }

    public static Areaconhecimento obterAreaConhecimento(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Areaconhecimento areaConhecimento = (Areaconhecimento) session.load(Areaconhecimento.class, id);

        return areaConhecimento;

    }
    
      


    

        public static void gravar(Areaconhecimento areaConhecimento) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(areaConhecimento);
        transaction.commit();
    
    }

    public static void alterar(Areaconhecimento areaConhecimento) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(areaConhecimento);
        transaction.commit();
        
    
    }

    public static void excluir(Areaconhecimento areaConhecimento) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(areaConhecimento);
        transaction.commit();
        
    
    }

}
