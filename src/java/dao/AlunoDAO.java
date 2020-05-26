package dao;

import model.Aluno;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class AlunoDAO  {

     public static List<Aluno> obterAlunos() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Aluno> alunos = session.createCriteria(Aluno.class).list();

        return alunos;
    


        }

    public static Aluno obterAluno(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Aluno aluno = (Aluno) session.load(Aluno.class, id); 

        return aluno;

    }
    
      


    

        public static void gravar(Aluno aluno) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(aluno);
        transaction.commit();
    
    }

    public static void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(aluno);
        transaction.commit();
        
    
    }

    public static void excluir(Aluno aluno) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(aluno);
        transaction.commit();
        
    
    }

}
