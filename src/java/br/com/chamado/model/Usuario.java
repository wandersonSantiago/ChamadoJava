package br.com.chamado.model;
// Generated 04/12/2015 13:53:59 by Hibernate Tools 4.3.1

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

/**
 * Usuario generated by hbm2java
 */
@ManagedBean(name = "usuario")
@SessionScoped
@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "unidade")
    private Unidade unidade;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
    @Column(name = "usuario", unique = true, nullable = false, length = 30)
    private String usuario;
    @Column(name = "senha", nullable = false, length = 256)
    private String senha;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "tipousuario", nullable = false)
    private int tipousuario;
    @ManyToOne
    @JoinColumn(name = "setor")
    private Setor setor;
    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    public Usuario() {
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

    public int getTipousuario() {
	return this.tipousuario;
    }

    public void setTipousuario(int tipousuario) {
	this.tipousuario = tipousuario;
    }

    public Setor getSetor() {
	return setor;
    }

    public void setSetor(Setor setor) {
	this.setor = setor;
    }

    public Grupo getGrupo() {
	return grupo;
    }

    public void setGrupo(Grupo grupo) {
	this.grupo = grupo;
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
