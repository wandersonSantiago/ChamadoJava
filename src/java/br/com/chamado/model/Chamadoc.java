package br.com.chamado.model;

// Generated 04/12/2015 13:53:59 by Hibernate Tools 4.3.1
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean(name = "chamadoc")
@SessionScoped
@Entity
@Table(name = "chamadoc")
public class Chamadoc implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "unidade", nullable = false)
    private Unidade unidade;
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false, length = 13)
    private Date data;
    @Column(name = "status",nullable = false)
    private int status;
    @Column(name = "prioridade", nullable = false)
    private int prioridade;
    @Column(name = "categoria", nullable = false)
    private int categoria;
    @ManyToOne
    @JoinColumn(name = "codfuncsolic", nullable = false)
    private Usuario codfuncsolic;
    @Column(name = "codfuncatend")
    private Integer codfuncatend;
    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataprevisao", length = 13)
    private Date dataprevisao;
    @Temporal(TemporalType.DATE)
    @Column(name = "datafechamento", length = 13)
    private Date datafechamento;
   
    public Chamadoc()
    {
       status = 1;
       
    }
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }
    
    public Unidade getUnidade() {
	return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
	this.unidade = unidade;
    }
    
    public Date getData() {
	return this.data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    public int getStatus() {
	return this.status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public int getPrioridade() {
	return this.prioridade;
    }

    public void setPrioridade(int prioridade) {
	this.prioridade = prioridade;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

   
    public Usuario getCodfuncsolic() {
	return codfuncsolic;
    }

    public void setCodfuncsolic(Usuario codfuncsolic) {   
        this.codfuncsolic = codfuncsolic;
    }

    public Integer getCodfuncatend() {
        return this.codfuncatend;
    }

    public void setCodfuncatend(Integer codfuncatend) {
	this.codfuncatend = codfuncatend;
    }

    public String getTitulo() {
	return this.titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public Date getDataprevisao() {
	return this.dataprevisao;
    }

    public void setDataprevisao(Date dataprevisao) {
	this.dataprevisao = dataprevisao;
    }

    public Date getDatafechamento() {
	return this.datafechamento;
    }

    public void setDatafechamento(Date datafechamento) {
	this.datafechamento = datafechamento;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 59 * hash + this.id;
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
	final Chamadoc other = (Chamadoc) obj;
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }
   
    
   
}
