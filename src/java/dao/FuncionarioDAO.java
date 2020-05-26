package dao;

import model.Funcionario;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class FuncionarioDAO{
 
    
    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Funcionario> funcionarios = session.createCriteria(Funcionario.class).list();

        return funcionarios;
    


        }

    public static Funcionario obterFuncionario(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Funcionario funcionario = (Funcionario) session.load(Funcionario.class, id);

        return funcionario;

    }
    
      


    

        public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(funcionario);
        transaction.commit();
    
    }

    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(funcionario);
        transaction.commit();
        
    
    }

    public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(funcionario);
        transaction.commit();
        
    
    }
}
