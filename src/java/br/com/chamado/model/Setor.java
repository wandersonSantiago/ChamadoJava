package br.com.chamado.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Wanderson Santiago
 */
@ManagedBean(name = "setor")
@SessionScoped
@Entity
@Table(name = "setor")
public class Setor implements Serializable {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 30)
    @NotNull
    private String nome;
    @Column(nullable = false, length = 15)
    @NotNull
    private int ramal;

    public Setor() throws IllegalArgumentException {

    }
    public Setor(String nome,int ramal)
    {
      this.nome = nome;
      this.ramal = ramal;
    }
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getRamal() {
	return ramal;
    }

    public void setRamal(int ramal) throws IllegalArgumentException {

	if (ramal > 0) {
	    this.ramal = ramal;
	} else {
	    throw new IllegalArgumentException("O Campo Ramal não pode ser " + ramal);
	}

    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {

	if (nome.length() >= 2 && nome.length() <= 30) {
	    this.nome = nome;
	} else {
	    throw new IllegalArgumentException("Campo minimo 2 e maximo 30, TAMANHO[" + nome.length() + "]");
	}
    }

    @Override
    public String toString() {
	return this.nome;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 17 * hash + this.id;
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
	final Setor other = (Setor) obj;
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }

}
