package model;
// Generated 08/04/2015 07:36:29 by Hibernate Tools 3.6.0


import dao.AlunoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Aluno generated by hbm2java
 */
@Entity
@Table(name="aluno"
    ,catalog="scp"
)
public class Aluno  implements java.io.Serializable {


     private int numeroRegistroAluno;
     private Usuario usuario;
     private Curso curso;
     private String nomeBanco;
     private String agencia;
     private String numeroConta;
     private String dadosResponsavel;
     

    public Aluno() {
    }

	
    public Aluno(int numeroRegistroAluno,String nomeBanco, String agencia, String numeroConta, String dadosResponsavel,Curso curso,Usuario usuario) {

        this.numeroRegistroAluno=numeroRegistroAluno;
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.dadosResponsavel = dadosResponsavel;
        this.curso=curso;
        this.usuario=usuario;
        
    }
   
     @Id 

    
    @Column(name="numeroRegistroAluno", unique=true, nullable=false)
    public int getNumeroRegistroAluno() {
        return this.numeroRegistroAluno;
    }
    
    public void setNumeroRegistroAluno(int numeroRegistroAluno) {
        this.numeroRegistroAluno = numeroRegistroAluno;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Usuario_cpf", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Curso_codCurso", nullable=false)
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    @Column(name="nomeBanco", length=45)
    public String getNomeBanco() {
        return this.nomeBanco;
    }
    
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    
    @Column(name="agencia", length=45)
    public String getAgencia() {
        return this.agencia;
    }
    
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    
    @Column(name="numeroConta", length=45)
    public String getNumeroConta() {
        return this.numeroConta;
    }
    
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    
    @Column(name="dadosResponsavel", length=45)
    public String getDadosResponsavel() {
        return this.dadosResponsavel;
    }
    
    public void setDadosResponsavel(String dadosResponsavel) {
        this.dadosResponsavel = dadosResponsavel;
    }


     public static List<Aluno> obterAlunos () throws ClassNotFoundException, SQLException {
            return AlunoDAO.obterAlunos();
    }
    
     

    public static Aluno obterAluno (int id) throws ClassNotFoundException, SQLException{
        return AlunoDAO.obterAluno(id);
        
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        AlunoDAO.gravar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        AlunoDAO.alterar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException{
        AlunoDAO.excluir(this);
    }


}


