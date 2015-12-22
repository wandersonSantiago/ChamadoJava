package br.com.chamado.model;
// Generated 09/12/2015 11:21:41 by Hibernate Tools 4.3.1

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Grupopagina generated by hbm2java
 */
@ManagedBean(name = "grupopagina")
@SessionScoped
@Entity
@Table(name = "grupopagina")
public class GrupoPagina implements java.io.Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codgrupo", nullable = false)
    private Grupo grupo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codpaigna", nullable = false)
    private Pagina pagina;

    public GrupoPagina() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Grupo getGrupo() {
	return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
	this.grupo = grupo;
    }

    public Pagina getPagina() {
	return this.pagina;
    }

    public void setPagina(Pagina pagina) {
	this.pagina = pagina;
    }

}
