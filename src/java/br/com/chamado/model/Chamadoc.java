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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean(name = "chamadoc")
@SessionScoped
@Entity
@Table(name = "chamadoc")
public class Chamadoc implements java.io.Serializable {

    @Id
    @Column(name = "numchamado", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numchamado;
   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidade", nullable = false)
    private Unidade unidade;*/
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false, length = 13)
    private Date data;
    @Column(name = "status", nullable = false)
    private int status;
    @Column(name = "prioridade", nullable = false)
    private int prioridade;
    /*@Column(name = "codfuncsolic", nullable = false)
    
    private int codfuncsolic;
    @Column(name = "codfuncatend")
    */private Integer codfuncatend;
    
    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataprevisao", length = 13)
    private Date dataprevisao;
    @Temporal(TemporalType.DATE)
    @Column(name = "datafechamento", length = 13)
    private Date datafechamento;
    /*@ManyToMany
    @JoinTable(name="chamadoc_has_mensagem", joinColumns={@JoinColumn(name="chamdo_id")}, inverseJoinColumns={@JoinColumn(name="mensagem_id")})
    private Set<Mensagem> mensagems = new HashSet(0);*/

    public Chamadoc() {
    }

    public int getNumchamado() {
	return this.numchamado;
    }

    public void setNumchamado(int numchamado) {
	this.numchamado = numchamado;
    }
  /*
    public Unidade getUnidade() {
	return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
	this.unidade = unidade;
    }
    */
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
   /*
    public int getCodfuncsolic() {
	return this.codfuncsolic;
    }

    public void setCodfuncsolic(int codfuncsolic) {
	this.codfuncsolic = codfuncsolic;
    }
   */
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

    /*
    public Set getMensagems() {
	return this.mensagems;
    }
    
    public void setMensagems(Set<Mensagem> mensagems) {
	this.mensagems = mensagems;
    }
   */
}
