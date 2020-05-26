package dao;


import model.Usuario;
import java.sql.SQLException;
import java.util.List;
import model.Planoindividual;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

public class UsuarioDAO  {

    
        public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        List<Usuario> usuarios = session.createCriteria(Usuario.class).list();

        return usuarios;
    


        }

    public static Usuario obterUsuario(int id) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Usuario usuario = (Usuario) session.load(Usuario.class, id);

        return usuario;

    }
    public static Usuario obterUsuarioLogin(String login) throws SQLException, ClassNotFoundException {

        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        Usuario usuario = (Usuario) session.createCriteria(Usuario.class,"from usuario where Login="+login);

        return usuario;

    }
    
      


    

        public static void gravar(Usuario usuario) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(usuario);
        transaction.commit();
    
    }

    public static void alterar(Usuario usuario) throws SQLException, ClassNotFoundException {
        
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(usuario);
        transaction.commit();
        
    
    }

    public static void excluir(Usuario usuario) throws SQLException, ClassNotFoundException {
    
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(usuario);
        transaction.commit();
        
    
    }
}
