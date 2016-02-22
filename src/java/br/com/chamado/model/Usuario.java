package br.com.chamado.model;

import br.com.chamado.util.CriptografarSenha;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *  @author WandersonSantiago 
 */
@ManagedBean(name = "usuario")
@SessionScoped
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "unidade")
    private Unidade unidade;
    @Column(name = "nome", unique = true, nullable = false,length = 50)
    private String nome;
    @Column(name = "usuario", unique = true, nullable = false, length = 50)
    private String usuario;
    @Column(name = "senha", nullable = false, length = 256)
    private String senha;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @ManyToOne
    @JoinColumn(name = "setor")
    private Setor setor;
    
    @Transient
    private final int SETOR_TI;
    @Transient
    private final int UNIDADE_CENTRAL;
    
    public Usuario() {
        this.SETOR_TI = 1;
        this.UNIDADE_CENTRAL = 1;
    }
    public Usuario(Unidade unidade,String nome,String usuario,String senha,String email,Setor setor)
    {
       this.SETOR_TI = 1;
       this.UNIDADE_CENTRAL = 1;
       this.unidade = unidade;
       this.nome = nome;
       this.usuario = usuario;
       this.senha = senha;
       this.email = email;
       this.setor = setor;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Unidade getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public void criptografar() {
        String tempSenha = CriptografarSenha.criptografar(senha);
        this.senha = tempSenha;

    }
    public boolean isTiCentral()
    {
       return (UNIDADE_CENTRAL == unidade.getId()  &&  SETOR_TI == setor.getId());
    }
    public boolean isTi()
    {
       return SETOR_TI == setor.getId();
       
    }
    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
