package dao;

import model.Projeto;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;


public class ProjetoDAO {

     public static List<Projeto> obterProjetos() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Projeto> projetos = session.createCriteria(Projeto.class).list();

        return projetos;
    


        }

    public static Projeto obterProjeto(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Projeto projeto = (Projeto) session.load(Projeto.class, id);

        return projeto;

    }
    
      


    

        public static void gravar(Projeto projeto) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(projeto);
        transaction.commit();
    
    }

    public static void alterar(Projeto projeto) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(projeto);
        transaction.commit();
        
    
    }

    public static void excluir(Projeto projeto) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(projeto);
        transaction.commit();
        
    
    }

}
