
package dao;

import model.Departamento;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class DepartamentoDAO{

     public static List<Departamento> obterDepartamentos() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Departamento> departamentos = session.createCriteria(Departamento.class).list();

        return departamentos;
    


        }

    public static Departamento obterDepartamento(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Departamento departamento = (Departamento) session.load(Departamento.class, id);

        return departamento;

    }
    
      


    

        public static void gravar(Departamento departamento) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(departamento);
        transaction.commit();
    
    }

    public static void alterar(Departamento departamento) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(departamento);
        transaction.commit();
        
    
    }

    public static void excluir(Departamento departamento) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(departamento);
        transaction.commit();
        
    
    }

}
