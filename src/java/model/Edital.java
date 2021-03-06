package model;
// Generated 08/04/2015 07:36:29 by Hibernate Tools 3.6.0


import dao.EditalDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Edital generated by hbm2java
 */
@Entity
@Table(name="edital"
    ,catalog="scp"
)
public class Edital  implements java.io.Serializable {


     private int numeroRegistroEdital;
     private Campus campus;
     private String dataInicio;
     private String dataTermino;
     private String vagas;
     private String nomeEdital;
     private String implementacao;
    

    public Edital() {
    }

	
    public Edital(int numeroRegistroEdital, String dataInicio, String dataTermino, String vagas, String nomeEdital, String implementacao, Campus campus) {
        this.numeroRegistroEdital = numeroRegistroEdital;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.vagas = vagas;
        this.nomeEdital = nomeEdital;
        this.implementacao = implementacao;
        this.campus = campus;
    }
   
     @Id 

    
    @Column(name="numeroRegistroEdital", unique=true, nullable=false)
    public int getNumeroRegistroEdital() {
        return this.numeroRegistroEdital;
    }
    
    public void setNumeroRegistroEdital(int numeroRegistroEdital) {
        this.numeroRegistroEdital = numeroRegistroEdital;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numeroRegistroCampus", nullable=false)
    public Campus getCampus() {
        return this.campus;
    }
    
    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    
    @Column(name="dataInicio", length=10)
    public String getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    
    @Column(name="dataTermino", length=45)
    public String getDataTermino() {
        return this.dataTermino;
    }
    
    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    
    @Column(name="vagas", length=45)
    public String getVagas() {
        return this.vagas;
    }
    
    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    
    @Column(name="nomeEdital", length=45)
    public String getNomeEdital() {
        return this.nomeEdital;
    }
    
    public void setNomeEdital(String nomeEdital) {
        this.nomeEdital = nomeEdital;
    }

    
    @Column(name="implementacao", length=1)
    public String getImplementacao() {
        return this.implementacao;
    }
    
    public void setImplementacao(String implementacao) {
        this.implementacao = implementacao;
    }

    public static List<Edital> obterEditais () throws ClassNotFoundException, SQLException {
            return EditalDAO.obterEditais();
    }
    
     

    public static Edital obterEdital (int id) throws ClassNotFoundException, SQLException{
        return EditalDAO.obterEdital(id);
        
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        EditalDAO.gravar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        EditalDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException{
        EditalDAO.excluir(this);
    }




}


