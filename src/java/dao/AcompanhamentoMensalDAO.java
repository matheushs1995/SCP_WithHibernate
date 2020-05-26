package dao;

import java.sql.SQLException;
import java.util.List;
import model.Acompanhamentomensal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class AcompanhamentoMensalDAO{

   public static List<Acompanhamentomensal> obterAcompanhamentosMensais() throws SQLException, ClassNotFoundException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Acompanhamentomensal> acompanhamentoMensal = session.createCriteria(Acompanhamentomensal.class).list();
        return acompanhamentoMensal;
    }

    public static Acompanhamentomensal obterAcompanhamentoMensal(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Acompanhamentomensal acompanhamentoMensal = (Acompanhamentomensal) session.load(Acompanhamentomensal.class, id);

        return acompanhamentoMensal;

    }
    
        

        public static void gravar(Acompanhamentomensal acompanhamentoMensal) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(acompanhamentoMensal);
        transaction.commit();
    
    }

    public static void alterar(Acompanhamentomensal acompanhamentoMensal) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(acompanhamentoMensal);
        transaction.commit();
        
    
    }

    public static void excluir(Acompanhamentomensal acompanhamentoMensal) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(acompanhamentoMensal);
        transaction.commit();
        
    
    }

}
