package br.com.chamado.model;

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


/**
 * @author WandersonSantiago
 */
@ManagedBean(name = "impressora")
@SessionScoped
@Entity
@Table(name = "impressora")
public class Impressora implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ativo")
     private boolean ativo;
    @Column(name = "locada")
    private boolean locada;
    @Column(name = "nome", unique = true,  length = 50)
    private String nome;
    @Column(name = "marca", unique = true, length = 50)
    private String marca;
    @Column(name = "ip", unique = true,  length = 50)
    private int ip;
    @Column(name = "contador",  length = 256)
    private int contador;
    @Column(name = "ordemServico",  length = 50)
    private int ordemServico;
    @ManyToOne
    @JoinColumn(name = "setor")
    private Setor setor;

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

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(int ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isLocada() {
        return locada;
    }

    public void setLocada(boolean locada) {
        this.locada = locada;
    }

    @Override
    public String toString() {
        return "Impressora{" + "id=" + id + ", ativo=" + ativo + ", locada=" + locada + ", nome=" + nome + ", marca=" + marca + ", ip=" + ip + ", contador=" + contador + ", ordemServico=" + ordemServico + ", setor=" + setor + '}';
    }

   

  
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Impressora other = (Impressora) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
