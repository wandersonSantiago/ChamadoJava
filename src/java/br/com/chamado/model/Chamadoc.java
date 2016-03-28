package br.com.chamado.model;

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
import javax.persistence.Transient;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false, length = 13)
    private Date data;
    @ManyToOne
    @JoinColumn(name = "status")
    private Descricao status;
    @ManyToOne
    @JoinColumn(name = "prioridade")
    private Descricao prioridade;
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Descricao categoria;
    @ManyToOne 
    @JoinColumn(name = "tipoChamado")
    private Descricao tipoChamado;
    @ManyToOne
    @JoinColumn(name = "codfuncsolic")
    private Usuario codfuncsolic;
    @ManyToOne
    @JoinColumn(name = "codfuncatend")
    private Usuario codfuncatend;
    @ManyToOne
    @JoinColumn(name = "impressora")
    private Impressora impressora;
    @Column(name = "titulo", length = 30)
    private String titulo;
    @Temporal(TemporalType.TIMESTAMP )
    @Column(name = "dataprevisao", length = 13)
    private Date dataprevisao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datafechamento", length = 13)
    private Date datafechamento;
    @Transient
    private final int ANDAMENTO = 9;
    @Transient
    private final int FECHADO = 11;
    @Transient
    private final int REABERTO = 10;
    @Transient
    private final int ABERTO = 8;
  
    public Chamadoc() {

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

    public Descricao getStatus() {
        return status;
    }

    public void setStatus(Descricao status) {
        this.status = status;
    }

    public Descricao getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Descricao prioridade) {
        this.prioridade = prioridade;
    }

    public Descricao getCategoria() {
        return categoria;
    }

    public void setCategoria(Descricao categoria) {
        this.categoria = categoria;
    }

    public Usuario getCodfuncsolic() {
        return codfuncsolic;
    }

    public void setCodfuncsolic(Usuario codfuncsolic) {
        this.codfuncsolic = codfuncsolic;
    }

    public Usuario getCodfuncatend() {
        return codfuncatend;
    }

    public void setCodfuncatend(Usuario codfuncatend) {
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

    public boolean isChamadoAndamento() {
        return status.getId() == ANDAMENTO;
    }

    public boolean isChamadoFechado() {
        return status.getId() == FECHADO;
    }

    public boolean isChamadoReaberto() {
        return status.getId() == REABERTO;
    }

    public boolean isChamadoAberto() {
        return status.getId() == ABERTO;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public void setImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    public Descricao getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(Descricao tipoChamado) {
        this.tipoChamado = tipoChamado;
    }
    

    public void limpar() {

        this.id = 0;
        this.unidade = null;
        this.data = null;
        this.status = null;
        this.prioridade = null;
        this.categoria = null;
        this.codfuncsolic = null;
        this.codfuncatend = null;
        this.titulo = "";
        this.dataprevisao = null;
        this.datafechamento = null;
        this.tipoChamado =  null;
        this.impressora = null;

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
