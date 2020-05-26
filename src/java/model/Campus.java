package model;
// Generated 08/04/2015 07:36:29 by Hibernate Tools 3.6.0


import dao.CampusDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Campus generated by hbm2java
 */
@Entity
@Table(name="campus"
    ,catalog="scp"
)
public class Campus  implements java.io.Serializable {


     private int numeroRegistroCampus;
     private String nomeCampus;

    public Campus(int numeroRegistroCampus, String nomeCampus) {
        this.numeroRegistroCampus = numeroRegistroCampus;
        this.nomeCampus = nomeCampus;
    }
     
     

    public Campus() {
    }


   
     @Id 

    
    @Column(name="numeroRegistroCampus", unique=true, nullable=false)
    public int getNumeroRegistroCampus() {
        return this.numeroRegistroCampus;
    }
    
    public void setNumeroRegistroCampus(int numeroRegistroCampus) {
        this.numeroRegistroCampus = numeroRegistroCampus;
    }

    
    @Column(name="nomeCampus", length=45)
    public String getNomeCampus() {
        return this.nomeCampus;
    }
    
    public void setNomeCampus(String nomeCampus) {
        this.nomeCampus = nomeCampus;
    }


    public static List<Campus> obterCampi () throws ClassNotFoundException, SQLException {
            return CampusDAO.obterCampi();
    }
    
     

    public static Campus obterCampus (int id) throws ClassNotFoundException, SQLException{
        return CampusDAO.obterCampus(id);
        
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        CampusDAO.gravar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        CampusDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException{
        CampusDAO.excluir(this);
    }




}


