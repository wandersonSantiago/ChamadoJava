package br.com.chamado.model;

// Generated 04/12/2015 13:53:59 by Hibernate Tools 4.3.1
import br.com.chamado.model.Unidade;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean(name = "chamadoc")
@SessionScoped
@Entity
@Table(name = "chamadoc", schema = "public"
)
public class Chamadoc implements java.io.Serializable {

    private int numchamado;
    private Unidade unidade;
    private Date data;
    private int status;
    private int prioridade;
    private int codfuncsolic;
    private Integer codfuncatend;
    private String titulo;
    private Date dataprevisao;
    private Date datafechamento;
    private Set mensagems = new HashSet(0);

    public Chamadoc() {
    }

    public Chamadoc(int numchamado, Unidade unidade, Date data, int status, int prioridade, int codfuncsolic, String titulo) {
	this.numchamado = numchamado;
	this.unidade = unidade;
	this.data = data;
	this.status = status;
	this.prioridade = prioridade;
	this.codfuncsolic = codfuncsolic;
	this.titulo = titulo;
    }

    public Chamadoc(int numchamado, Unidade unidade, Date data, int status, int prioridade, int codfuncsolic, Integer codfuncatend, String titulo, Date dataprevisao, Date datafechamento, Set mensagems) {
	this.numchamado = numchamado;
	this.unidade = unidade;
	this.data = data;
	this.status = status;
	this.prioridade = prioridade;
	this.codfuncsolic = codfuncsolic;
	this.codfuncatend = codfuncatend;
	this.titulo = titulo;
	this.dataprevisao = dataprevisao;
	this.datafechamento = datafechamento;
	this.mensagems = mensagems;
    }

    @Id

    @Column(name = "numchamado", unique = true, nullable = false)
    public int getNumchamado() {
	return this.numchamado;
    }

    public void setNumchamado(int numchamado) {
	this.numchamado = numchamado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade", nullable = false)
    public Unidade getUnidade() {
	return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
	this.unidade = unidade;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false, length = 13)
    public Date getData() {
	return this.data;
    }

    public void setData(Date data) {
	this.data = data;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
	return this.status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    @Column(name = "prioridade", nullable = false)
    public int getPrioridade() {
	return this.prioridade;
    }

    public void setPrioridade(int prioridade) {
	this.prioridade = prioridade;
    }

    @Column(name = "codfuncsolic", nullable = false)
    public int getCodfuncsolic() {
	return this.codfuncsolic;
    }

    public void setCodfuncsolic(int codfuncsolic) {
	this.codfuncsolic = codfuncsolic;
    }

    @Column(name = "codfuncatend")
    public Integer getCodfuncatend() {
	return this.codfuncatend;
    }

    public void setCodfuncatend(Integer codfuncatend) {
	this.codfuncatend = codfuncatend;
    }

    @Column(name = "titulo", nullable = false, length = 30)
    public String getTitulo() {
	return this.titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataprevisao", length = 13)
    public Date getDataprevisao() {
	return this.dataprevisao;
    }

    public void setDataprevisao(Date dataprevisao) {
	this.dataprevisao = dataprevisao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datafechamento", length = 13)
    public Date getDatafechamento() {
	return this.datafechamento;
    }

    public void setDatafechamento(Date datafechamento) {
	this.datafechamento = datafechamento;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chamadoc")
    public Set getMensagems() {
	return this.mensagems;
    }

    public void setMensagems(Set mensagems) {
	this.mensagems = mensagems;
    }

}
