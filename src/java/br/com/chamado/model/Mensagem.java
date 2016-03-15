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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@ManagedBean(name = "mensagem")
@SessionScoped
@Entity
@Table(name = "mensagem")

public class Mensagem implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numchamado", nullable = false)
    private int numeChamado;
    @ManyToOne
    @JoinColumn(name = "codfuncautor", nullable = false)
    private Usuario codfuncautor;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", length = 13)
    private Date data;
    @Column(name = "nomearquivo", length = 50)
    private String nomearquivo;
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @Column(name = "texto", nullable = false)
    private String texto;

    public Mensagem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeChamado() {
        return numeChamado;
    }

    public void setNumeChamado(int numeChamado) {
        this.numeChamado = numeChamado;
    }

    public Usuario getCodfuncautor() {
        return codfuncautor;
    }

    public void setCodfuncautor(Usuario codfuncautor) {
        this.codfuncautor = codfuncautor;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomearquivo() {
        return this.nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public void limpar() {
        this.id = 0;
        this.numeChamado = 0;
        this.codfuncautor = null;
        this.data = null;
        this.nomearquivo = "";
        this.arquivo = null;
        this.texto = "";
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Mensagem other = (Mensagem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
